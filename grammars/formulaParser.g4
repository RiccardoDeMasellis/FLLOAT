grammar formulaParser;

@header{
	package formulaParser;
}

options {
    //language = java;
}

start
    :   expression EOF
    ;

expression
    :   FORMULA SEPARATOR formula (SEPARATOR formula)*
    ;

formula
    :   FORMULA
    ;

FORMULA : ~('/')+;
SEPARATOR: ('/');
FORMULATYPE: ('ltlf')|('ldlf');

//We will ignore all the white spaces
WS : (' ' | '\t' | '\r' | '\n')+ -> skip;