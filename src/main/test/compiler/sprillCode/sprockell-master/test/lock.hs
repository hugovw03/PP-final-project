import Sprockell

prog :: [Instruction]
prog = [ 
       TestAndSet (DirAddr 4), 
       Receive regA, 
       Compute Equal reg0 regA regA,
       Branch regA (Rel (-3)), 
       Load (ImmValue 1) regA, 
       WriteInstr regA (DirAddr 4), 
       WriteInstr reg0 (DirAddr 4), 
       EndProg
       ]

main = run [prog]