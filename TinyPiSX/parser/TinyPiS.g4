// antlr4 -package parser -o antlr-generated  -no-listener parser/TinyPiE.g4
grammar TinyPiS;

prog: varDecls stmt
	;
	
varDecls: ('var' IDENTIFIER ';' )*
	;
	
stmt: '{' stmt* '}'							# compoundStmt
	| IDENTIFIER '=' expr ';'				# assignStmt
	| 'if' '(' expr ')' stmt 'else' stmt	# ifStmt
	| 'while' '(' expr ')' stmt				# whileStmt
	| 'print' expr ';'						# printStmt
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
	| SUBOP unaryExpr			# subExpr
	| NOTOP unaryExpr			# notExpr
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

IDENTIFIER: 'x'|'y'|'z'|'answer'|[a-zA-Z_][a-zA-Z_0-9]+;
VALUE: '0'|[1-9][0-9]*;
WS: [ \t\r\n] -> skip;
