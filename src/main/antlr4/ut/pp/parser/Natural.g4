grammar Natural;

import NaturalVocab;


// Helper rules
identifier: ID;
condition: DATA_TYPE EQUALS DATA_TYPE;
constant_value: CONST_INT | CONST_BOOL;
SCOPE_LEVEL: GLOBAL | LOCAL;
//TODO: maybe need syntax check for locks
DATA_TYPE: INT | BOOL | LOCK;


// Int a = 5;
data_type_definition: DATA_TYPE identifier (ASSIGN constant_value SEMICOLON)?;

//Global Int a = 5;
scope_type_definition: SCOPE_LEVEL data_type_definition;


if_statement:  IF condition BRAC expr* BRAC;

while_statement: WHILE condition BRAC expr* BRAC;

print_statement: PRINT PARENS ;

//TODO:
parallel_statement: RUNPAR PARENS INT CONST_INT PARENS;

//TODO:
assignment_statement: identifier ASSIGN constant_value;




expr:     data_type_definition
        | scope_type_definition
        | assignment_statement
        | if_statement
        | while_statement
        | print_statement
        | parallel_statement;