// Generated from /Users/chadmeng/Documents/TCS/M8/PP_Project/src/main/antlr4/ut/pp/parser/NaturalParser.g4 by ANTLR 4.12.0
package main.antlr4.ut.pp.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NaturalParserParser}.
 */
public interface NaturalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(NaturalParserParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(NaturalParserParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#constant_value}.
	 * @param ctx the parse tree
	 */
	void enterConstant_value(NaturalParserParser.Constant_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#constant_value}.
	 * @param ctx the parse tree
	 */
	void exitConstant_value(NaturalParserParser.Constant_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#scope_level}.
	 * @param ctx the parse tree
	 */
	void enterScope_level(NaturalParserParser.Scope_levelContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#scope_level}.
	 * @param ctx the parse tree
	 */
	void exitScope_level(NaturalParserParser.Scope_levelContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(NaturalParserParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(NaturalParserParser.Data_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#somethinghereeeeeee}.
	 * @param ctx the parse tree
	 */
	void enterSomethinghereeeeeee(NaturalParserParser.SomethinghereeeeeeeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#somethinghereeeeeee}.
	 * @param ctx the parse tree
	 */
	void exitSomethinghereeeeeee(NaturalParserParser.SomethinghereeeeeeeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#conditionPara}.
	 * @param ctx the parse tree
	 */
	void enterConditionPara(NaturalParserParser.ConditionParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#conditionPara}.
	 * @param ctx the parse tree
	 */
	void exitConditionPara(NaturalParserParser.ConditionParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(NaturalParserParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(NaturalParserParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(NaturalParserParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(NaturalParserParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#data_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterData_type_definition(NaturalParserParser.Data_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#data_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitData_type_definition(NaturalParserParser.Data_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#scope_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterScope_type_definition(NaturalParserParser.Scope_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#scope_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitScope_type_definition(NaturalParserParser.Scope_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#opPara}.
	 * @param ctx the parse tree
	 */
	void enterOpPara(NaturalParserParser.OpParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#opPara}.
	 * @param ctx the parse tree
	 */
	void exitOpPara(NaturalParserParser.OpParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#op_expr}.
	 * @param ctx the parse tree
	 */
	void enterOp_expr(NaturalParserParser.Op_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#op_expr}.
	 * @param ctx the parse tree
	 */
	void exitOp_expr(NaturalParserParser.Op_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(NaturalParserParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(NaturalParserParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(NaturalParserParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(NaturalParserParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(NaturalParserParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(NaturalParserParser.Print_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#parallel_statement}.
	 * @param ctx the parse tree
	 */
	void enterParallel_statement(NaturalParserParser.Parallel_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#parallel_statement}.
	 * @param ctx the parse tree
	 */
	void exitParallel_statement(NaturalParserParser.Parallel_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NaturalParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(NaturalParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NaturalParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(NaturalParserParser.ExprContext ctx);
}