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

ID: LETTER (DIGIT | LETTER)*;

NUM : DIGIT+;


fragment LETTER : 'a'..'z' | 'A'..'Z';
fragment DIGIT : '0'..'9';