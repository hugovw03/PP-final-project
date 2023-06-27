package main.antlr4.ut.pp.ntr;



import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.Token;
import main.antlr4.ut.pp.ntr.Result;
import main.antlr4.ut.pp.ntr.NaturalType;

import java.util.List;


public class NaturalGrammarListener extends NaturalBaseListener {

    private Result result;

    /** Map storing the val attribute for all parse tree nodes. */
    private ParseTreeProperty<Object> vals;

    private List<String> errors;
    // sorry for this..
    @Override
    public void exitIdentifier(NaturalBaseListener.IdentifierContext ctx) {
        checkType(ctx, ctx.ID());
        setType(ctx, val(ctx.ID()));
    }
    @Override
    public void exitCondition(NaturalBaseListener.ConditionContext ctx) {
        setType(ctx, val(ctx.conditionPara(0)) == val(ctx.conditionPara(1)));
    }

    @Override
    public void exitConstant_value(NaturalBaseListener.Constant_valueContext ctx) {
        if (val(ctx.CONST_INT()) != null){
            setType(ctx, val(ctx.CONST_INT()));
        } else {
            assert val(ctx.CONST_BOOL()) != null;
            setType(ctx, val(ctx.CONST_BOOL()));
        }
    }

    @Override
    public void exitScope_level(NaturalBaseListener.Scope_levelContext ctx) {

        super.exitScope_level(ctx);
    }

    @Override
    public void exitData_type(NaturalBaseListener.Data_typeContext ctx) {
        if (val(ctx.INT()) != null){
            setType(ctx, val(ctx.INT()));
        } else if (val(ctx.BOOL()) != null){
            setType(ctx, val(ctx.BOOL()));
        } else {
            assert val(ctx.LOCK()) != null;
            setType(ctx, val(ctx.LOCK()));
        }
    }

    @Override
    public void exitSomethinghereeeeeee(NaturalBaseListener.SomethinghereeeeeeeContext ctx) {
        super.exitSomethinghereeeeeee(ctx);
    }

    @Override
    public void exitData_type_definition(NaturalBaseListener.Data_type_definitionContext ctx) {
        super.exitData_type_definition(ctx);
    }

    @Override
    public void exitScope_type_definition(NaturalBaseListener.Scope_type_definitionContext ctx) {
    }

    @Override
    public void exitIf_statement(NaturalBaseListener.If_statementContext ctx) {

        super.exitIf_statement(ctx);
    }

    @Override
    public void exitWhile_statement(NaturalBaseListener.While_statementContext ctx) {
        super.exitWhile_statement(ctx);
    }

    @Override
    public void exitPrint_statement(NaturalBaseListener.Print_statementContext ctx) {
        super.exitPrint_statement(ctx);
    }

    @Override
    public void exitParallel_statement(NaturalBaseListener.Parallel_statementContext ctx) {
        super.exitParallel_statement(ctx);
    }

    @Override
    public void exitExpr(NaturalBaseListener.ExprContext ctx) {
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

    /** Sets the val attribute of a given node. */
    private void setType(ParseTree node, Object type) {
        this.vals.put(node, type);
    }

    /** Retrieves the val attribute of a given node. */
    public Object val(ParseTree node) {
        return this.vals.get(node);
    }

    @Override
    public void exitConditionPara(NaturalBaseListener.ConditionParaContext ctx) {

    }


    /** Returns the type of a given expression or type node. */
    private NaturalType getType(ParseTree node) {
        return this.result.getType(node);
    }

    /** Checks the inferred type of a given parse tree,
     * and adds an error if it does not correspond to the expected type.
     */
    private void checkType(ParserRuleContext node, Object expected) {
        Object actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    /** Records an error at a given parse tree node.
     * @param node the parse tree node at which the error occurred
     * @param message the error message
     * @param args arguments for the message, see {@link String#format}
     */
    private void addError(ParserRuleContext node, String message,
                          Object... args) {
        addError(node.getStart(), message, args);
    }

    /** Records an error at a given token.
     * @param token the token at which the error occurred
     * @param message the error message
     * @param args arguments for the message, see {@link String#format}
     */
    private void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }
}