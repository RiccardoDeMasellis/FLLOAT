grammar PropFormulaParser;

@header{
	package antlr4_generated;
}

propositionalFormula
	: 	doubleImplicationProp
	;

doubleImplicationProp
    :   implicationProp (DOUBLEIMPLY implicationProp)*
    ;

implicationProp
    :   orProp (IMPLY orProp)*
    ;

orProp
    :   andProp (OR andProp)*
    ;

andProp
    :   notProp (AND notProp)*
    ;

notProp
    :   NOT? atom
    |   NOT? LSEPARATOR propositionalFormula RSEPARATOR
    ;

atom
	:   ID*
	|	TRUE
	|	FALSE
    ;


    ID : ('a'..'z');
    TRUE : ('True')|('TRUE')|('true');
    FALSE : ('False')|('FALSE')|('false');

    DOUBLEIMPLY : ('<->');
    IMPLY : ('->');
    OR  : ('||'|'|');
    AND : ('&&'|'&');

    NOT : ('!');

    LSEPARATOR : ('(');
    RSEPARATOR : (')');

    WS : (' ' | '\t' | '\r' | '\n')+ -> skip;