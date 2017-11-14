// antlr4 -package parser -o antlr-generated  -no-listener parser/TinyPiE.g4
grammar TinyPiE;

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

IDENTIFIER: 'x'|'y'|'z';
VALUE: '0'|[1-9][0-9]*;
WS: [ \t\r\n] -> skip;
