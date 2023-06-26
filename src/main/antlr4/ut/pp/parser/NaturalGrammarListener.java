package main.antlr4.ut.pp.parser;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.Type;
import com.sun.net.httpserver.Authenticator;
import com.sun.tools.javac.code.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.xml.transform.Result;


public class NaturalGrammarListener extends NaturalParserBaseListener {

    /** List of errors collected in the latest call of {@link #check}. */
    private List<String> errors;
    /** Result of the latest call of {@link #check}. */
    private Result result;

    private Type getType(ParseTree node){
        return this.getType(node);
    }

    private void checkType(ParserRuleContext node, Type expected) {
        Type actual = getType(node);
        if (actual == null) {
            throw new IllegalArgumentException("Missing inferred type of "
                    + node.getText());
        }
        if (!actual.equals(expected)) {
            addError(node, "Expected type '%s' but found '%s'", expected,
                    actual);
        }
    }

    /** Convenience method to add a type to the result. */
    private void setType(ParseTree node, Type type) {
        this.result.setType(node, type);
    }

    /** Indicates if any errors were encountered in this tree listener. */
    public boolean hasErrors() {
        return !getErrors().isEmpty();
    }

    /** Returns the list of errors collected in this tree listener. */
    public List<String> getErrors() {
        return this.errors;
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

    private void addError(Token token, String message, Object... args) {
        int line = token.getLine();
        int column = token.getCharPositionInLine();
        message = String.format(message, args);
        message = String.format("Line %d:%d - %s", line, column, message);
        this.errors.add(message);
    }

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
        super.exitScope_type_definition(ctx);
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

//Chatgpt 
//    @Override
//    public void exitExpr(NaturalParser.ExprContext ctx) {
//        // Perform type checking logic for expressions
//
//        if (ctx.data_type_definition() != null) {
//            exitData_type_definition(ctx.data_type_definition());
//        } else if (ctx.assignment_statement() != null) {
//            exitAssignment_statement(ctx.assignment_statement());
//        } else if (ctx.if_statement() != null) {
//            exitIf_statement(ctx.if_statement());
//        } else if (ctx.while_statement() != null) {
//            exitWhile_statement(ctx.while_statement());
//        } else if (ctx.print_statement() != null) {
//            exitPrint_statement(ctx.print_statement());
//        } else if (ctx.parallel_statement() != null) {
//            exitParallel_statement(ctx.parallel_statement());
//        }
//
//        // Additional logic for other expression types if needed
//    }
//
//    private void exitData_type_definition(NaturalParser.Data_type_definitionContext ctx) {
//        // Perform type checking logic for data type definition
//        // Validate the data type and its assignment
//        // Add error messages if needed
//
//        // Example validation: Check if the assigned value matches the declared type
//        NaturalParser.Data_typeContext dataTypeCtx = ctx.data_type();
//        NaturalParser.IdentifierContext identifierCtx = ctx.identifier();
//        NaturalParser.Constant_valueContext constantValueCtx = ctx.constant_value();
//
//        String identifier = identifierCtx.getText();
//        String declaredType = dataTypeCtx.getText();
//        String assignedValue = constantValueCtx.getText();
//
//        if (declaredType.equals("Int")) {
//            if (!assignedValue.matches("-?\\d+")) {
//                addError(ctx, "Invalid assignment for variable '%s'. Expected an integer value.", identifier);
//            }
//        } else if (declaredType.equals("Bool")) {
//            if (!assignedValue.equals("True") && !assignedValue.equals("False")) {
//                addError(ctx, "Invalid assignment for variable '%s'. Expected a boolean value.", identifier);
//            }
//        }
//
//        // Additional type checking logic for other data types if needed
//    }
//
//    private void exitAssignment_statement(NaturalParser.Assignment_statementContext ctx) {
//        // Perform type checking logic for assignment statements
//        // Validate the assignment types and assignments
//        // Add error messages if needed
//
//        // Example validation: Check if the identifier exists and its assigned value matches the declared type
//        NaturalParser.IdentifierContext identifierCtx = ctx.identifier();
//        NaturalParser.Constant_valueContext constantValueCtx = ctx.constant_value();
//
//        String identifier = identifierCtx.getText();
//        String assignedValue = constantValueCtx.getText();
//
//        // Assuming there is a symbol table to check if the identifier exists and retrieve its declared type
//        String declaredType = symbolTable.lookupType(identifier);
//
//        if (declaredType == null) {
//            addError(ctx, "Variable '%s' not declared.", identifier);
//        } else {
//            if (declaredType.equals("Int")) {
//                if (!assignedValue.matches("-?\\d+")) {
//                    addError(ctx, "Invalid assignment for variable '%s'. Expected an integer value.", identifier);
//                }
//            } else if (declaredType.equals("Bool")) {
//                if (!assignedValue.equals("True") && !assignedValue.equals("False")) {
//                    addError(ctx, "Invalid assignment for variable '%s'. Expected a boolean value.", identifier);
//                }
//            }
//        }
//
//        // Additional type checking logic for assignment statements if needed
//    }
//
//// Implement exit methods for other expression types (if_statement, while_statement, print_statement, parallel_statement)