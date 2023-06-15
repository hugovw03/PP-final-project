package ut.pp;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import ut.pp.parser.MyLangLexer;
import ut.pp.parser.MyLangParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final Path STACK_PATH = Paths.get("stack");

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello, Programming Paradigms");

        String input = "// Line one\n"
            + "Hello\n"
            + "// Line two\n"
            + "Hello Hello\n";

        MyLangLexer myLangLexer = new MyLangLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(myLangLexer);
        MyLangParser parser = new MyLangParser(tokens);
        ParseTree tree = parser.hellos();

        System.out.println("Children: " + tree.getChildCount() + ", parsed text: " + tree.getText());

        System.out.println("Running fib(5)...");

        // Here we write to the stack process that runs the fib haskell/sprockell program directly.
        // This is one way of interfacing with haskell, but _not the only way_.
        // Other ways are also allowed and even encouraged, e.g.: writing to a haskell file and then compiling that,
        // writing json to a running process, or writing a haskell program that reads a data file that you write to disk.
        String[] command = new String[]{
                STACK_PATH.toString(),
                "run",
        };
        Process child = Runtime.getRuntime().exec(command, null, Paths.get("stack-my-lang").toFile());
        OutputStream out = child.getOutputStream();
        out.write("5".getBytes(StandardCharsets.UTF_8));
        out.close();

        InputStream in = child.getInputStream();
        InputStream err = child.getErrorStream();
        child.waitFor();
        System.out.println(new String(in.readAllBytes()).strip());
        System.out.println(new String(err.readAllBytes()).strip());
    }
}
