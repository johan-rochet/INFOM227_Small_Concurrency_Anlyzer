grammar SmallConcurrencyGrammar ;
import SmallConcurrencySyntax ;


root : (funcDef)* EOF ;


op : PLUS | MINUS | MULTIPLY | SLASH | EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | DIFFERENT;
rop : AND | OR;


nOprnd : ID | NUM ;
bOprnd : TRUE | FALSE | ID ;

binOP : nOprnd op nOprnd ;

relOp : bOprnd rop bOprnd ;

arithmExp : binOP | nOprnd   ;

boolExp :  relOp | bOprnd ;

expr : arithmExp | boolExp ;

returnStatement : RETURN expr ;

exprList : expr | expr COMMA exprList ;

funcCall : ID  LPAR (exprList+) RPAR ;

assignStatement : ID ASSIGN expr | ID ASSIGN funcCall ;

statement : (assignStatement |returnStatement) SEMICOLON  | ifStatement | whileStatement ;

ifStatement : IF LPAR expr RPAR (statement | sequence) ELSE (statement | sequence) ;

whileStatement : WHILE LPAR expr RPAR (statement | sequence) ;

sequence :  LBRACE statement* RBRACE ;

paramList : ID | ID COMMA paramList ;

funcDef : FUNCTION ID LPAR (paramList?) RPAR sequence ;







