grammar SmallConcurrencyGrammar ;
import SmallConcurrencySyntax ;


root : (globalVarDecl SEMICOLON)* (funcDef)+ EOF ;

op : PLUS | MINUS | MULTIPLY | SLASH ;
bop :  EQUAL | GREATER | GREATER_EQUAL | LESS | LESS_EQUAL | DIFFERENT;
rop : AND | OR;

nOprnd : ID | NUM ;
bOprnd : TRUE | FALSE | ID | nOprnd bop nOprnd ;

binOP : nOprnd op nOprnd ;

relOp : bOprnd rop bOprnd ;

arithmExp : binOP | nOprnd   ;

boolExp :  relOp | bOprnd ;

expr : arithmExp | boolExp ;

returnStatement : RETURN arithmExp ;

exprList : arithmExp | arithmExp COMMA exprList ;

funcCall : ID  LPAR exprList? RPAR ;

assignStatement : ID ASSIGN arithmExp | ID ASSIGN funcCall ;

statement : (assignStatement |returnStatement| varDecl |  lockVarDecl | unlockVarDecl) SEMICOLON  | ifStatement | whileStatement | threadDecl  ;

ifStatement : IF LPAR boolExp RPAR (statement | sequence) ELSE (statement | sequence) ;

whileStatement : WHILE LPAR boolExp RPAR (statement | sequence) ;

sequence :  LBRACE statement* RBRACE ;

paramList : ID | ID COMMA paramList ;

funcDef : FUNCTION ID LPAR (paramList?) RPAR sequence ;

varDecl : VAR ID;

globalVarDecl : GLOBAL_VAR ID;

threadDecl: THREAD sequence;

lockVarDecl: LOCK ID;

unlockVarDecl: UNLOCK ID;



