package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;

public class CodeGen extends NaturalBaseVisitor<String>{

    private String program;

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
        return super.visitDeclGlobalAndLocal(ctx);
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
    public String visitAddExpr(NaturalParser.AddExprContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        String result = "Pop regB, \n";
        result += "Pop regA, \n";
        switch (ctx.op().getText()) {
            case "+":
                result += "Compute Add regA regB regA, \n";
                break;
            case "-":
                result += "Compute Sub regA regB regA, \n";
                break;
        }
        result += "Push regA, \n";


        program += result;
        return result;
    }

    @Override
    public String visitCompExpr(NaturalParser.CompExprContext ctx) {
        return super.visitCompExpr(ctx);
    }

    @Override
    public String visitMultExpr(NaturalParser.MultExprContext ctx) {
        return super.visitMultExpr(ctx);
    }

    @Override
    public String visitLockStat(NaturalParser.LockStatContext ctx) {
        return super.visitLockStat(ctx);
    }

    @Override
    public String visitOp(NaturalParser.OpContext ctx) {
        return super.visitOp(ctx);
    }

    @Override
    public String visitConstExpr(NaturalParser.ConstExprContext ctx) {
        return super.visitConstExpr(ctx);
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
    public String visitType(NaturalParser.TypeContext ctx) {
        return super.visitType(ctx);
    }
}
