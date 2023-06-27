lexer grammar NaturalLexer;

//key words
INT:    'Int';
BOOL:   'Bool';
IF:     'If';
WHILE:  'While';
PRINT:  'Print';
LOCAL:  'Local';
GLOBAL: 'Global';
LOCK:   'Lock';
TRUE:   'True';
FALSE:  'False';

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

//Comparison
ASSIGN: '=';
EQUALS: 'IsBiggerThan'
     |  'IsSmallerThan'
     |  'IsEqualTo'
     |  'IsSmallerThanOrEqualTo'
     |  'IsBiggerThanOrEqualTo'
     |  'NotEqualTo';

CONST_BOOL: TRUE | FALSE;

CONST_INT: [0-9]+;
ID: [a-zA-Z][a-zA-Z0-9]*;

COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

WS: [\t\n\r]+ -> skip;
//CHAR: '\'' ~'\'' +'\'';