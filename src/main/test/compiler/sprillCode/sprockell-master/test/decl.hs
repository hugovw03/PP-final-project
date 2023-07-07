import Sprockell

prog :: [Instruction]
prog = [ 
       Load (ImmValue 8) regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 0), 
       Load (ImmValue 20) regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 1), 
       Load (ImmValue 0) regA, 
       Store regA (DirAddr 2), 
       Load (DirAddr 0) regA, 
       Push regA, 
       Load (DirAddr 1) regA, 
       Push regA, 
       Load (ImmValue 10) regA, 
       Push regA, 
       Pop regB, 
       Pop regA, 
       Compute Mul regA regB regA, 
       Push regA, 
       Pop regB, 
       Pop regA, 
       Compute Add regA regB regA, 
       Compute Sub regA regB regA, 
       Push regA, 
       Load (ImmValue 3) regA, 
       Push regA, 
       Pop regB, 
       Pop regA, 
       Compute Sub regA regB regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 0), 
       Push regA, 
       EndProg
       ]

main = run [prog]