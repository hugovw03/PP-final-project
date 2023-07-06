module Main where

import Sprockell
{-
    The Sprockells holding SPID > 0 will read from their respective memory addresses
    until they find a value which is not equal to zero. If it finds such a value, it
    jumps to that memory address. (This example will let them jump to EndProg.)
-}

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

       -- 12: Sprockell 0 is sent here
       , EndProg
              -- 13: Sprockells 1, 2 and 3 are sent here

       ,       EndProg


              Branch regSprID (Rel 8),
              Load (ImmValue 5) regA,
              Push regA,
              Pop regA,
              WriteInstr regA (DirAddr 4),
               WriteInstr regA (DirAddr 1),
               WriteInstr regA (DirAddr 2),
              Jump (Rel 21),


              ReadInstr (IndAddr regSprID),
              Receive regD,
              Compute Equal regD reg0 regE,
              Branch regD (Rel (-3)),


              ReadInstr (DirAddr 4),
              Push regA,
              Load (ImmValue 6) regA,
              Push regA,
              Pop regB,
              Pop regA,
              Compute Add regA regB regA,
              Push regA,
              Pop regA,
              WriteInstr regA (DirAddr 4),
              ReadInstr (DirAddr 4),
              Receive regB,
              Compute NEq regA regB regC,
              Branch regC (Rel (-4)),
              Push regA,
              Jump (Rel 1),

       ]


main = runWithDebugger (debuggerSimplePrint myShow) [prog1,prog1,prog1]
