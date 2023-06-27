package main.antlr4.ut.pp.parser;



import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.Token;
import main.antlr4.ut.pp.parser.Result;
import main.antlr4.ut.pp.parser.NaturalType;

import java.util.List;


public class NaturalGrammarListener extends NaturalParserBaseListener {

    private Result result;

    /** Map storing the val attribute for all parse tree nodes. */
    private ParseTreeProperty<Object> vals;

    private List<String> errors;

    @Override
    public void exitIdentifier(NaturalParserParser.IdentifierContext ctx) {

    }
    @Override
    public void exitCondition(NaturalParserParser.ConditionContext ctx) {
        super.exitCondition(ctx);
    }

    @Override
    public void exitConstant_value(NaturalParserParser.Constant_valueContext ctx) {
        super.exitConstant_value(ctx);
    }

    @Override
    public void exitScope_level(NaturalParserParser.Scope_levelContext ctx) {
        super.exitScope_level(ctx);
    }

    @Override
    public void exitData_type(NaturalParserParser.Data_typeContext ctx) {
        super.exitData_type(ctx);
    }

    @Override
    public void exitSomethinghereeeeeee(NaturalParserParser.SomethinghereeeeeeeContext ctx) {
        super.exitSomethinghereeeeeee(ctx);
    }

    @Override
    public void exitData_type_definition(NaturalParserParser.Data_type_definitionContext ctx) {
        super.exitData_type_definition(ctx);
    }

    @Override
    public void exitScope_type_definition(NaturalParserParser.Scope_type_definitionContext ctx) {
    }

    @Override
    public void exitIf_statement(NaturalParserParser.If_statementContext ctx) {
        super.exitIf_statement(ctx);
    }

    @Override
    public void exitWhile_statement(NaturalParserParser.While_statementContext ctx) {
        super.exitWhile_statement(ctx);
    }

    @Override
    public void exitPrint_statement(NaturalParserParser.Print_statementContext ctx) {
        super.exitPrint_statement(ctx);
    }

    @Override
    public void exitParallel_statement(NaturalParserParser.Parallel_statementContext ctx) {
        super.exitParallel_statement(ctx);
    }

    @Override
    public void exitExpr(NaturalParserParser.ExprContext ctx) {
        super.exitExpr(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

}