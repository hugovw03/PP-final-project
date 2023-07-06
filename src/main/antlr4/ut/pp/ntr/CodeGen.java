package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;


import java.util.*;

public class CodeGen extends NaturalBaseVisitor<String>{
    private int totalNumberOfLines = 0;
    private int largestAmountOfThreads = 0;
    private String program;
    //container for all the locks
    //TODO:?
    private final Map<String, Integer> lockMap = new HashMap<>();
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
                "prog = [ \n" + newProgram;
        newProgram +=  "       ]\n" +
                "\n" +
                "main = run [prog";
//        for (int i = 0; i < totalThreads; i++) {
//            newprog += ", prog";
//        }
        newProgram += "EndProg\n]";

        return newProgram;
    }

    /*-------------------------------------------------
                     Structure Creation
    -------------------------------------------------*/
    @Override
    public String visitProgram(NaturalParser.ProgramContext ctx) {
        // The start of every program, that checks if the thread is the main thread and if it is skips over the waiting loop and if it is not waits until it gets called
        String result =
                "Branch regSprID (Rel 2),\n" +
                        "Jump (Rel 5), \n" +
                        "ReadInstr (IndAddr regSprID), \n" +
                        "Receive regD, \n" +
                        "Compute Equal regD reg0 regE, \n" +
                        "Branch regE (Rel (-3)), \n" +
                        "Branch regSprID (Rel 2),\n" +
                        "Jump (Rel 2), \n" +
                        "Jump (Rel regC), \n";
        //sequential part
        for (NaturalParser.StatContext statContext : ctx.stat()) {
            if (statContext.getText().contains("RunInParallel")) {
                totalNumberOfLines = result.split("\n").length;
            }
            result += visit(statContext);
        }
        totalNumberOfLines = result.split("\n").length;
        result += "Load (ImmValue " + (totalNumberOfLines + largestAmountOfThreads - 2) + " ) regC, \n";
        for (int i = 1; i <= largestAmountOfThreads; i++) {
            result += "WriteInstr regC (DirAddr " + i + "), \n";
        }
        program += result;
        return result;
    }

    @Override
    public String visitParallelStat(NaturalParser.ParallelStatContext ctx) {
        String result = "";
        int threadCounter = Integer.parseInt(ctx.expr().getText());
        if (threadCounter > largestAmountOfThreads){
            largestAmountOfThreads = threadCounter;
        }
        for (int i = 1; i  <= threadCounter; i++) {
            // Put the relative location of where they have to jump to in the corresponding register in shared memory.
            result += "Load (ImmValue " + (totalNumberOfLines - 3) + ") regC, \n";
            result += "WriteInstr regC (DirAddr " + i + "), \n";
        }
        String parallelBlock = visit(ctx.stat());
        result += "Jump (Rel "+ (parallelBlock.split("\n").length + 2 + threadCounter) +"), \n";

        result += parallelBlock;
        for (int i = 1; i <= threadCounter; i++) {
            result += "WriteInstr reg0 (DirAddr "+i+"), \n";
        }
        result += "Jump (Abs 3), \n";
        return result;
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
//            result += "ReadInstr (DirAddr " + offset + "), \n";
//            result += "Receive regB, \n";
//            result += "Compute NEq regA regB regC, \n";
//            result += "Branch regC (Rel (-4)), \n";
        }else {
            //TODO: throw error
        }
        result += "Push regA, \n";

        return result;
    }

    @Override
    public String visitIdExpr(NaturalParser.IdExprContext ctx) {
        String result = "";
        String id = ctx.ID().getText();

        // Check if the Id is a globally defined variable
        if (globalMap.containsKey(id)) {

            // If it is, get it from the shared memory and push it to the stack
            result += "ReadInstr (DirAddr " + globalMap.get(id) + "), \n";
            result += "Push regA, \n";

            // Check if it is in any enclosing scope
        } else if (symbolTable.containInScope(id)) {

            // If it is, load it from the local memory and push it to the stack
            int offset = symbolTable.offset(id);
            result += "Load (DirAddr " + offset + ") regA, \n";
            result += "Push regA, \n";
        } else {// TODO: throw some error?
        }
        return result;
    }

    @Override
    public String visitDeclNormal(NaturalParser.DeclNormalContext ctx) {
        String result = "";
        symbolTable.put(ctx.ID().getText(), getThisType(ctx.type().getText()));
        int offset = symbolTable.offset(ctx.ID().getText());
        if (ctx.ASSIGN().getSymbol() == null) {
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
//        result += "ReadInstr (DirAddr " + position + "), \n";
//        result += "Receive regB, \n";
//        result += "Compute NEq regA regB regC, \n";
//        result += "Branch regC (Rel (-4)), \n";
//        program += result;
        return result;
    }

    //Helper function, for assign values
    private Type getThisType(String type) {
        if (type.equals("Int")) {
            return Type.INT;
        } else if (type.equals("Bool")) {
            return Type.BOOL;
        } else if (type.equals("Lock")) {
            throw new IllegalArgumentException ("getThisType: The lock must be declare as Global");
        }
        else {
            throw new IllegalArgumentException ("getThisType: This input is not valid type");
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
        //TODO: if statement with no else
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
            case "+" -> result += "Compute Add regA regB regA, \n";
            case "-" -> result += "Compute Sub regA regB regA, \n";
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
        return super.visitPrintStat(ctx);
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


}

//package main.antlr4.ut.pp.ntr;
//
//import org.antlr.v4.runtime.tree.ParseTree;
//
//
//import java.util.*;
//
//public class CodeGen extends NaturalBaseVisitor<String>{
//
//    private String program;
//    private int threadCounter;
//    private final List<String> parallelCode = new ArrayList<>();
//    //container for all the locks
//    //TODO:?
//    private final Map<String, Integer> lockMap = new HashMap<>();
//    //container for all the global vars
//    private final Map<String, Integer> globalMap = new HashMap<>();
//    //symbol table for local vars, nested vars
//    private final NaturalSymbolTable symbolTable = new NaturalSymbolTable();
//
//
//    public String generate(ParseTree tree) {
//        this.program = "";
//        tree.accept(this);
//        String[] split = this.program.split("\n");
//        String newProgram = "";
//        for(String s:split){
//            newProgram += "       " + s + "\n";
//        }
//        newProgram =   "import Sprockell\n" +
//                "\n" +
//                "prog :: [Instruction]\n" +
//                "prog = [ \n" + newProgram;
//        newProgram +=  "       ]\n" +
//                "\n" +
//                "main = run [prog";
////        for (int i = 0; i < totalThreads; i++) {
////            newprog += ", prog";
////        }
//        newProgram += "EndProg\n]";
//
//        return newProgram;
//    }
//
//    /*-------------------------------------------------
//                     Structure Creation
//    -------------------------------------------------*/
//    @Override
//    public String visitProgram(NaturalParser.ProgramContext ctx) {
//        String result = "";
//        String seqCode = "";
//        //sequential part
//        for (NaturalParser.StatContext statContext : ctx.stat()) {
//            seqCode += visit(statContext);
//        }
//        if (parallelCode.size() != 0) {
//            // get the amount of parallel blocks we want to run
//            int parallelBlocks = parallelCode.size();
//
//            result += seqCode;
//
//            ArrayList<Integer> parallelLength = new ArrayList<>();
//            //calculating the length of each parallel block
//            for (String s : parallelCode) {
//                int length = (s.split("\n")).length;
//                parallelLength.add(length);
//            }
//            int parallelTotalLength = 0;
//            // calculate the total length of the parallel block, which we will place at the bottom of the code
//            for (int i : parallelLength) {
//                parallelTotalLength += i;
//            }
//
//
//            //Let the main thread jump over the parallel part
//            result += "Jump (Rel " + (parallelTotalLength + 1 + 5 * parallelBlocks) + "), \n";
//
//
//            //The part that lets the threads loop
//            String parallelStarter = "ReadInstr (IndAddr regSprID), \n" +
//                    "Receive regD, \n" +
//                    "Compute Equal regD reg0 regE, \n" +
//                    "Branch regD (Rel (-3)), \n";
//
//            String parallelResult = "";
//            int sum = 0;
//            for (int i = 0; i < parallelCode.size(); i++) {
//                parallelResult += parallelStarter;
//                parallelResult += parallelCode.get(i);
//                for (int j = i + 1; j < parallelCode.size(); j++) {
//                    sum += (parallelCode.get(j).split("\n")).length + 5;
//                }
//                parallelResult += "Jump (Rel " + (sum + 1) + "), \n";
//                sum = 0;
//            }
//            //at this moment, result contains everything except Header
//            result += parallelResult;
//
//
//            String headerResult = "";
//
//            int seqLength = (seqCode.split("\n")).length;
//            int headerSum = 0;
//            // calculate how many lines the sequential code is, so that we can jump over it
////        seqLength = seqCode.split("\n").length;
//            int something = 0;
//            // Branch over the sequential part to the wait sequence of code if the branch is not the main branch
//            String branchStarter = "Branch regSprID (Rel " + seqLength + "), \n";
//            for (int i = 0; i < parallelLength.size(); i++) {
//                headerSum = parallelBlocks - i + 1;
//                for (int j = i + 1; j < parallelCode.size(); j++) {
//                    something += (parallelCode.get(j).split("\n")).length + 5;
//                }
//                headerResult += "Branch regSprID (Rel " + (headerSum + seqLength + something) + "), \n";
//                something = 0;
//            }
//
//
//// +5 each   -> + 1
//
//            String finalResult = headerResult + result;
//            program += finalResult;
//            return result;
//        }
//        else {
//            program += seqCode;
//            return seqCode;
//        }
//    }
//
//    @Override
//    public String visitBlock(NaturalParser.BlockContext ctx) {
//        String result = "";
//        //When enter a block, open a scope
//        this.symbolTable.openScope();
//        //traverse each statement in this block
//        for (NaturalParser.StatContext statContext : ctx.stat()) {
//            result += visit(statContext);
//        }
//        this.symbolTable.closeScope();
//        return result;
//    }
//
//
//    /*-------------------------------------------------
//                        Assign Value
//    -------------------------------------------------*/
//    @Override
//    //Load constant Expr
//    public String visitConstExpr(NaturalParser.ConstExprContext ctx) {
//        String result;
//        String text = ctx.getText();
//        //Assign Boolean to 1 if True
//        if (text.equals("True")){
//            result = "Load (ImmValue 1) regA, \nPush regA, \n";
//        }
//        else if (text.equals("False")) {
//            result = "Load (ImmValue 0) regA, \nPush regA, \n";
//        }
//        //Otherwise it will be Constant, type checked in listener
//        else if (text.endsWith("negative")) {
//            result = "Load (ImmValue (-"+ text.substring(0, text.length() - "negative".length())  +")) regA, \nPush regA, \n";
//        }
//        else {
//            result = "Load (ImmValue " + ctx.getText() + ") regA, \nPush regA, \n";
//        }
//        return result;
//    }
//
//    //Assign value to variable
//    @Override
//    public String visitAssignToVar(NaturalParser.AssignToVarContext ctx) {
//        String result = visit(ctx.expr()) ;
//        result += "Pop regA, \n";
//        int offset;
//        // Question: if we have a situation like "Int a = 10;Int b = 20;Int c = 30; {Int d = 40; a = 20;}"
//        // global table get first or symbolTable
//        // where we declare Int a in a scope and in the inner scope we redifine a, do we overwrite the original value of a or do we just create a new variable a where the value is equal to 20 instead of 10 but in the outer scope the value is still equal to 10?\
//        if (symbolTable.containInScope(ctx.ID().getText())){
//            offset = symbolTable.offset(ctx.ID().getText());
//            result += "Store regA (DirAddr " + offset + "), \n";
//        } else if (globalMap.containsKey(ctx.ID().getText())){
//            offset = globalMap.get(ctx.ID().getText());
//            result += "WriteInstr regA (DirAddr " + offset + "), \n";
//            result += "ReadInstr (DirAddr " + offset + "), \n";
//            result += "Receive regB, \n";
//            result += "Compute NEq regA regB regC, \n";
//            result += "Branch regC (Rel (-4)), \n";
//        }else {
//            //TODO: throw error
//        }
//        result += "Push regA, \n";
//
//        return result;
//    }
//
//    @Override
//    public String visitIdExpr(NaturalParser.IdExprContext ctx) {
//        String result = "";
//        String id = ctx.ID().getText();
//
//        // Check if the Id is a globally defined variable
//        if (globalMap.containsKey(id)) {
//
//            // If it is, get it from the shared memory and push it to the stack
//            result += "ReadInstr (DirAddr " + globalMap.get(id) + "), \n";
//            result += "Push regA, \n";
//
//            // Check if it is in any enclosing scope
//        } else if (symbolTable.containInScope(id)) {
//
//            // If it is, load it from the local memory and push it to the stack
//            int offset = symbolTable.offset(id);
//            result += "Load (DirAddr " + offset + ") regA, \n";
//            result += "Push regA, \n";
//        } else {// TODO: throw some error?
//        }
//        return result;
//    }
//
//    @Override
//    public String visitDeclNormal(NaturalParser.DeclNormalContext ctx) {
//        String result = "";
//        symbolTable.put(ctx.ID().getText(), getThisType(ctx.type().getText()));
//        int offset = symbolTable.offset(ctx.ID().getText());
//        if (ctx.ASSIGN().getSymbol() == null) {
//            result += "Load (ImmValue 0) regA, \n"
//                    + "Store regA (DirAddr " + offset + "), \n";
//        }
//        else {
//            result += visit(ctx.expr());
//            result += "Pop regA, \n"
//                    + "Store regA (DirAddr " + offset + "), \n";
//        }
//        return result;
//    }
//
//    @Override
//    public String visitDeclGlobal(NaturalParser.DeclGlobalContext ctx) {
//        String result = "";
//        String id = ctx.ID().getText();
//        //global value stores in sheMem for slot 4 - 7
//        int position = 4 + globalMap.size();
//        if (globalMap.containsKey(id)) {
//            position = globalMap.get(id);
//        }
//        if (position > 7) {
//            System.out.println("visitDeclGlobal: share memory overflow");
//        }
//        //if it's not assigned with value, we simply put the offset into shMem
//        // we consider it's a lock with unlock mode or a var with value 0
//        if (ctx.ASSIGN() == null) {
//            globalMap.put(id, position);
//            System.out.println(globalMap.keySet());
//            return "";
//        }
//        else {
//            //put global id into shareMemory map
//            globalMap.put(id, position);
//            result += visit(ctx.expr());
//
//            result += "Pop regA, \n"
//                    + "WriteInstr regA (DirAddr " + position + "), \n";
//        }
////        result += "ReadInstr (DirAddr " + position + "), \n";
////        result += "Receive regB, \n";
////        result += "Compute NEq regA regB regC, \n";
////        result += "Branch regC (Rel (-4)), \n";
////        program += result;
//        return result;
//    }
//
//    //Helper function, for assign values
//    private Type getThisType(String type) {
//        if (type.equals("Int")) {
//            return Type.INT;
//        } else if (type.equals("Bool")) {
//            return Type.BOOL;
//        } else if (type.equals("Lock")) {
//            throw new IllegalArgumentException ("getThisType: The lock must be declare as Global");
//        }
//        else {
//            throw new IllegalArgumentException ("getThisType: This input is not valid type");
//        }
//    }
//
//
//    /*-------------------------------------------------
//                Logical Operation
//    -------------------------------------------------*/
//    @Override
//    public String visitCompExpr(NaturalParser.CompExprContext ctx) {
//        String result = "";
//        //check LHS
//        result += visit(ctx.expr(0));
//        result += "Pop regC, \n";
//        //check RHS
//        result += visit(ctx.expr(1));
//        result += "Pop regD, \n"
//                + "Push regC, \nPush regD, \n"
//                + "Pop regB, \nPop regA, \n";
//
//        String op = ctx.getChild(1).getText();
//        switch (op) {
//            case "IsBiggerThan" :
//                result += "Compute Gt regA regB regA, \n";
//                break;
//            case "IsSmallerThan":
//                result += "Compute Lt regA regB regA, \n";
//                break;
//            case "IsEqualTo":
//                result += "Compute Equal regA regB regA, \n";
//                break;
//            case "IsNotEqualTo":
//                result += "Compute NEq regA regB regA, \n";
//                break;
//            case "IsBiggerThanOrEqualTo":
//                result += "Compute GtE regA regB regA, \n";
//                break;
//            case "IsSmallerThanOrEqualTo":
//                result += "Compute LtE regA regB regA, \n";
//                break;
//        }
//        result += "Push regA, \n";
//        return result;
//    }
//
//    @Override
//    public String visitNotExpr(NaturalParser.NotExprContext ctx) {
//        String result = visit(ctx.expr());
//        result += "Pop regA, \n";
//        result += "Compute Equal reg0 regA regA, \n";
//        result += "Push regA, \n";
//        return result;
//    }
//
//    //Handle If Statement
//    @Override
//    public String visitIfStat(NaturalParser.IfStatContext ctx) {
//        String result= visit(ctx.expr());
//
//        // Check if the condition is true or false
//        result += "Pop regA, \n";
//        //TODO: if statement with no else
//        String leftInput = visit(ctx.stat(0));
//        String rightInput = visit(ctx.stat(1));
//
//        //set the pointer to the next instruction +1
//        int trueCase  = leftInput.split("\n").length + 1;
//        //skip the jump instruction +1
//        int falseCase = rightInput.split("\n").length + 2;
//
//        //Structure: Branch -> Else -> Jump -> True stat
//        //If true, branch over the else statement.
//        //If false, don't branch and add the else statement code to the result
//        result += "Branch regA (Rel " + falseCase + "),\n";
//
//        //add Else part
//        result += rightInput;
//
//        //if false, the true part is skipped
//        result += "Jump (Rel " + trueCase + "), \n";
//
//        //True part, which can only be triggered by branch -> true
//        result += leftInput;
//        return result;
//    }
//
//    @Override
//    public String visitWhileStat(NaturalParser.WhileStatContext ctx) {
//        String result = "";
//
//        //visit comparison
//        String compareExpr = visit(ctx.expr());
//        int numLinesExpr = compareExpr.split("\n").length;
//
//        //visit while block
//        String whileStat = visit(ctx.stat());
//        if (whileStat == null) {
//            // Do nothing
//        } else {
//            int numLinesStat = whileStat.split("\n").length + 2;
//
//            //Structure: compareExpr -> Branch -> whileBlock -> JumpBack => compareExpr
//            result += compareExpr;
//
//            //Negate the boolean on the stack, for use of branch
//            result += "Pop regA,\n";
//            result += "Compute Equal reg0 regA regA,\n";
//
//            //Start Branch
//            result += "Branch regA (Rel " + numLinesStat + "),\n ";
//            result += whileStat;
//
//            //Jump back to checking the condition
//            result += "Jump (Rel (-" + (numLinesStat + numLinesExpr + 3) + ")),\n";
//        }
//        return result;
//    }
//
//
//    /*-------------------------------------------------
//                    Binary Operation
//    -------------------------------------------------*/
//    @Override
//    //Handle Multiplication
//    public String visitMultExpr(NaturalParser.MultExprContext ctx) {
//        String result = visit(ctx.expr(0));
//        result += visit(ctx.expr(1));
//        result +=   "Pop regB, \n" +
//                    "Pop regA, \n" +
//                    "Compute Mul regA regB regA, \n" +
//                    "Push regA, \n";
//        return  result;
//    }
//
//    @Override
//    //Handle Add & Minus Expr
//    public String visitAddExpr(NaturalParser.AddExprContext ctx) {
//        // Generate code for the left&right subexpression
//        String result = visit(ctx.expr(0));
//        result += visit(ctx.expr(1));
//        result += "Pop regB, \n";
//        result += "Pop regA, \n";
//
//        switch (ctx.op().getText()) {
//            case "+" -> result += "Compute Add regA regB regA, \n";
//            case "-" -> result += "Compute Sub regA regB regA, \n";
//        }
//        result += "Push regA, \n";
//        return result;
//    }
//
//    @Override
//    public String visitParExpr(NaturalParser.ParExprContext ctx) {
//        return visit(ctx.expr());
//    }
//
//
//    /*-------------------------------------------------
//                    Concurrency
//    -------------------------------------------------*/
//    @Override
//    public String visitPrintStat(NaturalParser.PrintStatContext ctx) {
//        return super.visitPrintStat(ctx);
//    }
//
//    @Override
//    public String visitLockStat(NaturalParser.LockStatContext ctx) {
//        String result = "";
//        // Get the id of the lock
//        String id = ctx.ID().getText();
//        // get the address of the lock
//        int address = globalMap.get(id);
//        // If we want to lock the lock
//        if (Objects.equals(ctx.lockStatus().getText(), "lock")) {
//            // We check what is in the shared memory. If we get a 1 from the shared memory,
//            // we loop back and keep checking it until it is set to 0.
//            // If it is 0 we set it to 1 and continue with the code
//            result += "TestAndSet (DirAddr " + address + "), \n";
//            result += "Receive regA, \n";
//            result += "Compute Equal reg0 regA regA,\n";
//            result += "Branch regA (Rel (-3)), \n";
//            result += "Load (ImmValue 1) regA, \n";
//            result += "WriteInstr regA (DirAddr " + address + "), \n";
//        } else {
//            result += "WriteInstr reg0 (DirAddr " + address + "), \n";
//        }
//        return result;
//    }
//
//    @Override
//    public String visitParallelStat(NaturalParser.ParallelStatContext ctx) {
//        String result = "";
//        threadCounter += Integer.parseInt(ctx.expr().getText());
//        result += visit(ctx.stat());
//        parallelCode.add(result);
//
//        return "";
//    }
//}


