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


SEMICOLON:  ';';
BRAC:       '{' | '}';
PARENS:     '(' | ')';


CONST_INT: [0-9]+;
ID: [a-zA-Z][a-zA-Z0-9]*;

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

CONST_BOOL: 'True' | 'False';

