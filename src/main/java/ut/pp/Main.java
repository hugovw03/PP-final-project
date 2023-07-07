package ut.pp;

import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import main.antlr4.ut.pp.parser.NaturalLexer;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Programming Paradigms");

        String input =  "Hello\n";


        NaturalLexer NaturalLexer = new NaturalLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(NaturalLexer);
        NaturalParser parser = new NaturalParser(tokens);
        ParseTree tree = parser.program();

        System.out.println("Children: " + tree.getChildCount() + ", parsed text: " + tree.getText());
    }
}
