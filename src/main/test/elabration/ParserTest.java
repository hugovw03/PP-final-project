package main.test.elabration;

import main.antlr4.ut.pp.ntr.NaturalLexer;
import main.antlr4.ut.pp.ntr.NaturalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    /**
     * ErrorListener class to get the errors generated when the input is parsed.
     */
    private static class ErrorListener extends BaseErrorListener {
        public static final List<String> errorMessages = new ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errorMessages.add(msg);
        }

        public static List<String> getErrorMessages() {
            return errorMessages;
        }
    }

    /**
     * A method that takes the test String as an input and stores
     * parsing error messages (if any). Used for checking if the input could be parsed.
     */
    public List<String> getParsingErrorMessages(String input) {
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(input));
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));

        ErrorListener listener = new ErrorListener();
        parser.removeErrorListeners();
        parser.addErrorListener(listener);

        ParseTree parseTree = parser.program();

        return ErrorListener.getErrorMessages();
    }

    /**
     * A test to check for some invalid declarations.
     */
    @Test
    public void testInvalidDeclaration() {
        System.out.println("-----");
        String input1 = "I//////nt x = 5;"; // [no viable alternative at input 'Int'], scanner fails on this too
        String input2 = "x = 10;"; // [no viable alternative at input 'Int']
        String input3 = "Int x = 10"; // [missing ';' at '<EOF>']
        String input4 = "int x = 10;"; // [no viable alternative at input 'intx']
        String input5 = "local Int x = 45"; // [no viable alternative at input 'localInt', missing ';' at '<EOF>']
        String input6 = "Global Int variable = \"word\";"; // mismatched input "word"...
        String input7 = "Global Boolean someB = False;"; // [extraneous input 'someB' expecting {'=', ';'}, missing {'Int', 'Bool', 'Lock'} at 'Boolean']
        String input8 = "Bool someBoolean = true;";

        Assert.assertFalse(getParsingErrorMessages(input1).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input2).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input3).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input4).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input5).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input6).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input7).isEmpty());
        Assert.assertFalse(getParsingErrorMessages(input8).isEmpty());

        System.out.println(getParsingErrorMessages(input8));
    }

    /**
     * A test to check for some valid declarations for Local/Global or regular Ints and Locks.
     */
    @Test
    public void testValidDeclaration() {
        String input1 = "Int x = 5;";
        String input2 = "Int x;";
        String input3 = "Global Int x;";
        String input4 = "Global Int x = 5;";
        String input5 = "Local Int x = 10;";
        String input6 = "Global Lock myLock;";
        String input7 = "Local Lock anotherLock;";
        String input8 = "Local Int variable;";
        String input9 = "Bool someBoolean = True;";
        String input10 = "Global Bool someBoolean = True;";
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input1).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input2).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input3).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input4).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input5).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input6).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input7).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input8).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input9).isEmpty());
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input10).isEmpty());
    }

//    @Test
//    public void

}