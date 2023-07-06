module Main where

import Sprockell
{-
    The Sprockells holding SPID > 0 will read from their respective memory addresses
    until they find a value which is not equal to zero. If it finds such a value, it
    jumps to that memory address. (This example will let them jump to EndProg.)
-}

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
              Branch regE (Rel (-3)),


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
