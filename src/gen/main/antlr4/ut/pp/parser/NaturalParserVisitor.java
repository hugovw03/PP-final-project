// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/parser/NaturalParser.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NaturalParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NaturalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(NaturalParserParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(NaturalParserParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#constant_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_value(NaturalParserParser.Constant_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#scope_level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope_level(NaturalParserParser.Scope_levelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(NaturalParserParser.Data_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#somethinghereeeeeee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSomethinghereeeeeee(NaturalParserParser.SomethinghereeeeeeeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#data_type_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type_definition(NaturalParserParser.Data_type_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#scope_type_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope_type_definition(NaturalParserParser.Scope_type_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(NaturalParserParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(NaturalParserParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#print_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_statement(NaturalParserParser.Print_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#parallel_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallel_statement(NaturalParserParser.Parallel_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#assignment_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_statement(NaturalParserParser.Assignment_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link NaturalParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(NaturalParserParser.ExprContext ctx);
}