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
	;

expr: andExpr
      ;
      
andExpr: andExpr ANDOP orExpr
   | orExpr
    ;

orExpr: orExpr OROP addExpr
    | addExpr
    ;

addExpr: addExpr ADDOP mulExpr
	| addExpr SUBOP mulExpr
	| mulExpr
	;

mulExpr: mulExpr MULOP unaryExpr
	| unaryExpr
	;

unaryExpr: VALUE			# literalExpr
	| IDENTIFIER			# varExpr
	| '(' expr ')'		# parenExpr
	| SUBOP expr			# subExpr
	| NOTOP expr			# notExpr
	;

NOTOP: '~';
ADDOP: '+';
SUBOP: '-';
MULOP: '*'|'/';
ANDOP: '&';
OROP: '|';

IDENTIFIER: 'x'|'y'|'z'|'answer'|[a-zA-Z_][a-zA-Z_0-9]+;
VALUE: '0'|[1-9][0-9]*;
WS: [ \t\r\n] -> skip;
