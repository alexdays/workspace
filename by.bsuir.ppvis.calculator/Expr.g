grammar Expr;
options{
	language = Java;
	output = AST;
	ASTLabelType = CommonTree;
	
}
tokens{
	UNARY;
	PLUS = '+';
	MINUS = '-';
	MULT = '*';
	DIV = '/';
	POW = '^';
	PROCENT = '%';
}
@header{
	package by.bsuir.ppvis.calculator.parse;
	import 	by.bsuir.ppvis.calculator.parse.GeneralParse;
}
@lexer::header{
	package by.bsuir.ppvis.calculator.parse;
}
@members{
	private GeneralParse genParse;
}

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
	;
FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? (('0'..'9')+)? ;

stat	:	
	expr{System.out.println($expr.tree.toStringTree());} -> expr
	;
expr 	:
 	multExpr((PLUS^|MINUS^) multExpr)*
	;
multExpr
	: power((MULT^ | DIV^ |PROCENT^) power)*
	;
power	:
	unary(POW^ unary)*	
	;
unary	:
	  '-' atom -> ^(UNARY atom)
	| atom 
	;
atom	: INT
	| FLOAT
	| exp -> exp
	| '('! expr ')'! 
	;
exp	:
	('e' | 'E')	
	;
WS 	:	(' ' | '\t' | '\n' | '\r')+ {skip();}
	;

