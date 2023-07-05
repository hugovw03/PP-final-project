package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGen extends NaturalBaseVisitor<String>{

    private String program;

    //container for all the global vars
    private Map<String, Integer> globalMap = new HashMap<>();
    //symbol table for local vars, nested vars
    private NaturalSymbolTable symbolTable = new NaturalSymbolTable();


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
                "prog = [ \n" + newProgram;
        newProgram +=  "       ]\n" +
                "\n" +
                "main = run [prog";
//        for (int i = 0; i < totalThreads; i++) {
//            newprog += ", prog";
//        }
        newProgram += "]";

        return newProgram;
    }


    @Override
    public String visitProgram(NaturalParser.ProgramContext ctx) {
        String result = "";
        for (NaturalParser.StatContext statContext : ctx.stat()) {
            result += visit(statContext);
        }
        program+= result;
        return result;
    }

    @Override
    public String visitDeclGlobalAndLocal(NaturalParser.DeclGlobalAndLocalContext ctx) {
        int position = globalMap.size();
        if (position > 7) {
            System.out.println("visitDeclGlobal: the global decl are too much");
        }
        globalMap.put(ctx.ID().getText(), position);
        visit(ctx.expr());
        String result = "Pop regA, \n";
        result += "WriteInstr regA (DirAddr " + position + "), \n";
//        result += "ReadInstr (DirAddr " + position + "), \n";
//        result += "Receive regB, \n";
//        result += "Compute NEq regA regB regC, \n";
//        result += "Branch regC (Rel (-4)), \n";
//        program += result;
        return result;
    }

    @Override
    public String visitIdExpr(NaturalParser.IdExprContext ctx) {
        String result = "";
        String id = ctx.ID().getText();
        // Check if the Id is a globally defined variable
        if (globalMap.containsKey(id)) {
            // If it is, get it from the shared memory and push it to the stack
            result += "readInstr " + globalMap.get(id) + ", \n";
            result += "Push regA, \n";
        // Check if it is in any enclosing scope
        } else if (symbolTable.containInScope(id)) {
            // If it is, load it from the local memory and push it to the stack
            int offset = symbolTable.offset(id);
            result += "Load (DirAddr " + offset + ") regA, \n";
            result += "Push regA, \n";
        } else {// TODO: throw some error?
            }
//        program += result;
        return result;
    }

    @Override
    public String visitDeclNormal(NaturalParser.DeclNormalContext ctx) {
        String result = "";
        symbolTable.put(ctx.ID().getText(), getThisType(ctx.type().getText()));
        int offset = symbolTable.offset(ctx.ID().getText());
        if (ctx.ASSIGN().getSymbol() == null) {
            result += "Load (ImmValue 0) regA,\n" +
                      "Store  regA (DirAddr " + offset + "),\n";
        }
        else {
            result += visit(ctx.expr());
            result += "Pop regA, \n" +
                      "Store  regA (DirAddr " + offset + "),\n";
        }
//        program += result;
        return result;
    }

    private Type getThisType(String type) {
        if (type.equals("Int")) {
            return Type.INT;
        } else if (type.equals("Bool")) {
            return Type.BOOL;
        }
        else {
            throw new IllegalArgumentException ("getThisType: This input is not valid type");
        }
    }

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
            //TODO: throw error
        }
        result += "Push regA,\n";
//        program += result;
        return result;
    }


    @Override
    public String visitWhileStat(NaturalParser.WhileStatContext ctx) {
        String result = "";
        String expr = visit(ctx.expr());
        int numLinesExpr = expr.split("\n").length;
        String stat = visit(ctx.stat());
        // If the while has no body
        if (stat == null) {
            // Do nothing
        } else {
            int numLinesStat = stat.split("\n").length + 2;
            result += expr;
            // Pop the result of the expr
            result += "Pop regA, \n";
            result += "Compute Equal reg0 regA regA, \n";
            //If its true we add the while body
            // TODO: change the way we put a value into regA or let true be 0 and false be 1, because in the current implementation if it is true we will put value 1 into regA and we will branch over the code while we do want to execute it.
            result += "Branch regA, (Rel " + numLinesStat + "),\n ";
            result += stat;
            // Because it is a while loop we jump back to checking the condition
            result += "Jump relative " + -(numLinesStat + numLinesExpr + 2) + ",\n";
        }
//        program += result;
        return result;
    }

    @Override
    public String visitParallelStat(NaturalParser.ParallelStatContext ctx) {
        return super.visitParallelStat(ctx);
    }

    //visit every stat in this block
    @Override
    public String visitBlock(NaturalParser.BlockContext ctx) {
        String result = "";
        this.symbolTable.openScope();
        for (NaturalParser.StatContext statContext : ctx.stat()) {
            result += visit(statContext);
        }
        this.symbolTable.closeScope();

        return result;
    }

    @Override
    public String visitPrintStat(NaturalParser.PrintStatContext ctx) {
        return super.visitPrintStat(ctx);
    }

    @Override
    public String visitParExpr(NaturalParser.ParExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitNotExpr(NaturalParser.NotExprContext ctx) {
        String result = visit(ctx.expr());
        result += "Pop regA, \n";
        result += "Compute Equal reg0 regA regA, \n";
        result += "Push regA, \n";
        return result;
    }







    @Override
    public String visitLockStat(NaturalParser.LockStatContext ctx) {
        return super.visitLockStat(ctx);
    }

    /*-------------------------------------------------
                Logical Operation
    -------------------------------------------------*/

    @Override
    public String visitCompExpr(NaturalParser.CompExprContext ctx) {

        String result = visit(ctx.expr(0));
        result += "Pop regC,\n";
        result += visit(ctx.expr(1));
        result += "Pop regD,\n";
        result += "Push regC,\n Push regD,\n";
        result += "Pop regB, \nPop regA, \n";

//        String result = "Pop regB, \nPop regA, \n";
//        String left = visit(ctx.expr(0));
//        visit(ctx.expr(1));
//        System.out.println(left);

        String op = ctx.getChild(1).getText();
        switch (op) {
            case "IsBiggerThan" :
                result += "Compute Gt regA regB regA, \n";
                break;
            case "IsSmallerThan":
                result += "Compute Lt regA regB regA, \n";
                break;
            case "IsEqualTo":
                result += "Compute Equal regA regB regA, \n";
                break;
            case "IsNotEqualTo":
                result += "Compute NEq regA regB regA, \n";
                break;
            case "IsBiggerThanOrEqualTo":
                result += "Compute GtE regA regB regA, \n";
                break;
            case "IsSmallerThanOrEqualTo":
                result += "Compute LtE regA regB regA, \n";
                break;
        }
        result += "Push regA, \n";
//        program += result;

        return result;

    }

    //TODO: both statement is triggered
    @Override
    public String visitIfStat(NaturalParser.IfStatContext ctx) {
        String result= visit(ctx.expr());

        // Check if the condition is true or false
        result += "Pop regA, \n";
        //TODO: if statement with no else
        // Keep track of how many instructions the else statement is
        String leftInput = visit(ctx.stat(0));
        System.out.println("left: " + leftInput);
        String rightInput = visit(ctx.stat(1));
        System.out.println("right: " + rightInput);


        //visit compare at last to make sure the rA contains the boolean


        //set the pointer to the next instruction +1
        int trueCase  = leftInput.split("\n").length + 1;
        //skip the jump instruction +1
        int falseCase = rightInput.split("\n").length + 2;

        // Branch -> Else -> Jump -> True stat
        // If the result was true, branch over the else statement. If it was false, dont branch and add the else statement code to the result
        result += "Branch regA (Rel " + falseCase + "),\n ";

        //add Else part
        result += rightInput;

        //if false, the true part is skipped
        result += "Jump (Rel " + trueCase + "),";

        //True part, which can only be triggered by branch -> true
        result += leftInput;

//        program += result;
        return result;
    }

    /*-------------------------------------------------
                    Binary Operation
    -------------------------------------------------*/
    //Handle Multiplication
    @Override
    public String visitMultExpr(NaturalParser.MultExprContext ctx) {
        String result = visit(ctx.expr(0));
        result += visit(ctx.expr(1));
        result += "Pop regB,\n" +
                        "Pop regA,\n" +
                        "Compute Mul regA regB regA, \n" +
                        "Push regA, \n";
//        program += result;
        return  result;
    }

    //Handle Add & Minus
    @Override
    public String visitAddExpr(NaturalParser.AddExprContext ctx) {
        // Generate code for the left&right subexpression


        String result = visit(ctx.expr(0));
        result += visit(ctx.expr(1));
        result += "Pop regB, \n";
        result += "Pop regA, \n";

        switch (ctx.op().getText()) {
            case "+" -> result += "Compute Add regA regB regA, \n";
            case "-" -> result += "Compute Sub regA regB regA, \n";
        }
        result += "Push regA, \n";
//        program += result;
        return result;
    }

    //Load constant Expr
    @Override
    public String visitConstExpr(NaturalParser.ConstExprContext ctx) {
        String result;
        String text = ctx.getText();
        //Assign Boolean to 1 if True
        if (text.equals("True")){
            result = "Load (ImmValue 1) regA,\nPush regA, \n";
        }
        else if (text.equals("False")) {
            result = "Load (ImmValue 0) regA,\nPush regA, \n";
        }
        //Otherwise it will be Constant, type checked in listener
        else if (text.endsWith("negative")) {
            result = "Load (ImmValue (-"+ text.substring(0, text.length() - "negative".length())  +")) regA,\nPush regA, \n";
        }
        else result = "Load (ImmValue " + ctx.getText() + ") regA,\nPush regA, \n";
//        program += result;
        return result;
    }
}
