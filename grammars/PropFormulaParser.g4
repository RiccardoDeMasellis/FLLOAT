grammar PropFormulaParser;

@header{
	package generatedParsers;
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
	:   ID+
	|	TRUE
	|	FALSE
    ;


    ALPHA : ('a'..'z');
    DIGIT : ('0'..'9');
    ID : (ALPHA | DIGIT);
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