package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SymbolTableExample {
    public static void main(String[] args) {
        // Create a lexer and parser for your Natural language
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString("Int b = 15;\n{\nBool b = true;\na = 5; {a = 100;}}"));
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));

        // Obtain the parse tree by invoking the entry rule of your parser
        ParseTree tree = parser.program();

        // Create an instance of NaturalSymbolTable
        SymbolTable<ParseTree> symbolTable = new NaturalSymbolTable();

        // Create a listener for traversing the parse tree
        NaturalListener listener = new NaturalGrammarListener() ;
        // Traverse the parse tree using the listener
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

    }
}