
import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A ParserTest class which has some tests that ensure that the parse
 * tree is generated of the given input.
 */

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
        String input3 = "Int x = 10"; // [missing ';' at '<EOF>']
        String input4 = "int x = 10;"; // [no viable alternative at input 'intx']
        String input5 = "local Int x = 45"; // [no viable alternative at input 'localInt', missing ';' at '<EOF>']
        String input6 = "Global Int variable = \"word\";"; // mismatched input "word"...
        String input7 = "Global Boolean someB = False;"; // [extraneous input 'someB' expecting {'=', ';'}, missing {'Int', 'Bool', 'Lock'} at 'Boolean']

        Assert.assertFalse(getParsingErrorMessages(input3).isEmpty());
        getParsingErrorMessages(input3).clear();
        Assert.assertFalse(getParsingErrorMessages(input4).isEmpty());
        getParsingErrorMessages(input4).clear();
        Assert.assertFalse(getParsingErrorMessages(input5).isEmpty());
        getParsingErrorMessages(input5).clear();
        Assert.assertFalse(getParsingErrorMessages(input6).isEmpty());
        getParsingErrorMessages(input6).clear();
        Assert.assertFalse(getParsingErrorMessages(input7).isEmpty());
        getParsingErrorMessages(input7).clear();
    }

    /**
     * A test to check for some valid declarations for Local/Global or regular Ints and Locks.
     */
    @Test
    public void testValidDeclaration() {
        String input = "Int x = 5;";
        String input2 = "Int x;";
        String input3 = "Global Int x;";
        String input4 = "Global Int x = 5;";
        String input6 = "Global Lock myLock;";
        String input7 = "Lock anotherLock;";
        String input9 = "Bool someBoolean = True;";
        String input10 = "Global Bool someBoolean = True;";

        Assert.assertTrue(getParsingErrorMessages(input).isEmpty());
        getParsingErrorMessages(input).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input2).isEmpty());
        getParsingErrorMessages(input2).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input3).isEmpty());
        getParsingErrorMessages(input3).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input4).isEmpty());
        getParsingErrorMessages(input4).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input6).isEmpty());
        getParsingErrorMessages(input6).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input7).isEmpty());
        getParsingErrorMessages(input7).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input9).isEmpty());
        getParsingErrorMessages(input9).clear();
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(input10).isEmpty());
        getParsingErrorMessages(input10).clear();
    }

    /**
     * A test to check if the parser accepts simple if statements.
     */
    @Test
    public void testIfDeclarations() {
        String input1 = "Int x = 10;\n" +
                "If (x IsEqualTo 11) {\n" +
                "    Int y = 11; \n" +
                "}";
        Assert.assertTrue("This is a valid If block", getParsingErrorMessages(input1).isEmpty());
        getParsingErrorMessages(input1).clear();

        String input2 = "Int x = 10;\n" +
                "If x IsEqualTo 11 {\n" +
                "    Int y = 11; \n" +
                "}";
        Assert.assertFalse(getParsingErrorMessages(input2).isEmpty());
        getParsingErrorMessages(input2).clear();

        String input3 = "Int x = 10;\n" +
                "If (x IsEqualTwo 11) {\n" +
                "    Int y = 11; \n" +
                "}";
        Assert.assertFalse(getParsingErrorMessages(input3).isEmpty());
        getParsingErrorMessages(input3).clear();
    }

    /**
     * A test to ensure that While loop with contents inside of it could get parsed.
     */
    @Test
    public void testWhileDeclarations() {
        String someInput = "Int number = 1;\n" +
                "While(number IsBiggerThanOrEqualTo 0) {\n" +
                "    Int x = 10;\n" +
                "    If (x IsEqualTo 11) {\n" +
                "        Int y = 11; \n" +
                "    }\n" +
                "}";
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(someInput).isEmpty());
        getParsingErrorMessages(someInput).clear();

        String someInput1 = "Int anotherNumber = 2;\n" +
                "While(anotherNumber IsBiggerThan 0) {\n" +
                "    While(number IsBiggerThanOrEqualTo 0) {\n" +
                "        Int x = 10;\n" +
                "        If (x IsEqualTo 11) {\n" +
                "            Int y = 11; \n" +
                "        }\n" +
                "    }\n" +
                "}";
        Assert.assertTrue("This is a valid input", getParsingErrorMessages(someInput1).isEmpty());
        getParsingErrorMessages(someInput1).clear();

        String someInput2 = "Int anotherNumber = 2;\n" +
                "While(anotherNumber IsBiggerThan 0) {\n" +
                "    While(number IsBiggerThanOrEqualTo 0) {\n" +
                "        Int x = 10;\n" +
                "        If (x IsEqualTo 11) {\n" +
                "            Int y = 11; \n" +
                "        }\n" +
                "    }\n" +
                "";
        Assert.assertFalse(getParsingErrorMessages(someInput2).isEmpty());
        getParsingErrorMessages(someInput2).clear();
    }
}