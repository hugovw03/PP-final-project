grammar NaturalParser;

import NaturalLexer;


// Helper rules
identifier: ID;
constant_value: CONST_INT | CONST_BOOL;
scope_level: GLOBAL | LOCAL;
//TODO: maybe need syntax check for locks
data_type: INT | BOOL | LOCK;
somethinghereeeeeee : CONST_INT* | ID*;

//if
//TODO: the conditionPara should accept a multexpr ..
conditionPara:  identifier | constant_value | op_expr;
condition: LPAR conditionPara EQUALS conditionPara RPAR;
if_statement:  IF condition LBRAC expr* RBRAC;


//Int a = 5;
//Int b;
data_type_definition: data_type identifier (ASSIGN op_expr )? SEMICOLON;

//Global Int a = 5;
scope_type_definition: scope_level data_type_definition SEMICOLON;

//Op
opPara : CONST_INT | identifier;

op_expr : op_expr TIMES op_expr
        | op_expr PLUS op_expr
        | op_expr MINUS op_expr
        | opPara;

assignment_statement: identifier ASSIGN op_expr SEMICOLON;

//statments

while_statement: WHILE condition LBRAC expr* RBRAC;

print_statement: PRINT LPAR somethinghereeeeeee RPAR SEMICOLON;

parallel_statement: RUNPAR LPAR  INT CONST_INT RPAR LBRAC expr* RBRAC;





expr:     data_type_definition
        | scope_type_definition
        | assignment_statement
        | if_statement
        | while_statement
        | print_statement
        | op_expr
        | parallel_statement
        | CHAR;
