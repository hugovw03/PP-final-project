// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/ntr/Natural.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.ntr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NaturalParser}.
 */
public interface NaturalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NaturalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NaturalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NaturalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declGlobal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclGlobal(NaturalParser.DeclGlobalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declGlobal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclGlobal(NaturalParser.DeclGlobalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declNormal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclNormal(NaturalParser.DeclNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declNormal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclNormal(NaturalParser.DeclNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignToVar}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignToVar(NaturalParser.AssignToVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignToVar}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignToVar(NaturalParser.AssignToVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(NaturalParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(NaturalParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(NaturalParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(NaturalParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterParallelStat(NaturalParser.ParallelStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitParallelStat(NaturalParser.ParallelStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlock(NaturalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlock(NaturalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(NaturalParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(NaturalParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lockStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterLockStat(NaturalParser.LockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lockStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitLockStat(NaturalParser.LockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(NaturalParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(NaturalParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(NaturalParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(NaturalParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(NaturalParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(NaturalParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(NaturalParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(NaturalParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(NaturalParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(NaturalParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstExpr(NaturalParser.ConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstExpr(NaturalParser.ConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(NaturalParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(NaturalParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParser#lockStatus}.
	 * @param ctx the parse tree
	 */
	void enterLockStatus(NaturalParser.LockStatusContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParser#lockStatus}.
	 * @param ctx the parse tree
	 */
	void exitLockStatus(NaturalParser.LockStatusContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(NaturalParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(NaturalParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(NaturalParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(NaturalParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(NaturalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(NaturalParser.TypeContext ctx);
}