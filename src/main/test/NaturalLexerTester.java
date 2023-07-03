//import main.antlr4.ut.pp.ntr.NaturalLexer;
//import org.junit.Test;
//
///*
//    Some things are for the lexer, some for the parser checker (potentially),
//    Move out to different files later
// */
//
//public class NaturalLexerTester {
//    private static LexerTester tester = new LexerTester(NaturalLexer.class);
//
//    @Test
//    public void invalidCharTest() {
//        tester.wrong("Int x = 10;\n" +
//                "&");
//    }
//
//    @Test
//    public void unclosedStringTest() {
//        tester.wrong("Print(\"Hello, World!);");
//    }
//
//    @Test
//    public void invalidIDTest() {
//        tester.wrong("int 123abc = 10;");
//    }
//
//    @Test
//    public void integerDeclarationTest() throws LexerTester.LexerException {
//        tester.correct("In/////t x = 5 5;");
//        tester.yields("Int x = 55;", NaturalLexer.BOOL, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
//        //testing integer declaration with an integer value
//        System.out.println(tester.scan("In t x = 5 5;"));
//        tester.correct("In/////t x = 5 5;");
//        System.out.println(tester.scan("Int x = 55;"));
//        tester.wrong("I nt x = 5 5;");
//        tester.yields("Int x = 55;", NaturalLexer.INT, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
//        //testing integer declaration with no value declaration
//        tester.correct("Int name;");
//        tester.yields("Int name;", NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON);
//        //some wrong declaration cases
//        tester.wrong("Int x");      // no ;
//        tester.wrong("Bool x");     // no ;
//        tester.wrong("Boolean x;"); // should be Bool
//    }
//
//    @Test
//    public void booleanDeclarationTest() {
//        //testing boolean declaration with assigned value
//        tester.correct("Bool flag = True;");
//        tester.yields("Bool flag = True;", NaturalLexer.BOOL, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON);
//        // testing boolean declaration with no assigned value
//        tester.correct("Bool testedValue;");
//        tester.yields("Bool testedValue;", NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.SEMICOLON);
//    }
//
//    @Test
//    public void globalLocalTest() {
//        //testing global declaration
//        tester.correct("Global Int a;");
//        tester.yields("Global Int a;", NaturalLexer.GLOBAL, NaturalLexer.INT,
//                NaturalLexer.ID, NaturalLexer.SEMICOLON);
//
//        //testing local declaration
//        tester.correct("Local Int b = 123;");
//        tester.yields("Local Int b = 123;", NaturalLexer.LOCAL, NaturalLexer.INT,
//                NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON);
//        // testing local and global declaration with a lock
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
//    // For now, not possible to print a regular variable; only a String
//    @Test
//    public void printTest() {
//        tester.yields("Print (a);", NaturalLexer.PRINT, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.SEMICOLON);
//        tester.yields("Print(\"Hello World!\");", NaturalLexer.PRINT, NaturalLexer.LPAR,
//                NaturalLexer.STRING, NaturalLexer.RPAR, NaturalLexer.SEMICOLON);
//        tester.wrong("Print(\"Hello World!);");
//        tester.wrong("Print a;");
//        tester.wrong("print a");
//    }
//
//    @Test
//    public void ifBlockTester() {
//        //testing an empty if block
//        tester.correct("Int abc = 5;\n" +
//                "        If (abc IsBiggerThan 5) {\n" +
//                "\n" +
//                "        }");
//        tester.yields("Int abc = 5;\n" +
//                "        If (abc IsBiggerThan 5) {\n" +
//                "\n" +
//                "        }",
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON,
//                NaturalLexer.IF, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.GT, NaturalLexer.NUM,
//                NaturalLexer.RPAR, NaturalLexer.LBRAC, NaturalLexer.RBRAC);
//
//        //testing an if block with no condition (not allowed)
//        tester.wrong("Int abc = 5;\n" +
//                "        If () {\n" +
//                "            abc = 6;\n" +
//                "        }");
//    }
//
//    @Test
//    public void whileBlockTester() {
//        tester.correct("Int val = 10;" +
//                "        While (val IsNotEqualTo 8) {" +
//                "            val = val - 1;" +
//                "        }");
//        tester.yields("Int val = 10;\n" +
//                "        While (val IsNotEqualTo 8) {\n" +
//                "            val = val - 1;\n" +
//                "        }",
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON,
//                NaturalLexer.WHILE, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.NE, NaturalLexer.NUM,
//                NaturalLexer.RPAR, NaturalLexer.LBRAC, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.ID,
//                NaturalLexer.MINUS, NaturalLexer.NUM, NaturalLexer.SEMICOLON, NaturalLexer.RBRAC);
//    }
//
//    @Test
//    public void whileInsideIFBlockTest() {
//        tester.correct("Int a;\n" +
//                "        Int b;\n" +
//                "        If (a IsBiggerThan b) {\n" +
//                "            Bool a = True;\n" +
//                "            While (a) {\n" +
//                "                Print (b);\n" +
//                "            }\n" +
//                "        }\n" +
//                "        Else {\n" +
//                "            a = 5;\n" +
//                "        }");
//        tester.yields("Int a;\n" +
//                        "        Int b;\n" +
//                        "        If (a IsBiggerThan b) {\n" +
//                        "            Bool a = True;\n" +
//                        "            While (a) {\n" +
//                        "                Print (b);\n" +
//                        "            }\n" +
//                        "        }\n" +
//                        "        Else {\n" +
//                        "            a = 5;\n" +
//                        "        }",
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
//                NaturalLexer.INT, NaturalLexer.ID, NaturalLexer.SEMICOLON,
//                NaturalLexer.IF, NaturalLexer.LPAR, NaturalLexer.ID,
//                NaturalLexer.GT, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.LBRAC,
//                NaturalLexer.BOOL, NaturalLexer.ID, NaturalLexer.ASSIGN, NaturalLexer.TRUE, NaturalLexer.SEMICOLON,
//                NaturalLexer.WHILE, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.LBRAC,
//                NaturalLexer.PRINT, NaturalLexer.LPAR, NaturalLexer.ID, NaturalLexer.RPAR, NaturalLexer.SEMICOLON,
//                NaturalLexer.RBRAC, NaturalLexer.RBRAC, NaturalLexer.ELSE, NaturalLexer.LBRAC, NaturalLexer.ID,
//                NaturalLexer.ASSIGN, NaturalLexer.NUM, NaturalLexer.SEMICOLON, NaturalLexer.RBRAC);
//    }
//
//    @Test
//    public void commentBlockTest() {
//        tester.correct("/* This should be a comment*/");
//        tester.yields("/* This should be a comment*/", NaturalLexer.COMMENT);
//        tester.correct("/**/"); // empty comment
//        tester.yields("/**/", NaturalLexer.COMMENT);
//        tester.wrong("/*This is some comment that is unfinished*");
//        tester.wrong("/*This is some comment that is unfinished/*");
//        tester.wrong("/*/**/*/");
//    }
//}
