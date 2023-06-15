# PP Final Project: Maven+Stack boilerplate project

This folder contains a boilerplate project for Java, Maven, Haskell and Stack, which includes:

- JUnit integration
- ANTLR integration
- Example grammar of the "Hello" language (which allows zero or more repetitions of "Hello")
- Example test of the "Hello" language
- HSpec/QuickCheck
- ParSec
- Sprockell
- Example program that parses a number and generates a SPRIL program which calculates the fibonacci numbers up to the given number

In essence, it is a merged version of the Maven project & Stack project.

For any specific aspects on how to use the individual projects, we direct you to the individual README's of the projects (`README_maven.md` and `stack-my-lang/README.md`).

There are a few concerns that you should keep in mind while developing your project:

- For testing, it does not matter if you do it in Java, or Haskell, whichever one you prefer. What is important is that you use either one, to make testing as automatic as possible.
- Ensure your compiler has one entry point, not two. This means that if you need two command line invocations to start two separate parts of your compiler (e.g. one in Java, one in Haskell), you should write some glue code, either in Java or in Haskell, that calls the second part for you.
- Document the architecture, and also how we can invoke the the parts written in Java & Haskell individually. This will also be useful for yourself when developing & debugging your compiler.
