grammar NaturalAttr;

import NaturalLExer;

//@members {
//    private int getValue(String text) {
//        return Integer.parseInt(text);
//    }
//}
//
//expr returns [ int val ]
//     : e0=expr TIMES e1=expr
//       { $val = $e0.val * $e1.val; }
//     | e0=expr PLUS e1=expr
//       { $val = $e0.val + $e1.val; }
//     | LPAR e=expr RPAR
//       { $val = $e.val; }
//     | { System.out.println("Evaluating NUMBER"); }
//       NUMBER
//       { $val = getValue($NUMBER.text); }
//     | UNARY e=expr
//       {$val = -$e.val;}
//     ;