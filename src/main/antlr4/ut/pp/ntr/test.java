package main.antlr4.ut.pp.ntr;

import ut.pp.ntr.NaturalGrammarListener;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class test {
    public static void main(String[] args) {
        String code = "        Global Int a;\n" +
                "        Int b;\n" +
                "        If (a IsBiggerThan b) {\n" +
                "            Bool a = True;\n" +
                "            While (a) {\n" +
                "                Print (\"This is better now\");\n" +
                "            }\n" +
                "        }\n" +
                "        Else {\n" +
                "            a = 5;\n" +
                "        }";
        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        NaturalParser parser = new NaturalParser(tokens);

        NaturalParser.ProgramContext programContext = parser.program();
        NaturalGrammarListener listener = new NaturalGrammarListener();
        ParseTreeWalker.DEFAULT.walk(listener, programContext);
    }
}
