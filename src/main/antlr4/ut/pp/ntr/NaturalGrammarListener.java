package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Objects;

public class NaturalGrammarListener extends NaturalBaseListener {
    private SymbolTable symbolTable = new NaturalSymbolTable();
    private Result result;

    private List<String> errors;
    private ParseTreeProperty<String> nameProperty = new ParseTreeProperty<>();






//    @Override
//    public void enterDeclGlobalAndLocal(NaturalParser.DeclGlobalAndLocalContext ctx) {
//        String identifier = ctx.ID().getText();
//        //if such a var assigned to a value
//        if (ctx.ASSIGN() != null) {
//            //TODO: assign value
//            System.out.println("enterGlobal: var is assigned to : " + ctx.expr());
//
//        }
//        else {
//            //TODO: directly put into symbol table
//            System.out.println("enterGlobal: var is not assigned to any value");
//        }
//        symbolTable.put(identifier, ctx);
//        nameProperty.put(ctx, identifier); // Store the name attribute for the parse tree node
//    }
//
//    @Override
//    public void exitDeclGlobalAndLocal(NaturalParser.DeclGlobalAndLocalContext ctx) {
//
//    }
//
//
//
//
//    @Override
//    public void enterConstExpr(NaturalParser.ConstExprContext ctx) {
//        System.out.println("enterConstExpr is triggered, ctx is: " + ctx.getText());
//    }
//
//    @Override
//    public void exitConstExpr(NaturalParser.ConstExprContext ctx) {
//        System.out.println("exitConstExpr is triggered, ctx is: " + ctx.getText());
//
//    }
//
//
//    //obviously IdExpr is never triggered
//    @Override
//    public void enterIdExpr(NaturalParser.IdExprContext ctx) {
//        System.out.println("enterIdExpr is triggered, ctx is: " + ctx.ID());
//    }
//
//    @Override
//    public void exitIdExpr(NaturalParser.IdExprContext ctx) {
//        System.out.println("exitIdExpr is triggered, ctx is: " + ctx.ID());
//    }
//
//    @Override
//    public void enterDeclNormal(NaturalParser.DeclNormalContext ctx) {
//        if (ctx.ASSIGN() != null) {
//            //TODO: assign value
//            System.out.println("enterDeclNormal:  is assigned to : " + ctx.expr());
//
//        }
//        else {
//            //TODO: directly put into symbol table
//            System.out.println("enterDeclNormal: var is not assigned to any value");
//        }
//        String identifier = ctx.ID().getText();
//        symbolTable.put(identifier, ctx.type().getText());
//        nameProperty.put(ctx, identifier); // Store the name attribute for the parse tree node
//    }
//
//    @Override
//    public void exitDeclNormal(NaturalParser.DeclNormalContext ctx) {
//
//    }
//
//    @Override
//    public void enterAssignToVar(NaturalParser.AssignToVarContext ctx) {
//        String identifier = ctx.ID().getText();
//        ParseTree expr = ctx.expr();
//
//// Evaluate the expression to get the resulting value
////        Object value = evaluateExpression(expr);
//        System.out.println(ctx.expr());
//    }
//
//    @Override
//    public void exitAssignToVar(NaturalParser.AssignToVarContext ctx) {
//        String identifier = nameProperty.get(ctx.ID()); // Retrieve the name attribute for the ID parse tree node
//        if (symbolTable.get(identifier) == null) {
//            System.out.println("Error: Variable '" + identifier + "' is not declared in the current scope.");
//        }
//    }
//
//
//    @Override
//    public void visitTerminal(TerminalNode node) {
//        String terminalText = node.getText();
//        if (terminalText.equals("True") || terminalText.equals("False")) {
//            System.out.println("Found boolean constant: " + terminalText);
//        }
//    }
//
//    //Block -> new scope
//    @Override
//    public void enterBlock(NaturalParser.BlockContext ctx) {
//        symbolTable.openScope();
//    }
//    @Override
//    public void exitBlock(NaturalParser.BlockContext ctx) {
//        symbolTable.closeScope();
//    }



    /** Indicates if any errors were encountered in
     * this tree listener. */
    public boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    /** Returns the list of errors collected in
     * this tree listener. */
    public List<String> getErrors() {
        return this.errors;
    }

    /** Checks the inferred type of a given parse tree,
     * and adds an error if it does not correspond to
     * the expected type.
     */
    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred "
                    + "type of " + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'",
                    expected,
                    actual);
        }
    }


    /** Records an error at a given parse tree node.
     * @param ctx the parse tree node at which the error occurred
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
        message = String.format("Line %d:%d - %s",
                line, column, message);
        this.errors.add(message);
    }

    /** Convenience method to add an offset to the result. */
    private void setOffset(ParseTree node, Integer offset) {
        this.result.setOffset(node, offset);
    }

    /** Convenience method to add a type to the result. */
    private void setType(ParseTree node, Type type) {
        this.result.setType(node, type);
    }

    /** Returns the type of a given expression or type node. */
    private Type getType(ParseTree node) {
        return this.result.getType(node);
    }

    /** Convenience method to add a flow graph entry to the result. */
    private void setEntry(ParseTree node, ParserRuleContext entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null flow graph entry");
        }
        this.result.setEntry(node, entry);
    }

    /** Returns the flow graph entry of a given
     * expression or statement. */
    private ParserRuleContext entry(ParseTree node) {
        return this.result.getEntry(node);
    }

}


//TODO:  something we might need

//    @Override
//    public void exitAssignToVar(NaturalParser.AssignToVarContext ctx) {
//        String identifier = ctx.ID().getText();
//        NaturalParser.ExprContext exprContext = ctx.expr();
//
//        TypeKind identifierType = typeMap.get(ctx);
//        TypeKind exprType = typeMap.get(exprContext);
//
//        if (identifierType != exprType) {
//            System.out.println("Error: Type mismatch. Cannot assign expression of type " +
//                    exprType + " to variable of type " + identifierType);
//        } else {
//            Object exprValue = valueMap.get(exprContext);
//            valueMap.put(ctx, exprValue);
//            System.out.println("Assigned: " + identifier + " = " + exprValue);
//        }
//        System.out.println(getTypeMap());
//        System.out.println(getValueMap());
//    }
//
//    private ParseTreeProperty<TypeKind> typeMap;
//    private ParseTreeProperty<Object> valueMap;
//
//    public NaturalGrammarListener() {
//        typeMap = new ParseTreeProperty<>();
//        valueMap = new ParseTreeProperty<>();
//    }
//
//
//    // Implement other listener methods for attribute evaluation
//
//    public ParseTreeProperty<TypeKind> getTypeMap() {
//        return typeMap;
//    }
//
//    public ParseTreeProperty<Object> getValueMap() {
//        return valueMap;
//    }
//



//old code
//public class NaturalGrammarListener extends NaturalBaseListener {
//
//    private Result result;
//
//    /** Map storing the val attribute for all parse tree nodes. */
//    private ParseTreeProperty<Object> vals;
//
//    private List<String> errors;
//    // sorry for this..
//
//
//
//
//
//    @Override
//    public void exitIdentifier(NaturalBaseListener.IdentifierContext ctx) {
//        checkType(ctx, ctx.ID());
//        setType(ctx, val(ctx.ID()));
//    }
//    @Override
//    public void exitCondition(NaturalBaseListener.ConditionContext ctx) {
//        setType(ctx, val(ctx.conditionPara(0)) == val(ctx.conditionPara(1)));
//    }
//
//    @Override
//    public void exitConstant_value(NaturalBaseListener.Constant_valueContext ctx) {
//        if (val(ctx.CONST_INT()) != null){
//            setType(ctx, val(ctx.CONST_INT()));
//        } else {
//            assert val(ctx.CONST_BOOL()) != null;
//            setType(ctx, val(ctx.CONST_BOOL()));
//        }
//    }
//
//    @Override
//    public void exitScope_level(NaturalBaseListener.Scope_levelContext ctx) {
//
//        super.exitScope_level(ctx);
//    }
//
//    @Override
//    public void exitData_type(NaturalBaseListener.Data_typeContext ctx) {
//        if (val(ctx.INT()) != null){
//            setType(ctx, val(ctx.INT()));
//        } else if (val(ctx.BOOL()) != null){
//            setType(ctx, val(ctx.BOOL()));
//        } else {
//            assert val(ctx.LOCK()) != null;
//            setType(ctx, val(ctx.LOCK()));
//        }
//    }
//
//    @Override
//    public void exitSomethinghereeeeeee(NaturalBaseListener.SomethinghereeeeeeeContext ctx) {
//        super.exitSomethinghereeeeeee(ctx);
//    }
//
//    @Override
//    public void exitData_type_definition(NaturalBaseListener.Data_type_definitionContext ctx) {
//        super.exitData_type_definition(ctx);
//    }
//
//    @Override
//    public void exitScope_type_definition(NaturalBaseListener.Scope_type_definitionContext ctx) {
//    }
//
//    @Override
//    public void exitIf_statement(NaturalBaseListener.If_statementContext ctx) {
//
//        super.exitIf_statement(ctx);
//    }
//
//    @Override
//    public void exitWhile_statement(NaturalBaseListener.While_statementContext ctx) {
//        super.exitWhile_statement(ctx);
//    }
//
//    @Override
//    public void exitPrint_statement(NaturalBaseListener.Print_statementContext ctx) {
//        super.exitPrint_statement(ctx);
//    }
//
//    @Override
//    public void exitParallel_statement(NaturalBaseListener.Parallel_statementContext ctx) {
//        super.exitParallel_statement(ctx);
//    }
//
//    @Override
//    public void exitExpr(NaturalBaseListener.ExprContext ctx) {
//        super.exitExpr(ctx);
//    }
//
//    @Override
//    public void exitEveryRule(ParserRuleContext ctx) {
//        super.exitEveryRule(ctx);
//    }
//
//    @Override
//    public void visitTerminal(TerminalNode node) {
//        super.visitTerminal(node);
//    }
//
//    @Override
//    public void visitErrorNode(ErrorNode node) {
//        super.visitErrorNode(node);
//    }
//
//    /** Sets the val attribute of a given node. */
//    private void setType(ParseTree node, Object type) {
//        this.vals.put(node, type);
//    }
//
//    /** Retrieves the val attribute of a given node. */
//    public Object val(ParseTree node) {
//        return this.vals.get(node);
//    }
//
//    @Override
//    public void exitConditionPara(NaturalBaseListener.ConditionParaContext ctx) {
//
//    }
//
//
//    /** Returns the type of a given expression or type node. */
//    private NaturalType getType(ParseTree node) {
//        return this.result.getType(node);
//    }
//
//    /** Checks the inferred type of a given parse tree,
//     * and adds an error if it does not correspond to the expected type.
//     */
//    private void checkType(ParserRuleContext node, Object expected) {
//        Object actual = getType(node);
//        if (actual == null) {
//            throw new IllegalArgumentException("Missing inferred type of "
//                    + node.getText());
//        }
//        if (!actual.equals(expected)) {
//            addError(node, "Expected type '%s' but found '%s'", expected,
//                    actual);
//        }
//    }
//
//    /** Records an error at a given parse tree node.
//     * @param node the parse tree node at which the error occurred
//     * @param message the error message
//     * @param args arguments for the message, see {@link String#format}
//     */
//    private void addError(ParserRuleContext node, String message,
//                          Object... args) {
//        addError(node.getStart(), message, args);
//    }
//
//    /** Records an error at a given token.
//     * @param token the token at which the error occurred
//     * @param message the error message
//     * @param args arguments for the message, see {@link String#format}
//     */
//    private void addError(Token token, String message, Object... args) {
//        int line = token.getLine();
//        int column = token.getCharPositionInLine();
//        message = String.format(message, args);
//        message = String.format("Line %d:%d - %s", line, column, message);
//        this.errors.add(message);
//    }
//}