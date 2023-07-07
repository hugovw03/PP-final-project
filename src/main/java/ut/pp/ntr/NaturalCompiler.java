package ut.pp.ntr;

import main.antlr4.ut.pp.parser.NaturalLexer;
import main.antlr4.ut.pp.parser.NaturalListener;
import main.antlr4.ut.pp.parser.NaturalParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class NaturalCompiler {
    private final static String INPUT = "src/main/test/compiler/naturalCode/";
    private final static String OUTPUT = "src/main/test/compiler/sprillCode/sprockell-master/test";

    public static void main(String[] args) {
        Path sourceRoot = Path.of(INPUT); // Replace "source_root" with the actual root directory path
        Path destinationRoot = Path.of(OUTPUT); // Replace "destination_root" with the desired destination directory path

        try {
            // Iterate over files in the source root directory
            Files.walk(sourceRoot)
                    .filter(Files::isRegularFile)
                    .forEach(sourceFile -> {
                        try {
                            // Derive the destination file path based on the source file path
                            Path relativePath = sourceRoot.relativize(sourceFile);
                            Path destinationFile = destinationRoot.resolve(relativePath);
                            destinationFile = changeFileExtension(destinationFile, ".hs");
                            // Compile the source file and save the compiled file to the destination directory
                            compileAndSave(sourceFile, destinationFile);

                            System.out.println("Compiled and saved: " + sourceFile + " -> " + destinationFile);
                        } catch (IOException | ParseException e) {
                            e.printStackTrace();
                        }
                    });

            System.out.println("Compilation process completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Your compileAndSave method implementation
    private static void compileAndSave(Path sourceFile, Path destinationFile) throws IOException, ParseException {
        // Implement your compiler logic here
        // Read the source file, perform compilation, and save the compiled file to the destination directory
        // Example:
        String sourceCode = Files.readString(sourceFile);

        NaturalLexer lexer = new NaturalLexer(CharStreams.fromString(sourceCode));
        NaturalParser parser = new NaturalParser(new CommonTokenStream(lexer));
        NaturalGrammarListener checker = new NaturalGrammarListener();
        CodeGen gen = new CodeGen();
        System.out.println("start parsing -------------> " + sourceFile + "\n");
        ParseTree tree = parser.program();

        System.out.println("start type checking--------> " + sourceFile + "\n");
        checker.check(tree);
        System.out.println("start code generation------> " + sourceFile + "\n");
        String compiledCode = gen.generate(tree);
        Path destinationFileWithExtension = changeFileExtension(destinationFile, ".hs");
        Files.writeString(destinationFileWithExtension, compiledCode);
    }

    private static Path changeFileExtension(Path filePath, String newExtension) {
        String fileName = filePath.getFileName().toString();
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
        return filePath.getParent().resolve(fileNameWithoutExtension + newExtension);
    }

}
