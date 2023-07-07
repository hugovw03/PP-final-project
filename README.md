# PP boilerplate projects

This zip contains two folders:

- `sprockell-master`: The sprokell code from the gitlab, which we need to be able to generate Sprill code.
- `src`: The folder that contains all the code written by us.

The src folder contains a folder that has all the libraries in it that we make use of. To run the code, first add these libraries in your project structure.

Inside the src folder, you will find a test folder and inside that folder a compiler folder that contains a naturalCode folder. To write a program, navigate to the naturalCode folder and create a new file of type .ntr
Inside this file you can write a program that corresponds to the language defined by us.

Next, navigate to the main and then to the java folder inside the src folder. Open the ut.pp.ntr folder and run the NaturalCompiler. This will generate a .hs file of the same name as you gave your .ntr file in the naturalCode folder. It will put this .hs file in the sprillCode.sprockell-master test folder (Below the naturalCode folder where you wrote the program)
Navigate to this folder in the terminal and run the command "stack runhaskell *name-of-file*".  