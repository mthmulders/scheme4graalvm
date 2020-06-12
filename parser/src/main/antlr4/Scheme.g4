grammar Scheme;

@parser::header {
// GENERATED CODE - DO NOT MODIFY
}

@lexer::header {
// GENERATED CODE - DO NOT MODIFY
}

/**
 * Greedy consumers (consuming as much input as possible):
 * + one or more times
 * * zero or more times
 * ? zero or one times
 *
 * Non-greedy consumers (consuming as little as possible, and certainly not what follows immediately after it):
 * *? zero or more times - but as little as possible
 */

/**
 * Lexer rules
 */
BRACKET_OPEN: '(';
BRACKET_CLOSE: ')';
QUOTE: '"';
WHITESPACE: ( ' ' | '\t' | '\r' | '\n' | '\u000C' );
fragment DIGIT: [0-9];
INTEGER_NUMBER: DIGIT+;
REAL_NUMBER: DIGIT+ '.' DIGIT+;
NUMBER: INTEGER_NUMBER | REAL_NUMBER;
DEFINE: 'define';
NAME: ([A-Za-z])+;

SYMBOL:
    '*' | '/' | '+' | '-' |
    '<' | '>' |
    '<=' | '>=' |
    '=' | '!='
; // Probably some more?

COMMENT: ';' .*? ( '\n' | '\r\n' ) -> skip;

/**
 * Parser rules
 */
argument: symbol | name | number | combination | compoundProcedure;

arguments: (WHITESPACE argument)+;

compoundProcedure:
    BRACKET_OPEN
        DEFINE
        WHITESPACE+
        BRACKET_OPEN name arguments? BRACKET_CLOSE
        WHITESPACE
        (primitiveExpression | combination)*
    BRACKET_CLOSE
;
name: NAME;
number: INTEGER_NUMBER | REAL_NUMBER;
symbol: SYMBOL;
operand: SYMBOL | NAME;

combination: BRACKET_OPEN operand arguments BRACKET_CLOSE;
primitiveExpression: number;

//expressions: (compoundProcedure | primitiveExpression | combination)*;

program: (compoundProcedure | primitiveExpression | combination)* EOF;
