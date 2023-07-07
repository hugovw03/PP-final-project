import Sprockell

prog :: [Instruction]
prog = [ 
       Branch regSprID (Rel 10), 
       Load (ImmValue 5) regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA (DirAddr 4), 
       WriteInstr regA (DirAddr 1),
       WriteInstr regA (DirAddr 2),
       WriteInstr regA (DirAddr 3),
       WriteInstr regA (DirAddr 4),
       Jump (Rel 56), 
       ReadInstr (IndAddr regSprID),
       Receive regD, 
       Compute Equal regD reg0 regE, 
       Branch regD (Rel (-3)), 
       Load (ImmValue 60) regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 0), 
       Load (DirAddr 0) regA, 
       Push regA, 
       Pop regC, 
       Load (ImmValue 30) regA, 
       Push regA, 
       Pop regD, 
       Push regC, 
       Push regD, 
       Pop regB, 
       Pop regA, 
       Compute Gt regA regB regA, 
       Push regA, 
       Pop regA,
       Compute Equal reg0 regA regA,
       Branch regA (Rel 32),
        TestAndSet (DirAddr 5), 
       Receive regA, 
       Compute Equal reg0 regA regA,
       Branch regA (Rel (-3)), 
       Load (ImmValue 1) regA, 
       WriteInstr regA (DirAddr 5), 
       ReadInstr (DirAddr 4), 
       Receive regA, 
       Push regA, 
       Load (ImmValue 5) regA, 
       Push regA, 
       Pop regB, 
       Pop regA, 
       Compute Add regA regB regA, 
       Push regA, 
       Pop regA, 
       WriteInstr regA (DirAddr 4), 
       Push regA, 
       WriteInstr reg0 (DirAddr 5), 
       Load (DirAddr 0) regA, 
       Push regA, 
       Load (ImmValue 1) regA, 
       Push regA, 
       Pop regB, 
       Pop regA, 
       Compute Sub regA regB regA, 
       Push regA, 
       Pop regA, 
       Store regA (DirAddr 0), 
       Push regA, 
       Jump (Rel (-47)),
       Jump (Rel 1), 
       EndProg
       ]

main = run [prog, prog, prog, prog, prog]