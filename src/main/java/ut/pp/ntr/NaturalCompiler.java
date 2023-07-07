package ut.pp.ntr;

import main.antlr4.ut.pp.ntr.NaturalLexer;
import main.antlr4.ut.pp.ntr.NaturalListener;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;

public class NaturalCompiler {
    private final static String ABS_PATH = new File("").getAbsolutePath();
    private final static String INPUT = "src/main/test/compiler/naturalCode/";
    private final static String OUTPUT = "src/main/test/compiler/sprillCode/";

    private static CodeGen generator = new CodeGen();
    private static NaturalListener checker = new NaturalGrammarListener();

    public static void main(String[] args) {

    }


}
