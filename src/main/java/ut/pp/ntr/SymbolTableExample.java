package ut.pp.ntr;

import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalListener;
import main.antlr4.ut.pp.parser.NaturalParser;
import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalListener;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import ut.pp.ntr.CodeGen;
import ut.pp.ntr.NaturalGrammarListener;
import ut.pp.ntr.ParseException;
import ut.pp.ntr.Result;

public class SymbolTableExample {
    public static void main(String[] args) throws ParseException {
        // Create a lexer and parser for your Natural language
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(
                " Global Int a = 5; Global Lock myLock; RunInParallel(4) {myLock.lock; a = a + 5; myLock.unlock;}"
));

//        Global Lock lock1; Int a = 10; Int b = 20; If (a IsBiggerThan b) { b = 200;} Else{lock1.lock; a = a + b; lock1.unlock}
//        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(
//        "Int a = 10;Int b = 20;Int c = 30; {Int d = 40; a = 20; Int c = 50; c = 77;} c = 99;"
//
//        ));

//        good test for symboltable


//        "a = b + 10; Bool c = False; Bool d; If (a IsBiggerThan b) {} If (a IsBiggerThanOrEqualTo b) {} If (!c) {a = 100;} If (!d) {} While (d) {} " +
//                "RunInParallel(b){\n" +
//                "     Int x;\n" +
//                "     Int y;\n" +
//                "    If (x IsSmallerThan y) {\n" +
//                "         Int x;" +
//                "    }\n" +
//                "}"

//        "\n{\nBool b = true;\na = 5; {a = 100;}}"
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));

        // Obtain the parse tree by invoking the entry rule of your parser
        ParseTree tree = parser.program();
        NaturalGrammarListener checker = new NaturalGrammarListener();
        Result g = checker.check(tree);

        CodeGen gen = new CodeGen();
        System.out.println(gen.generate(tree));
        // Create an instance of NaturalSymbolTable

        // Create a listener for traversing the parse tree
        NaturalListener listener = new NaturalGrammarListener() ;
        // Traverse the parse tree using the listener
        ParseTreeWalker walker = new ParseTreeWalker();
//        ParseTree body = tree.getChild(0).getChild(2).getChild(0);
//        ParseTree assX = body.getChild(0);
        System.out.println(g);
//        System.out.println(assX);
    }
}