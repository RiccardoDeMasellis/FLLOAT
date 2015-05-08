grammar LDLfFormulaParser;

@header{
	package ldlfParser;
}

options {
    //language = java;
}

@parser::members{
	
}

start
    :   expression EOF
    ;

expression
	:   checkdoubleImplication
    ;

checkdoubleImplication
    :   checkImplication (DOUBLEIMPLY checkImplication)*	
    ;

checkImplication
	:   checkOr (IMPLY checkOr)*	
    ;

checkOr
    :   checkAnd (OR checkAnd)*	
    ;

checkAnd
    :   checkBox (AND checkBox)*
    ;

checkBox
	:   (BOXLSEPARATOR regularExpression BOXRSEPARATOR)? checkDiamond		
    ;

checkDiamond
    :   (DIAMONDLSEPARATOR regularExpression DIAMONDRSEPARATOR)? checkNot		
    ;  

checkNot
	:   NOT? ldlfAtom
    |   NOT? LSEPARATOR expression RSEPARATOR 
    ;

ldlfAtom
    :   TT
    |	FF
    |	LAST
    |	END
    |	propositionalFormula
    ;
    
regularExpression
	:	checkOrRegExp
	;

checkOrRegExp
	: 	checkConcatenationRegExp (REGEXPOR checkConcatenationRegExp)*
	;
	
checkConcatenationRegExp
    :	checkStar (CONCATENATION checkStar)*   
	; 

checkStar
	: 	checkTest STAR?
	|	LSEPARATOR regularExpression RSEPARATOR STAR?
	;

checkTest
	: 	LSEPARATOR expression RSEPARATOR TEST
	|	ldlfAtom TEST
	| 	propositionalFormula
	|	EPSILON
	;
	
propositionalFormula
	: 	checkdoubleImplicationProp
	;
	
checkdoubleImplicationProp
    :   checkImplicationProp (DOUBLEIMPLY checkImplicationProp)*	
    ;

checkImplicationProp
    :   checkOrProp (IMPLY checkOrProp)*	
    ;

checkOrProp
    :   checkAndProp (OR checkAndProp)*	
    ;

checkAndProp
    :   checkNotProp (AND checkNotProp)*
    ; 

checkNotProp
    :   NOT? atom
    |   NOT? LSEPARATOR propositionalFormula RSEPARATOR 
    ;	
    
atom
	:   ID*
	|	TRUE
	|	FALSE
    ;

//ID is a lower case literal from 'a' to 'z'
//ID : ('a'..'z')|('O');
ID : ('a'..'z');
TRUE : ('True')|('TRUE')|('true')|('T');
FALSE : ('False')|('FALSE')|('false');
LAST : ('Last')|('LAST')|('last');
EPSILON : ('eps');
TT : ('tt');
FF : ('ff');
END : ('end')|('END')|('End');

//The definition of all the operators
DOUBLEIMPLY : ('<->');
IMPLY : ('->');
OR  : ('||'|'|');
AND : ('&&'|'&');
NOT : ('!');
LSEPARATOR : ('(');
RSEPARATOR : (')');
BOXLSEPARATOR : ('[');
BOXRSEPARATOR : (']');
DIAMONDLSEPARATOR : ('<');
DIAMONDRSEPARATOR : ('>');
STAR : ('*');
TEST : ('?');
REGEXPOR : ('+');
CONCATENATION : (';');


//We will ignore all the white spaces
WS : (' ' | '\t' | '\r' | '\n')+ -> skip;