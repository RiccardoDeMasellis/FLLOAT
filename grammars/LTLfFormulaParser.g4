grammar LTLfFormulaParser;

@header{
	package ltlfParser;
}

options {
    //language = java;
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
    :   checkWeakUntil (AND checkWeakUntil)* 
    ;

checkWeakUntil
    :   checkRelease (WEAKUNTIL checkRelease)*	
    ;

checkRelease
    :   checkUntil(RELEASE checkUntil)*	
    ;
  
checkUntil
    :   checkGlobally(UNTIL checkGlobally)*	
    ;

checkGlobally
    :   GLOBALLY? checkEventually			
    ;

checkEventually
    :   EVENTUALLY? checkWeakNext		
    ;

checkWeakNext
    :   WEAKNEXT? checkNext		
    ;

checkNext
    :   NEXT? checkNot		
    ;  

checkNot
    :   NOT? atom
    |   NOT? LSEPARATOR expression RSEPARATOR 
    ;

atom
    :   ID*
    |	TRUE
    |	FALSE
    |  	LAST
    ;

//ID is a lower case literal from 'a' to 'z'
ID : ('a'..'z');
TRUE : ('True')|('TRUE')|('true');
FALSE : ('False')|('FALSE')|('false');
LAST : ('Last')|('LAST')|('last');

//The definition of all the operators
DOUBLEIMPLY : ('<->');
IMPLY : ('->');
OR  : ('||'|'|');
AND : ('&&'|'&');
WEAKUNTIL : ('WU'|'W');
UNTIL : ('U');
RELEASE : ('R');
GLOBALLY : ('[]'|'G');
EVENTUALLY : ('<>'|'F');
WEAKNEXT : ('WX');
NEXT : ('X');
NOT : ('!');
LSEPARATOR : ('(');
RSEPARATOR : (')');

//We will ignore all the white spaces
WS : (' ' | '\t' | '\r' | '\n')+ -> skip;