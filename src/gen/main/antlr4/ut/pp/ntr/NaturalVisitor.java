// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/ntr/Natural.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.ntr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NaturalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NaturalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NaturalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(NaturalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declGlobalandLocal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclGlobalandLocal(NaturalParser.DeclGlobalandLocalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declNormal}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclNormal(NaturalParser.DeclNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignToVar}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignToVar(NaturalParser.AssignToVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(NaturalParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(NaturalParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parallelStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelStat(NaturalParser.ParallelStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(NaturalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link NaturalParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(NaturalParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(NaturalParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(NaturalParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(NaturalParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(NaturalParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(NaturalParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldExpr(NaturalParser.FieldExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExpr(NaturalParser.ConstExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link NaturalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(NaturalParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(NaturalParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(NaturalParser.TypeContext ctx);
}