module Main where

import Sprockell


prog1 :: [Instruction]
prog1 = [
       Load (ImmValue 5) regA,
       Push regA,
       Pop regA,
       WriteInstr regA (DirAddr 4),
       ReadInstr (DirAddr 4),
       Receive regA,
       Push regA,
       Pop regA,
       WriteInstr regA charIO,
       EndProg
       ]


main = runWithDebugger (debuggerSimplePrint myShow) [prog1]
