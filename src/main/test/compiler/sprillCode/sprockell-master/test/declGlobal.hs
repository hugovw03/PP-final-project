import Sprockell

prog :: [Instruction]
prog = [ 
       Load (ImmValue 1) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA (DirAddr 4), 
       Load (ImmValue 10) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA (DirAddr 6), 
       EndProg
       ]

main = run [prog]