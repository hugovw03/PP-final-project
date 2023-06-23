grammar NaturalParser;

import NaturalLexer;


// Helper rules
identifier: ID;
condition: data_type EQUALS data_type;
constant_value: CONST_INT | CONST_BOOL;
scope_level: GLOBAL | LOCAL;
//TODO: maybe need syntax check for locks
data_type: INT | BOOL | LOCK;
somethinghereeeeeee : constant_value*;

// Int a = 5;
data_type_definition: data_type identifier (ASSIGN constant_value SEMICOLON)?;

//Global Int a = 5;
scope_type_definition: scope_level data_type_definition;


if_statement:  IF condition BRAC expr* BRAC;

while_statement: WHILE condition BRAC expr* BRAC;

print_statement: PRINT PARENS somethinghereeeeeee PARENS;

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