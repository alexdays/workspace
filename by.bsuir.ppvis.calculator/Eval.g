tree grammar Eval;
options{
	tokenVocab = Expr;
	ASTLabelType = CommonTree;
}
@header{
	package by.bsuir.ppvis.calculator.parse;
	import by.bsuir.ppvis.calculator.view.CalcFrame;
	import java.lang.Math;
}
@members{
	private CalcFrame calcFrame;
}

stat	:	
	expr {System.out.println($expr.value);}
	;
exp returns[double value]
	: {$value = Math.E}
;

expr returns[double value]	:
 	  ^(PLUS a = expr b = expr) {$value = a+b;}
 	| ^(MINUS a = expr b = expr) {$value = a-b;}
 	| ^(MULT a = expr b = expr) {$value = a*b;}
 	| ^(DIV a = expr b = expr) {$value = a/b;}
 	| ^(PROCENT a = expr b = expr) {$value = a/b;}
 	| ^(UNARY a = expr) {$value = (-1)*a;}
 	| ^(POW a = expr b = expr) {$value = (int)Math.pow(a, b);}
 	| FLOAT {$value = Double.parseDouble($FLOAT.text);}
 	| INT {$value = Double.parseDouble($INT.text);}
 		
 	;
