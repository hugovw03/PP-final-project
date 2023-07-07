

import main.antlr4.ut.pp.parser.NaturalLexer;
import org.junit.Test;

public class NaturalLexerTester {
    private static LexerTester tester = new LexerTester(NaturalLexer.class);

    /**
     * A test to check that the scanner recognizes some simple tokens.
     */
    @Test
    public void integerDeclarationTest() {
        tester.correct("Int x = 55;");
        tester.yields("Int x = 55;", NaturalLexer.INT, NaturalLexer.ID,
                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
        tester.correct("Int name;");
        tester.yields("Int name;", NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON);
        tester.wrong("I////nt x");
        tester.wrong("Bo//ol x");
        tester.wrong("B//oolean x;");
    }

    /**
     * A test to see that the scanner recognizes some tokens used for the variable initialization.
     */
    @Test
    public void booleanDeclarationTest() {
        tester.correct("Bool flag = True;");
        tester.yields("Bool flag = True;", NaturalLexer.BOOL, NaturalLexer.ID,
                NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON);
        tester.correct("Bool testedValue;");
        tester.yields("Bool testedValue;", NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.SEMICOLON);
        tester.wrong("Bool flag = Tr//ue;");
        tester.wrong("Bool flag = Fals//e;");
    }

    /**
     * A test to check that the scanner recognizes Global token.
     */
    @Test
    public void globalTest() {
        tester.correct("Global Int a;");
        tester.yields("Global Int a;", NaturalLexer.GLOBAL, NaturalLexer.INT,
                NaturalLexer.ID, NaturalLexer.SEMICOLON);
        tester.correct("Global Lock anotherLock;");
        tester.wrong("Globa////l Lock somethingToDoLocking");
    }

    /**
     * A test to check that the scanner recognizes the Lock token.
     */
    @Test
    public void lockTest() {
        tester.correct("Lock myLock;");
        tester.correct("LocksomeNameWithNoSpace;");
        tester.yields("Lock myLock;", NaturalLexer.LOCK, NaturalLexer.ID, NaturalLexer.SEMICOLON);
        tester.wrong("Lo///ck someLock;");
    }

    /**
     * A test to check that for some small program, all tokens are recognized correctly.
     */
    @Test
    public void ifBlockTest() {
        tester.correct("Int a;\n" +
                "        Int b;\n" +
                "        If (a IsBiggerThan b) {\n" +
                "            Bool a = True;\n" +
                "            While (a) {\n" +
                "                Print (b);\n" +
                "            }\n" +
                "        }");
        tester.yields("Int a;\n" +
                        "        Int b;\n" +
                        "        If (a IsBiggerThan b) {\n" +
                        "            Bool a = True;\n" +
                        "            While (a) {\n" +
                        "                Print (b);\n" +
                        "            }\n" +
                        "        }",
                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
                NaturalLexer.IF, NaturalLexer.LPAR, NaturalLexer.ID,
                NaturalLexer.GT, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.LBRAC,
                NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON,
                NaturalLexer.WHILE, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.LBRAC,
                NaturalLexer.PRINT, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.SEMICOLON,
                NaturalLexer.RBRAC, NaturalLexer.RBRAC);
    }

    /**
     * A test to ensure that the program recognizes the comparison tokens.
     */
    @Test
    public void testComparisonTokens() {
        tester.yields("If (a IsSmallerThan b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.LT, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsBiggerThan b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.GT, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsSmallerThan b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.LT, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsEqualTo b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.EQ, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsNotEqualTo b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.NE, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsBiggerThanOrEqualTo b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.LET, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.yields("If (a IsSmallerThanOrEqualTo b)", NaturalLexer.IF, NaturalLexer.LPAR,
                NaturalLexer.ID, NaturalLexer.SET, NaturalLexer.ID, NaturalLexer.RPAR);
        tester.wrong("If (a IsSmal//lerThan b)");
        tester.wrong("If (a IsBigg$rThan b");
        tester.wrong("If (a IsEqu<alTo b)");
        tester.wrong("If (a IsNotEqu/lTo b)");
        tester.wrong("If (a IsBiggerThe/nOrEqualTo b)");
        tester.wrong("If (a IsSmalerThanOrEqal/To b)");
    }

    /**
     * A test to ensure the scanner recognizes the tokens for the negative number.
     * Negative number is still recognized as NUM token, yet it consists of DIGIT(S)
     * and NEGATE token.
     */
    @Test
    public void testNegativeNumbers() {
        // This would represent -1
        tester.yields("Int x = 1negative;", NaturalLexer.INT, NaturalLexer.ID,
                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
        tester.yields("Int x = 9999999999999negative;", NaturalLexer.INT, NaturalLexer.ID,
                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
        tester.wrong("Int x = 9999999999999negat/ive;");
    }
}
