grammar fromStringToCharParser;

@header{
	package fromStringToCharParser;
}

options {
    //language = java;
}

start
    :   expression EOF
    ;

expression
    :   string (LSEPARATOR string RSEPARATOR string)*
    |   string
    ;

string
    :   EVERYTHING
    ;

EVERYTHING 	: ~('{'|'}')+;
LSEPARATOR	:('{');
RSEPARATOR	: ('}');

//We will ignore all the white spaces
WS : (' ' | '\t' | '\r' | '\n')+ -> skip;