module Main where

import Sprockell

prog :: [Instruction]
prog = [
           Branch regSprID (Rel 6)     -- target "beginLoop"
         , Load (ImmValue 13) regC
         , WriteInstr regC (DirAddr 1) -- Sprockell 1 must jump to second EndProg
         , WriteInstr regC (DirAddr 2) -- Sprockell 2 must jump to second EndProg
         , WriteInstr regC (DirAddr 3) -- Sprockell 3 must jump to second EndProg
         , Jump (Abs 12)               -- Sprockell 0 jumps to first EndProg
         -- beginLoop
         , ReadInstr (IndAddr regSprID)
         , Receive regA
         , Compute Equal regA reg0 regB
         , Branch regB (Rel (-3))
         -- endLoop
         , WriteInstr regA numberIO
         , Jump (Ind regA)

         -- 12: Sprockell 0 is sent here
         , EndProg

         -- 13: Sprockells 1, 2 and 3 are sent here
         , EndProg
       ]

-- If you want to inspect the output, use debuggerSimplePrintAndWait
main = runWithDebugger (debuggerSimplePrint myShow) [prog,prog,prog,prog]



--VERY FIRST LINES OF THE PROGRAM
--
--           Branch regSprID (Rel 1)     -- target "beginLoop"
--         , Jump (Abs 12)               -- Sprockell 0 jumps to first EndProg
--         -- beginLoop
--         , ReadInstr (IndAddr regSprID)
--         , Receive regA
--         , Compute Equal regA reg0 regB
--         , Branch regB (Rel (-3))
--
--SEQUENTIAL CODE
--
--REACH PARALLEL STATEMENT
----         , Load (ImmValue 13) regC
----         , WriteInstr regC (DirAddr 1) -- Sprockell 1 must jump to second EndProg
----         , WriteInstr regC (DirAddr 2) -- Sprockell 2 must jump to second EndProg
----         , WriteInstr regC (DirAddr 3) -- Sprockell 3 must jump to second EndProg
--
--ENDPROG FOR THE THREADS
--
--CONTINUE SEQUENTIAL CODE