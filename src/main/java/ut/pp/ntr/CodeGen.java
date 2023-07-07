package ut.pp.ntr;

import main.antlr4.ut.pp.parser.NaturalBaseVisitor;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.tree.ParseTree;


import java.util.*;

public class CodeGen extends NaturalBaseVisitor<String> {

    private String program;
    private int threadPointer = 1;

    //collect thread amount in each parallel
    private final List<Integer> threadCounter = new ArrayList<>();
    //collect parallel blocks
    private final List<String> parallelCode = new ArrayList<>();
    //container for all the global vars
    private final Map<String, Integer> globalMap = new HashMap<>();
    //symbol table for local vars, nested vars
    private final NaturalSymbolTable symbolTable = new NaturalSymbolTable();


    public String generate(ParseTree tree) {
        this.program = "";
        tree.accept(this);
        String[] split = this.program.split("\n");
        String newProgram = "";
        for(String s:split){
            newProgram += "       " + s + "\n";
        }
        newProgram =   "import Sprockell\n" +
                "\n" +
                "prog :: [Instruction]\n" +
                "prog = [ \n" + newProgram + "       EndProg\n";
        newProgram +=  "       ]\n" +
                "\n" +
                "main = run [prog";
        int threadSum = threadPointer -1;
        for (int i = 0; i < threadSum; i++) {
            newProgram += ", prog";
        }
        newProgram += "]";

        return newProgram;
    }

    /*-------------------------------------------------
                     Structure Creation
    -------------------------------------------------*/
    @Override
    public String visitProgram(NaturalParser.ProgramContext ctx) {
        String result = "";
        String seqCode = "";
        //sequential part
        for (NaturalParser.StatContext statContext : ctx.stat()) {
            seqCode += visit(statContext);
        }
        //if there are parallel blocks
        if (parallelCode.size() != 0) {
            // get the amount of parallel blocks we want to run
            int parallelBlocks = parallelCode.size();

            result += seqCode;

            ArrayList<Integer> parallelLength = new ArrayList<>();
            //calculating the length of each parallel block
            for (String s : parallelCode) {
                int length = (s.split("\n")).length;
                parallelLength.add(length);
            }
            int parallelTotalLength = 0;
            // calculate the total length of the parallel block, which we will place at the bottom of the code
            for (int i : parallelLength) {
                parallelTotalLength += i;
            }


            //Let the main thread jump over the parallel part
            result += "Jump (Rel " + (parallelTotalLength + 1 + 5 * parallelBlocks) + "), \n";


            //The part that lets the threads loop
            String parallelStarter = "ReadInstr (IndAddr regSprID),\n" +
                    "Receive regD, \n" +
                    "Compute Equal regD reg0 regE, \n" +
                    "Branch regD (Rel (-3)), \n";

            //Collecting parallel blocks
            String parallelResult = "";
            int sum = 0;
            for (int i = 0; i < parallelCode.size(); i++) {
                parallelResult += parallelStarter;
                parallelResult += parallelCode.get(i);
                for (int j = i + 1; j < parallelCode.size(); j++) {
                    sum += (parallelCode.get(j).split("\n")).length + 5;
                }
                parallelResult += "Jump (Rel " + (sum + 1) + "), \n";
                sum = 0;
            }

            //at this moment, result contains everything except Header
            result += parallelResult;

            //Collect sequential codes
            String headerResult = "";

            int seqLength = (seqCode.split("\n")).length;
            int headerSum;
            // calculate how many lines the sequential code is, so that we can jump over it
            int something = 0;
            for (int i = 0; i < parallelLength.size(); i++) {
                headerSum = parallelBlocks - i + 1;
                for (int j = i + 1; j < parallelCode.size(); j++) {
                    something += (parallelCode.get(j).split("\n")).length + 5;
                }
                //for each parallel blocks, we create new threads
                headerResult += "Branch regSprID (Rel " + (headerSum + seqLength + something) + "), \n";
                something = 0;
            }

            //glue header and parallel instructions
            String finalResult = headerResult + result;
            program += finalResult;
            return result;
        }
        //if there is no parallel block
        else {
            program += seqCode;
            return seqCode;
        }
    }

    @Override
    public String visitBlock(NaturalParser.BlockContext ctx) {
        String result = "";
        //When enter a block, open a scope
        this.symbolTable.openScope();
        //traverse each statement in this block
        for (NaturalParser.StatContext statContext : ctx.stat()) {
            result += visit(statContext);
        }
        this.symbolTable.closeScope();
        return result;
    }


    /*-------------------------------------------------
                        Assign Value
    -------------------------------------------------*/
    @Override
    //Load constant Expr
    public String visitConstExpr(NaturalParser.ConstExprContext ctx) {
        String result;
        String text = ctx.getText();
        //Assign Boolean to 1 if True
        if (text.equals("True")){
            result = "Load (ImmValue 1) regA, \nPush regA, \n";
        }
        else if (text.equals("False")) {
            result = "Load (ImmValue 0) regA, \nPush regA, \n";
        }
        //Otherwise it will be Constant, type checked in listener
        else if (text.endsWith("negative")) {
            result = "Load (ImmValue (-"+ text.substring(0, text.length() - "negative".length())  +")) regA, \nPush regA, \n";
        }
        else {
            result = "Load (ImmValue " + ctx.getText() + ") regA, \nPush regA, \n";
        }
        return result;
    }

    //Assign value to variable
    @Override
    public String visitAssignToVar(NaturalParser.AssignToVarContext ctx) {
        String result = visit(ctx.expr()) ;
        result += "Pop regA, \n";
        int offset;
        // Question: if we have a situation like "Int a = 10;Int b = 20;Int c = 30; {Int d = 40; a = 20;}"
        // global table get first or symbolTable
        // where we declare Int a in a scope and in the inner scope we redifine a, do we overwrite the original value of a or do we just create a new variable a where the value is equal to 20 instead of 10 but in the outer scope the value is still equal to 10?\
        if (symbolTable.containInScope(ctx.ID().getText())){
            offset = symbolTable.offset(ctx.ID().getText());
            result += "Store regA (DirAddr " + offset + "), \n";
        } else if (globalMap.containsKey(ctx.ID().getText())){
            offset = globalMap.get(ctx.ID().getText());
            result += "WriteInstr regA (DirAddr " + offset + "), \n";
        }else {
            throw new IllegalArgumentException("The variable is not defined");
        }
        result += "Push regA, \n";
        return result;
    }

    @Override
    public String visitIdExpr(NaturalParser.IdExprContext ctx) {
        String result = "";
        String id = ctx.ID().getText();
        // Check if the id is a globally defined variable
        if (globalMap.containsKey(id)) {
            // If it is, get it from the shared memory and push it to the stack
            result += "ReadInstr (DirAddr " + globalMap.get(id) + "), \n";
            result += "Receive regA, \n"
                    + "Push regA, \n";

            // Check if it is in any enclosing scope
        } else if (symbolTable.containInScope(id)) {
            // If it is, load it from the local memory and push it to the stack
            int offset = symbolTable.offset(id);
            result += "Load (DirAddr " + offset + ") regA, \n";
            result += "Push regA, \n";
        } else {
            throw new IllegalArgumentException("The variable is not defined");
        }
        return result;
    }

    @Override
    public String visitDeclNormal(NaturalParser.DeclNormalContext ctx) {
        String result = "";
        symbolTable.put(ctx.ID().getText(), getThisType(ctx.type().getText()));
        int offset = symbolTable.offset(ctx.ID().getText());
        //if no value assigned, set it to 0/False
        if (ctx.ASSIGN() == null) {
            result += "Load (ImmValue 0) regA, \n"
                    + "Store regA (DirAddr " + offset + "), \n";
        }
        else {
            result += visit(ctx.expr());
            result += "Pop regA, \n"
                    + "Store regA (DirAddr " + offset + "), \n";
        }
        return result;
    }

    @Override
    public String visitDeclGlobal(NaturalParser.DeclGlobalContext ctx) {
        String result = "";
        String id = ctx.ID().getText();
        //global value stores in sheMem for slot 4 - 7
        int position = 4 + globalMap.size();
        if (globalMap.containsKey(id)) {
            position = globalMap.get(id);
        }
        if (position > 7) {
            System.out.println("visitDeclGlobal: share memory overflow");
            throw new RuntimeException("share memory overflow");
        }
        //if it's not assigned with value, we simply put the offset into shMem
        // we consider it's a lock with unlock mode or a var with value 0
        if (ctx.ASSIGN() == null) {
            globalMap.put(id, position);
            System.out.println(globalMap.keySet());
            return "";
        }
        else {
            //put global id into shareMemory map
            globalMap.put(id, position);
            result += visit(ctx.expr());

            result += "Pop regA, \n"
                    + "WriteInstr regA (DirAddr " + position + "), \n";
        }
        return result;
    }

    //Helper function, for assign values
    private Type getThisType(String type) {
         switch (type) {
            case "Int" :
                return Type.INT;
            case "Bool":
                return Type.BOOL;
            case "Lock":
                throw new IllegalArgumentException("getThisType: The lock must be declare as Global");
             default :
                throw new IllegalArgumentException("getThisType: This input is not valid type");

        }
    }


    /*-------------------------------------------------
                Logical Operation
    -------------------------------------------------*/
    @Override
    public String visitCompExpr(NaturalParser.CompExprContext ctx) {
        String result = "";
        //check LHS
        result += visit(ctx.expr(0));
        result += "Pop regC, \n";
        //check RHS
        result += visit(ctx.expr(1));
        result += "Pop regD, \n"
                + "Push regC, \nPush regD, \n"
                + "Pop regB, \nPop regA, \n";

        String op = ctx.getChild(1).getText();
        switch (op) {
            case "IsBiggerThan" :
                result += "Compute Gt regA regB regA, \n";
                break;
            case "IsSmallerThan" :
                result += "Compute Lt regA regB regA, \n";
                break;
            case "IsEqualTo" :
                result += "Compute Equal regA regB regA, \n";
                break;
            case "IsNotEqualTo" :
                result += "Compute NEq regA regB regA, \n";
                break;
            case "IsBiggerThanOrEqualTo" :
                result += "Compute GtE regA regB regA, \n";
                break;
            case "IsSmallerThanOrEqualTo" :
                result += "Compute LtE regA regB regA, \n";
                break;
        }
        result += "Push regA, \n";
        return result;
    }

    @Override
    public String visitNotExpr(NaturalParser.NotExprContext ctx) {
        String result = visit(ctx.expr());
        result += "Pop regA, \n";
        result += "Compute Equal reg0 regA regA, \n";
        result += "Push regA, \n";
        return result;
    }

    //Handle If Statement
    @Override
    public String visitIfStat(NaturalParser.IfStatContext ctx) {
        String result= visit(ctx.expr());

        // Check if the condition is true or false
        result += "Pop regA, \n";
        if (ctx.stat(1) == null) {
            String leftInput = visit(ctx.stat(0));
            int trueCase  = leftInput.split("\n").length + 1;
            result += "Compute Equal reg0 regA regA,\n";
            result += "Branch regA (Rel " + trueCase + "),\n";
            result += leftInput;
            return result;
        }
        String leftInput = visit(ctx.stat(0));
        String rightInput = visit(ctx.stat(1));

        //set the pointer to the next instruction +1
        int trueCase  = leftInput.split("\n").length + 1;
        //skip the jump instruction +1
        int falseCase = rightInput.split("\n").length + 2;

        //Structure: Branch -> Else -> Jump -> True stat
        //If true, branch over the else statement.
        //If false, don't branch and add the else statement code to the result
        result += "Branch regA (Rel " + falseCase + "),\n";

        //add Else part
        result += rightInput;

        //if false, the true part is skipped
        result += "Jump (Rel " + trueCase + "), \n";

        //True part, which can only be triggered by branch -> true
        result += leftInput;
        return result;
    }

    @Override
    public String visitWhileStat(NaturalParser.WhileStatContext ctx) {
        String result = "";

        //visit comparison
        String compareExpr = visit(ctx.expr());
        int numLinesExpr = compareExpr.split("\n").length;

        //visit while block
        String whileStat = visit(ctx.stat());
        if (whileStat == null) {
            // Do nothing
        } else {
            int numLinesStat = whileStat.split("\n").length + 2;

            //Structure: compareExpr -> Branch -> whileBlock -> JumpBack => compareExpr
            result += compareExpr;

            //Negate the boolean on the stack, for use of branch
            result += "Pop regA,\n";
            result += "Compute Equal reg0 regA regA,\n";

            //Start Branch
            result += "Branch regA (Rel " + numLinesStat + "),\n ";
            result += whileStat;

            //Jump back to checking the condition
            result += "Jump (Rel (-" + (numLinesStat + numLinesExpr + 3) + ")),\n";
        }
        return result;
    }


    /*-------------------------------------------------
                    Binary Operation
    -------------------------------------------------*/
    @Override
    //Handle Multiplication
    public String visitMultExpr(NaturalParser.MultExprContext ctx) {
        String result = visit(ctx.expr(0));
        result += visit(ctx.expr(1));
        result +=   "Pop regB, \n" +
                    "Pop regA, \n" +
                    "Compute Mul regA regB regA, \n" +
                    "Push regA, \n";
        return  result;
    }

    @Override
    //Handle Add & Minus Expr
    public String visitAddExpr(NaturalParser.AddExprContext ctx) {
        // Generate code for the left&right subexpression
        String result = visit(ctx.expr(0));
        result += visit(ctx.expr(1));
        result += "Pop regB, \n";
        result += "Pop regA, \n";

        switch (ctx.op().getText()) {
            case "+" :
                result += "Compute Add regA regB regA, \n";
                break;
            case "-" :
                result += "Compute Sub regA regB regA, \n";
                break;
        }
        result += "Push regA, \n";
        return result;
    }

    @Override
    public String visitParExpr(NaturalParser.ParExprContext ctx) {
        return visit(ctx.expr());
    }


    /*-------------------------------------------------
                    Concurrency
    -------------------------------------------------*/
    @Override
    public String visitPrintStat(NaturalParser.PrintStatContext ctx) {
        String result = "";
        result += visit(ctx.expr());
        result += "Pop regA, \n";
        result += "WriteInstr regA numberIO, \n";
        return result;
    }

    @Override
    public String visitLockStat(NaturalParser.LockStatContext ctx) {
        String result = "";
        // Get the id of the lock
        String id = ctx.ID().getText();
        // get the address of the lock
        int address = globalMap.get(id);
        // If we want to lock the lock
        if (Objects.equals(ctx.lockStatus().getText(), "lock")) {
            // We check what is in the shared memory. If we get a 1 from the shared memory,
            // we loop back and keep checking it until it is set to 0.
            // If it is 0 we set it to 1 and continue with the code
            result += "TestAndSet (DirAddr " + address + "), \n";
            result += "Receive regA, \n";
            result += "Compute Equal reg0 regA regA,\n";
            result += "Branch regA (Rel (-3)), \n";
            result += "Load (ImmValue 1) regA, \n";
            result += "WriteInstr regA (DirAddr " + address + "), \n";
        } else {
            result += "WriteInstr reg0 (DirAddr " + address + "), \n";
        }
        return result;
    }

    @Override
    public String visitParallelStat(NaturalParser.ParallelStatContext ctx) {
        String result = "";
        //save info for generating parallel instruction
        threadCounter.add(Integer.parseInt(ctx.expr().getText()));
        result += visit(ctx.stat());
        parallelCode.add(result);

        String trigger = "";
        //set trigger to each thread
        for (int k = 0; k < threadCounter.get(threadCounter.size()-1); k ++) {
             trigger += "WriteInstr regA (DirAddr "+ threadPointer + "),\n";
            threadPointer += 1;
        }
        return trigger;
    }
}


