module Main where

import Sprockell


prog1 :: [Instruction]
prog1 = [

         Branch regSprID (Rel 7)     -- target "beginLoop"
       , Load (ImmValue 5) regA
       , WriteInstr regA (IndAddr 4)
       , Load (ImmValue 13) regC
       , WriteInstr regC (DirAddr 1) -- Sprockell 1 must jump to second EndProg
       , WriteInstr regC (DirAddr 2) -- Sprockell 2 must jump to second EndProg
       , Jump (Rel 11)               -- Sprockell 0 jumps to first EndProg
       -- beginLoop
       , ReadInstr (IndAddr regSprID)
       , Receive regE
       , Compute Equal regE reg0 regF
       , Branch regF (Rel (-3))
       -- endLoop
       , ReadInstr (IndAddr 4)
       , Receive regA
       , Load (ImmValue 6) regB
       , Compute Add regA regB regA
       , WriteInstr regA (DirAddr 4)
       , Jump (Rel 2)
       , EndProg
       , EndProg
       ]


main = runWithDebugger (debuggerSimplePrint myShow) [prog1,prog1,prog1]
