package main.test.elabration;

import main.antlr4.ut.pp.ntr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
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

    //general checker for each test
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
        return exception; // return exception (if any)
    }

    /**
     * A test to check for some (in)valid declarations.
     */
    @Test
    public void testGlobalDecl() {

        /*result = check("Global Lock lock1 = 5;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Integer'"));

        result = check("Global Lock lock1 = True;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Boolean'"));

        result = check("Global Int someInteger = True;");
        Assert.assertTrue(result.getMessage().contains("Expected type 'Integer' but found 'Boolean'"));*/

        result = check("Global Bool booleanName = 1;");
        /*Assert.assertTrue(result.getMessage().contains("Expected type 'Integer' but found 'Boolean'"));*/

        System.out.println(result.getMessage()); // printing the exception if any
    }

//    @Test
//    public void testGlobalDecl() {
//        result = check("Global Lock lock1 = 5;");
//        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Integer'"));
//
//        result = check("Global Lock lock1 = 5;");
//        Assert.assertTrue(result.getMessage().contains("Expected type 'Lock' but found 'Integer'"));
//
//    }



/*//        System.out.println("-----");
//        String input1 = "I//////nt x = 5;"; // [no viable alternative at input 'Int'], scanner fails on this too
        String input2 = "x = 10;"; // [no viable alternative at input 'Int']
//        String input3 = "Int x = 10"; // [missing ';' at '<EOF>']
//        String input4 = "int x = 10;"; // [no viable alternative at input 'intx']
//        String input5 = "local Int x = 45"; // [no viable alternative at input 'localInt', missing ';' at '<EOF>']
//        String input6 = "Global Int variable = \"word\";"; // mismatched input "word"...
//        String input7 = "Global Boolean someB = False;"; // [extraneous input 'someB' expecting {'=', ';'}, missing {'Int', 'Bool', 'Lock'} at 'Boolean']
//        String input8 = "Bool someBoolean = true;";
        String input9 = "Global Lock myLock = 1;";



        checker.check(input2);

//        Assert.assertFalse(getParsingErrorMessages(input1).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input2).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input3).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input4).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input5).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input6).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input7).isEmpty());
//        Assert.assertFalse(getParsingErrorMessages(input8).isEmpty());
        Assert.assertTrue(getParsingErrorMessages(input9).isEmpty());

        System.out.println(getParsingErrorMessages(input9));*/
//    }
//
//    /**
//     * A test to check for some valid declarations for Local/Global or regular Ints and Locks.
//     */
//    @Test
//    public void testValidDeclaration() {
//        String input1 = "Int x = 5;";
//        String input2 = "Int x;";
//        String input3 = "Global Int x;";
//        String input4 = "Global Int x = 5;";
//        String input6 = "Global Lock myLock;";
//        String input9 = "Bool someBoolean = True;";
//        String input10 = "Global Bool someBoolean = True;";
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input1).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input2).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input3).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input4).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input6).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input9).isEmpty());
//        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input10).isEmpty());
//
//    }
}