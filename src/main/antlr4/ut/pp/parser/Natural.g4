grammar Natural;

// Lexer rules
INT: 'Int';
BOOL: 'Bool';
ID: [a-zA-Z][a-zA-Z0-9]*;
ASSIGN: '=';
CONST_INT: [0-9]+;
CONST_BOOL: 'True' | 'False';
SEMICOLON: ';';
BRAC: '{' | '}';
PARENS: '(' | ')';
// Parser rules
data_type_definition: DATA_TYPE identifier ASSIGN constant_value SEMICOLON;

DATA_TYPE: INT | BOOL;

condition: DATA_TYPE EQUALS DATA_TYPE;

constant_value: CONST_INT | CONST_BOOL;

if_statement:  IF condition BRAC expr* BRAC;

while_statement: WHILE condition BRAC expr* BRAC;

print_statement: PRINT PARENS ;

identifier: ID;

equality_checker:




// Other parser rules...



expr: data_type_definition
        | assignment_statement
        | if_statement
        | while_statement
        | print_statement
        | parallel_statement;