grammar LTLfFormulaParser;

import PropFormulaParser;

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
    :   weakUntil (AND weakUntil)*
    ;

weakUntil
    :   release (WEAKUNTIL release)*
    ;

release
    :   until(RELEASE until)*
    ;
  
until
    :   globally(UNTIL globally)*
    ;

globally
    :   GLOBALLY? eventually
    ;

eventually
    :   EVENTUALLY? weakNext		
    ;

weakNext
    :   WEAKNEXT? next
    ;

next
    :   NEXT? notTemp
    ;  

notTemp
    :   ltlfAtom
    |   NOT? LSEPARATOR expression RSEPARATOR
    ;

ltlfAtom
    :   LAST
    |   propositionalFormula
    ;


    LAST : ('Last')|('LAST')|('last');

    WEAKUNTIL : ('WU'|'W');
    UNTIL : ('U');
    RELEASE : ('R');
    GLOBALLY : ('[]'|'G');
    EVENTUALLY : ('<>'|'F');
    WEAKNEXT : ('WX');
    NEXT : ('X');