// antlr4 -package parser -o antlr-generated  -no-listener parser/PiLang.g4
grammar PiLang;

prog: varDecls funcDecl*
	;

funcDecl: 'function' IDENTIFIER '(' params ')' '{' varDecls stmt* '}'
    ;

params:   /* no parameter */
    | IDENTIFIER (',' IDENTIFIER)*
    ;

varDecls: ('var' IDENTIFIER ';')*
    ;

stmt: '{' stmt* '}'							# compoundStmt
	| IDENTIFIER '=' expr ';'				# assignStmt
	| 'if' '(' expr ')' stmt 'else' stmt	# ifStmt
	| 'while' '(' expr ')' stmtd			# whileStmt
	| 'return' expr ';'						# returnStmt
	| 'print' expr ';'						# printStmt
	;
	
stmtd: BREAK ';'								# breakStmtd
	| '{' stmtd* '}'							# compoundStmtd
	| 'if' '(' expr ')' stmtd 'else' stmtd	# ifStmtd
	| stmt										# removeStmtd
	;

expr: logicOrExpr
      ;
      
logicOrExpr: logicOrExpr LOGICOROP logicAndExpr
	| logicAndExpr
	;
	
logicAndExpr: logicAndExpr LOGICANDOP orExpr
	| orExpr
	;
      
orExpr: orExpr OROP andExpr
    | andExpr
    ;

andExpr: andExpr ANDOP equalExpr
   | equalExpr
    ;
      
equalExpr: equalExpr EQUALOP cmpExpr
	| cmpExpr
	;

cmpExpr: cmpExpr CMPOP addExpr
	| addExpr
	;

addExpr: addExpr ADDOP mulExpr
	| addExpr SUBOP mulExpr
	| mulExpr
	;

mulExpr: mulExpr MULOP logicNotExpr
	| logicNotExpr
	;
	
logicNotExpr: LOGICNOTOP logicNotExpr
	| unaryExpr
	;

unaryExpr: VALUE			# literalExpr
	| IDENTIFIER			# varExpr
	| '(' expr ')'		# parenExpr
	| SUBOP expr			# subExpr
	| NOTOP expr			# notExpr
	| IDENTIFIER '(' args ')' # callExpr
	;

args: /* no arguments */
	| expr ( ',' expr )*
	;

NOTOP: '~';
ADDOP: '+';
SUBOP: '-';
MULOP: '*'|'/';
ANDOP: '&';
OROP: '|';
CMPOP: [>|<]'='?;
EQUALOP: [!|=]'=';
LOGICANDOP: '&&';
LOGICOROP: '||';
LOGICNOTOP:	'!';

BREAK: 'break';
IDENTIFIER: 'x'|'y'|'z'|'main'|[a-zA-Z_][a-zA-Z_0-9]+;
VALUE: '0'|[1-9][0-9]*;
WS: [ \t\r\n] -> skip;
