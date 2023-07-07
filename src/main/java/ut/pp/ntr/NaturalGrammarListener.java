package ut.pp.ntr;

import main.antlr4.ut.pp.parser.NaturalBaseListener;
import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import java.util.ArrayList;
import java.util.List;

public class NaturalGrammarListener extends NaturalBaseListener {
    private Result result;
    private NaturalSymbolTable table;
    private List<String> errors;

    public Result check(ParseTree tree) throws ParseException {
        this.table = new NaturalSymbolTable();
        this.result = new Result();
        this.errors = new ArrayList<>();
        new ParseTreeWalker().walk(this, tree);
        if (hasErrors()) {
            throw new ParseException(getErrors());
        }
        return this.result;
    }

    @Override
    public void exitDeclNormal(NaturalParser.DeclNormalContext ctx) {
        String id = ctx.ID().toString();
        if (ctx.type().getText().equals("Lock")) {
            addError(ctx, "lock has to be declared as Global");
        }
        if (ctx.ASSIGN() == null) {
            table.put(id, getThisType(ctx.type().getText()));
            setType(ctx, getThisType(ctx.type().getText()));
            return;
        }
        table.put(id, getThisType(ctx.type().getText()));
        checkType(ctx.expr(), table.type(id));
        setType(ctx, getThisType(ctx.type().getText()));
    }


    @Override
    public void exitAssignToVar(NaturalParser.AssignToVarContext ctx) {
        String variableId = ctx.ID().getText();
        Type variableType = table.type(variableId);
        if (variableType == Type.LOCK) {
            addError(ctx, "assigning constant to a lock");
        }

        checkType(ctx.expr(), variableType);
        setType(ctx, variableType);
    }

    @Override
    public void enterBlock(NaturalParser.BlockContext ctx) {
        this.table.openScope();
    }

    @Override
    public void exitBlock(NaturalParser.BlockContext ctx) {
        this.table.closeScope();
    }


    //TODO: Add negative number rule, might need to be checked in listener
    @Override
    public void exitConstExpr(NaturalParser.ConstExprContext ctx) {
        Token constantToken = ctx.start; // Get the token representing the constant
        String constantValue = constantToken.getText();

        Type constantType;
        if (constantToken.getType() == NaturalLexer.NUM) {
            constantType = Type.INT; // Constant is an integer
        } else if (constantValue.equals("True") || constantValue.equals("False")) {
            constantType = Type.BOOL; // Constant is a boolean
        } else {
            // Handle the case when the constant is not recognized
            addError(constantToken, "Invalid constant: %s", constantValue);
            setType(ctx, null);
            return;
        }
        setType(ctx, constantType);
    }

    @Override
    public void exitIdExpr(NaturalParser.IdExprContext ctx) {
        String variableId = ctx.ID().getText();
        Type variableType = table.type(variableId);
        setType(ctx, variableType);
    }

    /*
                Binary opExpr
     */

    @Override
    public void exitAddExpr(NaturalParser.AddExprContext ctx) {
        if (ctx.expr().size() != 2) {
            // Invalid number of operands for addition
            addError(ctx, "Invalid number of operands for addition");
            setType(ctx, null);
            return;
        }

        ParseTree leftExpr = ctx.expr(0);
        ParseTree rightExpr = ctx.expr(1);

        // Check the types of the operands
        Type leftType = getType(leftExpr);
        Type rightType = getType(rightExpr);

        if (leftType == null || rightType == null) {
            // One or both operands have missing types
            addError(ctx, "Missing type for operands");
            setType(ctx, null);
            return;
        }

        // Check if both operands are integers
        if (leftType != Type.INT || rightType != Type.INT) {
            addError(ctx, "Operands of addition must be of type 'Int'");
            setType(ctx, null);
            return;
        }

        // Set the type of the addition expression to 'Int'
        setType(ctx, Type.INT);
    }

    @Override
    public void exitMultExpr(NaturalParser.MultExprContext ctx) {
        if (ctx.expr().size() != 2) {
            // Invalid number of operands for multiplication
            addError(ctx, "Invalid number of operands for multiplication");
            setType(ctx, null);
            return;
        }
        // Check the types of the operands
        Type leftType = getType(ctx.expr(0));
        Type rightType = getType(ctx.expr(1));

        if (leftType == null || rightType == null) {
            // One or both operands have missing types
            addError(ctx, "Missing type for operands");
            setType(ctx, null);
            return;
        }
        // Check if both operands are integers
        if (leftType != Type.INT || rightType != Type.INT) {
            addError(ctx, "Operands of multiplication must be of type 'Int'");
            setType(ctx, null);
            return;
        }

        // Set the type of the multiplication expression to 'Int'
        setType(ctx, Type.INT);
    }



    /*
                    Logical Expr
     */
    public void exitCompExpr(NaturalParser.CompExprContext ctx) {
        if (ctx.expr().size() != 2) {
            // Invalid number of operands for comparison
            addError(ctx, "Invalid number of operands for comparison");
            setType(ctx, null);
            return;
        }
        ParseTree leftExpr = ctx.expr(0);
        ParseTree rightExpr = ctx.expr(1);
        // Check the types of the operands
        Type leftType = getType(leftExpr);
        Type rightType = getType(rightExpr);

        if (leftType == null || rightType == null) {
            // One or both operands have missing types
            addError(ctx, "Missing type for operands");
            setType(ctx, null);
            return;
        }
        // Check if the operands are of compatible types for comparison
        if (!areCompatibleForComparison(leftType, rightType)) {
            addError(ctx, "Incompatible types for comparison");
            setType(ctx, null);
            return;
        }
        // Set the type of the comparison expression to 'Bool'
        setType(ctx, Type.BOOL);

    }
    //helper func for compExpr
    private boolean areCompatibleForComparison(Type leftType, Type rightType) {
        // Check if the types are compatible for comparison
        return (leftType == Type.INT && rightType == Type.INT)
                || (leftType == Type.BOOL && rightType == Type.BOOL);
    }

    @Override
    public void exitNotExpr(NaturalParser.NotExprContext ctx) {
        Type exprType = getType(ctx.expr());
        if (exprType == null) {
            // Operand has missing type
            addError(ctx, "Missing type for operand");
            setType(ctx, null);
            return;
        }
        // Check if the operand is of type Bool
        if (exprType != Type.BOOL) {
            addError(ctx, "Operand of logical negation must be of type 'Bool'");
            setType(ctx, null);
            return;
        }
        // Set the type of the negation expression to Bool
        setType(ctx, Type.BOOL);
    }

    @Override
    public void exitIfStat(NaturalParser.IfStatContext ctx) {
        ParseTree expr = ctx.expr();

        // Check the type of the condition expression
        Type exprType = getType(expr);

        if (exprType == null) {
            // Condition expression has missing type
            addError(ctx, "Missing type for condition expression");
            return;
        }

        // Check if the condition expression is of type Bool
        if (exprType != Type.BOOL) {
            addError(ctx, "Condition expression must be of type 'Bool'");
        }
    }

    /*
            While, If, RunInParallel
     */
    public void exitWhileStat(NaturalParser.WhileStatContext ctx) {
        ParseTree expr = ctx.expr();

        // Check the type of the condition expression
        Type exprType = getType(expr);

        if (exprType == null) {
            // Condition expression has missing type
            addError(ctx, "Missing type for condition expression");
            return;
        }

        // Check if the condition expression is of type Bool
        if (exprType != Type.BOOL) {
            addError(ctx, "Condition expression must be of type 'Bool'");
        }
    }
    @Override
    public void exitParallelStat(NaturalParser.ParallelStatContext ctx) {
        ParseTree expr = ctx.expr();

        // Check the type of the thread count expression
        Type exprType = getType(expr);

        if (exprType == null) {
            // Thread count expression has missing type
            addError(ctx, "Missing type for thread count expression");
            return;
        }

        // Check if the thread count expression is of type Int
        if (exprType != Type.INT) {
            addError(ctx, "Thread count expression must be of type 'Int'");
        }
    }

    @Override
    public void exitLockStat(NaturalParser.LockStatContext ctx) {
         if (table.type(ctx.ID().getText()) != Type.LOCK) {
             addError(ctx, "This is not a lock.");
         }
         String method = ctx.lockStatus().getText();
         if (!(method.equals("lock") || method.equals("unlock"))) {
             addError(ctx, "There is no such a method in lock type");
         }
    }

    @Override
    public void exitDeclGlobal(NaturalParser.DeclGlobalContext ctx) {
        String id = ctx.ID().toString();
        if (ctx.ASSIGN() == null) {
            table.put(id, getThisType(ctx.type().getText()));
            setType(ctx, getThisType(ctx.type().getText()));
            return;
        }
        table.put(id, getThisType(ctx.type().getText()));
        checkType(ctx.expr(), table.type(id));
        setType(ctx, getThisType(ctx.type().getText()));
    }

    @Override
    public void exitPrintStat(NaturalParser.PrintStatContext ctx) {
        if (ctx.expr().getChildCount() > 1) {
            addError(ctx, "Print only accepts id or integer/boolean");
        }
        if (ctx.expr().getChild(0).getChildCount() > 1) {
            addError(ctx, "Print only accepts id or integer/boolean");
        }
    }

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

    /** Convenience method to add a type to the result. */
    private void setType(ParseTree node, Type type) {
        this.result.setType(node, type);
    }

    /** Returns the type of a given expression or type node. */
    private Type getType(ParseTree node) {
        return this.result.getType(node);
    }

    private Type getThisType(String type) {
        if (type.equals("Int")) {
            return Type.INT;
        } else if (type.equals("Bool")) {
            return Type.BOOL;
        }  else if (type.equals("Lock")) {
            return Type.LOCK;
        }
        else {
            throw new IllegalArgumentException ("getThisType: This input is not valid type");
        }
    }
}
