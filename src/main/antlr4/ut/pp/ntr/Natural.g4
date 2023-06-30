grammar Natural;

program: stat+ EOF;

stat: decl type ID (ASSIGN expr)? SEMICOLON     #declGlobalAndLocal
    | type ID (ASSIGN expr)? SEMICOLON          #declNormal
    | ID ASSIGN expr SEMICOLON                  #assignToVar
    | IF LPAR expr RPAR stat (ELSE stat)?       #ifStat
    | WHILE LPAR expr RPAR stat                 #whileStat
    | RUNPAR LPAR expr RPAR stat                #parallelStat
    | LBRAC stat* RBRAC                         #block
    | PRINT LPAR STRING RPAR SEMICOLON          #printStat
    |expr DOT (LON | LOFF) SEMICOLON            #lockStat
    ;

expr: NOT expr                                  #notExpr
    | expr TIMES expr                           #multExpr
    | expr op expr                              #addExpr
    | expr (LT | GT | EQ | NE | LET | SET) expr #compExpr
    | LPAR expr RPAR                            #parExpr
    | (NUM | TRUE | FALSE)                      #constExpr
    | ID                                        #idExpr
    ;

op: PLUS | MINUS;
decl: GLOBAL | LOCAL;

type: INT | BOOL | LOCK;

//key words
INT:    'Int';
BOOL:   'Bool';
IF:     'If';
ELSE:   'Else';
WHILE:  'While';
PRINT:  'Print';
LOCAL:  'Local';
GLOBAL: 'Global';
LOCK:   'Lock';
TRUE:   'True';
FALSE:  'False';
DOT:    '.';

//Lock functions
LON: 'lock';
LOFF: 'unlock';

//Comparison
ASSIGN: '=';
LT: 'IsSmallerThan';
GT: 'IsBiggerThan';
EQ: 'IsEqualTo';
NE: 'IsNotEqualTo';
LET: 'IsBiggerThanOrEqualTo';
SET: 'IsSmallerThanOrEqualTo';
NOT: '!';

//blocks
SEMICOLON:   ';';
LBRAC:       '{' ;
RBRAC:       '}';
LPAR:        '(' ;
RPAR:         ')';

//Op
TIMES  : '*';
PLUS   : '+';
MINUS  : '-';
RUNPAR : 'RunInParallel';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT+;
STRING: '"' (~["\\] | '\\'.)* '"';

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS: [ \t\r\n]+ -> skip;
//CHAR: '\'' ~'\'' +'\'';