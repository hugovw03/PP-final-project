grammar Natural;

// Lexer rules
INT: 'Int';
BOOL: 'Bool';
ID: [a-zA-Z][a-zA-Z0-9]*;
ASSIGN: '=';
CONST_INT: [0-9]+;
CONST_BOOL: 'True' | 'False';
SEMICOLON: ';';

// Parser rules
data_type_definition: DATA_TYPE identifier ASSIGN constant_value SEMICOLON;

DATA_TYPE: INT | BOOL;

constant_value: CONST_INT | CONST_BOOL;

identifier: ID;

// Other parser rules...
