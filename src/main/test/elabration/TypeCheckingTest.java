

import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalListener;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ut.pp.ntr.NaturalGrammarListener;
import ut.pp.ntr.ParseException;

public class TypeCheckingTest {

    NaturalGrammarListener checker; // checker for the GrammarListener
    ParseException result; // result after checking the input, should contain ParseError message (if any)

    public TypeCheckingTest() {
        NaturalListener listener = new NaturalGrammarListener();
        ParseTreeWalker walker = new ParseTreeWalker();
    }

    @Before
    public void Before() {
        checker = new NaturalGrammarListener();
    }

    /**
     * General checker function for each test. Lexer, parser and type checkers are used.
     * @param input String input of the program
     * @return parseExpression if one is caught; null if check is successful.
     */
    public ParseException check(String input) {
        ParseException exception = null;
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(input));
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();
        try {
            checker.check(tree);
        } catch (ParseException e) {
            exception = e; // catch the exception
        }
        return exception; // Returns exception if there is one; No exception: null
    }

    /**
     * A test to check for some (in)valid declarations for Int, Lock and Bool.
     */
    @Test
    public void testDifferentDeclarations() {
        // Some invalid type declarations
        result = check("Global Lock lock1 = 5;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Integer'"));

        result = check("Global Lock lock1 = True;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Boolean'"));

        result = check("Global Int someInteger = True;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Integer' but found 'Boolean'"));

        result = check("Global Bool booleanName = 1;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Boolean' but found 'Integer'"));

        result = check("Global Lock someLock = 1;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Integer'"));

        result = check("Global Lock someLock = True;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Boolean'"));

        result = check("Global Int x = 5; If (x IsEqualTo 5) { Bool y = False; Int z = True; }");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Integer' but found 'Boolean'"));

        result = check("Global Int x = 5; If (x IsEqualTo True) { Bool y = False; x = 6; }");
        Assert.assertTrue(result.getMessage().contains("Incompatible types for comparison"));

        // Some valid type declarations
        result = check("Global Int someInteger = 5;");
        Assert.assertEquals(null, result); // type checker passes

        result = check("Global Bool booleanName = True");
        Assert.assertEquals(null, result);

        result = check("Global Lock someLock;");
        Assert.assertEquals(null, result);
    }

    /**
     * A test to ensure that the condition expression contains a boolean expression, and nothing else.
     */
    @Test
    public void testConditionMustBeOfTypeBool() {
        result = check("Global Int x = 5; If (Int x = 9) { Bool y = False; Int z = 15; }");
        Assert.assertTrue(result.getMessage().contains("Condition expression must be of type 'Bool'"));

        result = check("Global Int x = 5; Global Lock myLock; If (myLock.lock;) { Bool y = False; Int z = 15; }");
        Assert.assertTrue(result.getMessage().contains("Condition expression must be of type 'Bool'"));

        result = check("Global Int x = 5; If (x IsBiggerThanOrEqualTo 9) { Bool y = False; Int z = 15; }");
        Assert.assertEquals(null, result);
    }

    /**
     * A test to ensure that the condition expression has a type.
     */
    @Test
    public void testConditionHasAType() {
        // Some wrong expressions for the If condition
        result = check("Global Int x = 5; If (false) { Bool y = False; Int z = 15; }");
        Assert.assertTrue(result.getMessage().contains("Missing type for condition expression"));

        result = check("Global Int x = 5; If () { Bool y = False; Int z = 15; }");
        Assert.assertTrue(result.getMessage().contains("Missing type for condition expression"));

        // A correct expression for the If condition
        result = check("Global Int x = 5; If (x IsEqualTo 5) { Bool y = False; Int z = 15; }");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testInvalidNumberOfOperands() {
        result = check("Global Int x = 5; If (x IsEqualTo Lock) { Bool y = False; Int z = True; }");
        Assert.assertTrue(result.getMessage().contains("Missing type for operands"));

        result = check("Global Int x = 5; If (Int x = 9) { Bool y = False; Int z = 15; }");
        Assert.assertTrue(result.getMessage().contains("Condition expression must be of type 'Bool'"));

        result = check("Int x = 5; If (x IsEqualTo 9) { Int x = 99; Int z = 15; }");
        Assert.assertEquals(null, result);
    }

    /**
     * A test that makes sure that the declared lock is global.
     */
    @Test
    public void testLockMustBeGlobal() {
        // Incorrect way of initializing a lock
        result = check("Lock mylock;");
        Assert.assertTrue(result.getMessage().contains("lock has to be declared as Global"));

        // Correct way of initializing a lock
        result = check("Global Lock correctLock;");
        Assert.assertEquals(null, result);
    }

    /**
     * A test that makes sure the lock and unlock methods are used on the lock, ot on other variable types.
     */
    @Test
    public void testUnlockLockUsedOnTheLock() {
        // Methods "lock" and "unlock" used for the incorrect variable type; throws error
        result = check("Int x = 5; x.lock; x.unlock");
        Assert.assertTrue(result.getMessage().contains("This is not a lock."));

        result = check("Bool x = True; x.lock; x.unlock");
        Assert.assertTrue(result.getMessage().contains("This is not a lock."));

        // Methods "lock" and "unlock" used for the correct variable type
        result = check("Global Lock correctLock; correctLock.lock; correctLock.unlock;");
        Assert.assertEquals(null, result);
    }

    /**
     * A test to ensure the correct methods are used for the Lock variable (either 'lock' or 'unlock').
     */
    @Test
    public void testCorrectMethodForALock() {
        // blablalock and Lock are not allowed methods for a Lock variable
        result = check("Global Lock correctLock; correctLock.blablalock;");
        Assert.assertTrue(result.getMessage().contains("There is no such a method in lock type"));
        result = check("Global Lock correctLock; correctLock.Lock;");
        Assert.assertTrue(result.getMessage().contains("There is no such a method in lock type"));

        // Sanity check: Methods "lock" and "unlock" used for the correct variable type
        result = check("Global Lock correctLock; correctLock.lock; correctLock.unlock;");
        Assert.assertEquals(null, result);
    }
}