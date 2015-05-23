grammar LDLfFormulaParser;

import PropFormulaParser;

/*@parser::members{
	
}*/

start
    :   expression EOF
    ;

expression
	:   doubleImplicationTemp
    ;

doubleImplicationTemp
    :   implicationTemp (DOUBLEIMPLY implicationTemp)*
    ;

implicationTemp
	:   orTemp (IMPLY orTemp)*
    ;

orTemp
    :   andTemp (OR andTemp)*
    ;

andTemp
    :   ldlfBox (AND ldlfBox)*
    ;

ldlfBox
	:   (BOXLSEPARATOR regularExpression BOXRSEPARATOR)? ldlfDiamond
    ;

ldlfDiamond
    :   (DIAMONDLSEPARATOR regularExpression DIAMONDRSEPARATOR)? notTemp
    ;  

notTemp
	:   ldlfAtom
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
    	:	alternation
    	;

    alternation
    	: 	concatenation (ALTERNATION concatenation)*
    	;

    concatenation
        :	star (CONCATENATION star)*
    	;

    star
    	: 	test STAR?
    	|	LSEPARATOR regularExpression RSEPARATOR STAR?
    	;

    test
    	: 	LSEPARATOR expression RSEPARATOR TEST
    	|	atom TEST
    	| 	propositionalFormula
    	|	EPSILON
    	;


	LAST : ('Last')|('LAST')|('last');
    EPSILON : ('eps');
    TT : ('tt');
    FF : ('ff');
    END : ('end')|('END')|('End');

    BOXLSEPARATOR : ('[');
    BOXRSEPARATOR : (']');
    DIAMONDLSEPARATOR : ('<');
    DIAMONDRSEPARATOR : ('>');

    STAR : ('*');
    TEST : ('?');
    ALTERNATION : ('+');
    CONCATENATION : (';');