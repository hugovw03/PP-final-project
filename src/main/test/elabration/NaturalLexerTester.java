//import main.antlr4.ut.pp.ntr.NaturalLexer;
//import org.junit.Test;
//
//public class NaturalLexerTester {
//    private static LexerTester tester = new LexerTester(NaturalLexer.class);
//
//    @Test
//    public void integerDeclarationTest() {
//        tester.correct("Int x = 55;");
//        tester.yields("Int x = 55;", NaturalLexer.INT, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.INT, NaturalLexer.SEMICOLON);
//        tester.correct("Int name;");
//        tester.yields("Int name;", NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON);
//        tester.wrong("Int x");
//        tester.wrong("Bool x");
//        tester.wrong("Boolean x;");
//    }
//
//    @Test
//    public void booleanDeclarationTest() {
//        tester.correct("Bool flag = True;");
//        tester.yields("Bool flag = True;", NaturalLexer.BOOL, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON);
//        tester.correct("Bool testedValue;");
//        tester.yields("Bool testedValue;", NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.SEMICOLON);
//    }
//
//    @Test
//    public void globalLocalTest() {
//        tester.correct("Global Int a;");
//        tester.yields("Global Int a;", NaturalLexer.GLOBAL, NaturalLexer.INT,
//                NaturalLexer.ID, NaturalLexer.SEMICOLON);
//        tester.correct("Local Int b = 123;");
//        tester.yields("Local Int b = 123;", NaturalLexer.LOCAL, NaturalLexer.INT,
//                NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
//        tester.correct("Local Lock myLock;");
//        tester.correct("Global Lock anotherLock;");
//    }
//
//    @Test
//    public void lockTest() {
//        tester.correct("Lock myLock;");
//        tester.yields("Lock myLock;", NaturalLexer.LOCK, NaturalLexer.ID, NaturalLexer.SEMICOLON);
//    }
//
//    @Test
//    public void ifBlockTest() {
//        tester.correct("Int a;\n" +
//                "        Int b;\n" +
//                "        If (a IsBiggerThan b) {\n" +
//                "            Bool a = True;\n" +
//                "            While (a) {\n" +
//                "                Print (b);\n" +
//                "            }\n" +
//                "        }");
//        tester.yields("Int a;\n" +
//                "        Int b;\n" +
//                "        If (a IsBiggerThan b) {\n" +
//                "            Bool a = True;\n" +
//                "            While (a) {\n" +
//                "                Print (b);\n" +
//                "            }\n" +
//                "        }",
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
//                NaturalLexer.IF, NaturalLexer.LPAR, NaturalLexer.ID,
//                NaturalLexer.GT, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.LBRAC,
//                NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON,
//                NaturalLexer.WHILE, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, Nar);
//    }
//}
