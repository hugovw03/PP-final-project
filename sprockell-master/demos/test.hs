module Main where

import Sprockell


prog1 :: [Instruction]
prog1 = [
       Branch regSprID (Rel 8),
       Load (ImmValue 5) regA,
       Push regA,
       Pop regA,
       WriteInstr regA (DirAddr 4),
       WriteInstr regA (DirAddr 1),
       WriteInstr regA (DirAddr 2),
       Jump (Rel 18),
       ReadInstr (IndAddr regSprID),
       Receive regD,
       Compute Equal regD reg0 regE,
       Branch regD (Rel (-3)),
       ReadInstr (DirAddr 4),
       Receive regA,
       Push regA,
       Load (ImmValue 6) regA,
       Push regA,
       Pop regB,
       Pop regA,
       Compute Add regA regB regA,
       Push regA,
       Pop regA,
       WriteInstr regA (DirAddr 4),
       Push regA,
       Jump (Rel 1),
       EndProg
       ]


main = runWithDebugger (debuggerSimplePrint myShow) [prog1,prog1,prog1]
