lexer grammar SmallConcurrencySyntax;

LPAR: '(';

RPAR: ')';

LBRACE: '{';

RBRACE: '}';

COMMA: ',';

SEMICOLON: ';';

ASSIGN : '=' ;

TRUE: 'True';

FALSE: 'False';

PLUS: '+';

MINUS: '-';

MULTIPLY: '*';

SLASH: '/';

EQUAL: '==';

GREATER: '>';

GREATER_EQUAL: '>=';

LESS: '<';

LESS_EQUAL: '<=';

DIFFERENT: '!=';

AND: 'and';

OR: 'or';

IF : 'if' ;

ELSE : 'else' ;

WHILE : 'while' ;

RETURN : 'return' ;

FUNCTION : 'function' ;

VAR : 'var' ;

GLOBAL_VAR : 'gVar' ;

THREAD : 'thread' ;

LOCK : 'lock' ;

UNLOCK : 'unlock' ;

ID: LETTER (DIGIT | LETTER)*;

NUM : DIGIT+;

fragment DIGIT: '0'..'9';

fragment LETTER: 'A'..'Z' | 'a'..'z' ;

NEWLINE: '\r'?'\n'  -> skip ;

WS: [ \t]+ -> skip ;