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
        return super.visitProgram(ctx);
    }

    @Override
    public String visitDeclGlobalAndLocal(NaturalParser.DeclGlobalAndLocalContext ctx) {
        int position = globalMap.size();
        globalMap.put(ctx.ID().getText(), position);
        visit(ctx.expr());
        String result = "Pop regA, \n";
        result += "WriteInstr regA (DirAddr " + position + "), \n";
        result += "ReadInstr (DirAddr " + position + "), \n";
        result += "Receive regB, \n";
        result += "Compute NEq regA regB regC, \n";
        result += "Branch regC (Rel (-4)), \n";
        program += result;
        return result;
    }

    @Override
    public String visitIdExpr(NaturalParser.IdExprContext ctx) {
        return super.visitIdExpr(ctx);
    }

    @Override
    public String visitDecl(NaturalParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public String visitDeclNormal(NaturalParser.DeclNormalContext ctx) {
        return super.visitDeclNormal(ctx);
    }

    @Override
    public String visitAssignToVar(NaturalParser.AssignToVarContext ctx) {
        return super.visitAssignToVar(ctx);
    }





    @Override
    public String visitWhileStat(NaturalParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public String visitParallelStat(NaturalParser.ParallelStatContext ctx) {
        return super.visitParallelStat(ctx);
    }

    @Override
    public String visitBlock(NaturalParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public String visitPrintStat(NaturalParser.PrintStatContext ctx) {
        return super.visitPrintStat(ctx);
    }

    @Override
    public String visitParExpr(NaturalParser.ParExprContext ctx) {
        return super.visitParExpr(ctx);
    }
    @Override
    public String visitNotExpr(NaturalParser.NotExprContext ctx) {
        return super.visitNotExpr(ctx);
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
        String result = "Pop regB, \nPop regA, \n";
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        switch (op) {
            case "IsBiggerThan" :
                result += "Compute Gt regA regB regA, \n";
            case "IsSmallerThan":
                result += "Compute Lt regA regB regA, \n";
            case "IsEqualTo":
                result += "Compute Equal regA regB regA, \n";
            case "IsNotEqualTo":
                result += "Compute NEq regA regB regA, \n";
            case "IsBiggerThanOrEqualTo":
                result += "Compute GtE regA regB regA, \n";
            case "IsSmallerThanOrEqualTo":
                result += "Compute LtE regA regB regA, \n";
        }
        result += "Push regA, \n";
        program += result;
        return result;

    }

    @Override
    public String visitIfStat(NaturalParser.IfStatContext ctx) {
//        cmp (r1),(r2)    ;compare words at memory addresses pointed by registers r1 and r2
//        blt else         ;jump to else-part if (r1) is less than (r2)
//   ...           ;insert the main branch code here
//        bra end_if       ;jump to end_if
//        else:
//   ...           ;insert the else branch code here
//        end_if:
        return super.visitIfStat(ctx);
    }




    //TODO: remove this line we don't need this but just in case
    @Override
    public String visitOp(NaturalParser.OpContext ctx) {
        return super.visitOp(ctx);
    }


    /*-------------------------------------------------
                    Binary Operation
    -------------------------------------------------*/
    //Handle Multiplication
    @Override
    public String visitMultExpr(NaturalParser.MultExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        String result = "Pop regB,\n" +
                        "Pop regA,\n" +
                        "Compute Mul regA regB regA, \n" +
                        "Push regA, \n";
        program += result;
        return  result;
    }

    //Handle Add & Minus
    @Override
    public String visitAddExpr(NaturalParser.AddExprContext ctx) {
        // Generate code for the left&right subexpression
        String leftResult = visit(ctx.expr(0));
        String rightResult = visit(ctx.expr(1));

        String result = "Pop regB, \n";
        result += "Pop regA, \n";

        switch (ctx.op().getText()) {
            case "+" -> result += "Compute Add regA regB regA, \n";
            case "-" -> result += "Compute Sub regA regB regA, \n";
        }
        result += "Push regA, \n";
        program += result;
        return result;
    }

    //Load constant Expr
    @Override
    public String visitConstExpr(NaturalParser.ConstExprContext ctx) {
        String result;
        String text = ctx.getText();
        //Assign Boolean to 1 if True
        if (text.equals("Ture")){
            result = "Load (ImmValue 1) regA,\nPush regA, \n";
        }
        else if (text.equals("False")) {
            result = "Load (ImmValue 0) regA,\nPush regA, \n";
        }
        //Otherwise it will be Constant, type checked in listener
        else result = "Load (ImmValue " + ctx.getText() + ") regA,\nPush regA, \n";
        program += result;
        return result;
    }



    @Override
    public String visitType(NaturalParser.TypeContext ctx) {
        return super.visitType(ctx);
    }
}
