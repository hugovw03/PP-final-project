import Sprockell

prog :: [Instruction]
prog = [ 
       Load (ImmValue 5) regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 0), 
       Load (DirAddr 0) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA numberIO, 
       Load (ImmValue 1) regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 1), 
       Load (DirAddr 1) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA numberIO, 
       Load (ImmValue 6) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA numberIO, 
       EndProg
       ]

main = run [prog]