package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SymbolTableExample {
    public static void main(String[] args) throws ParseException {
        // Create a lexer and parser for your Natural language
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString("Int a = 5;\n" +
                "Int b;\n" +
                "b = a * 11;" +
                "a = b + 10; Bool c = False; Bool d; If (a IsBiggerThan b) {} If (a IsBiggerThanOrEqualTo b) {} If (!c) {a = 100;} If (!d) {} While (d) {} " +
                "RunInParallel(b){\n" +
                "     Int x;\n" +
                "     Int y;\n" +
                "    If (x IsSmallerThan y) {\n" +
                "         Int x;" +
                "    }\n" +
                "}"));
//        "\n{\nBool b = true;\na = 5; {a = 100;}}"
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));

        // Obtain the parse tree by invoking the entry rule of your parser
        ParseTree tree = parser.program();

        // Create an instance of NaturalSymbolTable

        // Create a listener for traversing the parse tree
        NaturalListener listener = new NaturalGrammarListener() ;
        // Traverse the parse tree using the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        NaturalGrammarListener checker = new NaturalGrammarListener();
//        ParseTree body = tree.getChild(0).getChild(2).getChild(0);
//        ParseTree assX = body.getChild(0);
        Result g = checker.check(tree);
//        System.out.println(assX);
    }
}