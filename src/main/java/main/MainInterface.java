/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import utils.AutomatonUtils;

/**
 * Created by Riccardo De Masellis on 31/05/16.
 */
public class MainInterface {

    public static void main(String[] args) {

        //PropositionalSignature signature = null;
        /*
          If you want to change the signature! These are propositions that are ADDED to the signature of the formula!
        */
        PropositionalSignature signature = new PropositionalSignature();
        //Proposition other = new Proposition("tau");
      Proposition a = new Proposition("a");
      Proposition b = new Proposition("b");
      Proposition c = new Proposition("c");
//      signature.add(other);
//      signature.add(x);
//      signature.add(y);
//      signature.add(z);

        boolean declare = false;
        boolean minimize = true;
        boolean trim = false;
        boolean printing = true;


        //String input = "<((a&(!b)))>tt";
        //String input = "[true*](([true]ff) || (<!a>tt) || (<true*>(<b>tt)))";
        //String input = "<(((a && b)?)*)*>([(<((c*)+ (d || a))*>b)?]d)";
        //String input = "<true>tt && (<a>tt -> <true>b)";
        //String input = "([(true*) ; ((!(<b?>(tt)))?)](ff))";
        //String input = "[(true*) ; ((<(!b)?>tt)?)]ff";
        //String input = "(<(((b?);true)*) ; ((a & b)?)>tt) || ([(true*);((!b)?)]ff)";
        //String input = "(<(((b?);true)*)>(a & b) || ([true*]b))";
        //String input = "[(((((!a)?) ; (true))*) ; ((!b)?))]ff";
        //String input = "(<true> tt) & ([a] b)";
        //String input = "a & !(<true>(true))";
        //String input = "((<a>tt) && !(<true>(<true>tt)))";
        //String input = "!(<true*>!((<a>tt) -> (<true>(<b>tt))) )";
        //String input = "[( ((!a)? ; true)* ; ((!b)?))]ff";
        //String input = "< (!(a | b | c ))* ; (a | c) ; (!(a | b | c))* ; (b | c) >(true)";

        //String input = "<a*>([(tt)?]ff)";
        //String input = "<a;b;c>([true]ff)";
        //String input = "<(a || b) ; (!c)*>(tt)";

        String input = "<(eps)*>end";


//        signature = new PropositionalSignature();
//        signature.add(new Proposition("a"));
//


        LDLfAutomatonResultWrapper ldlfARW = Main.ldlfString2Aut(input, signature, declare, minimize, trim, printing);
        AutomatonUtils.printAutomaton(ldlfARW.getAutomaton(), "ldlfAutomaton.gv");
        //Main.provaExecutableAutomaton(ldlfARW.getAutomaton());


        //String input = "a R b";
        //String input = "G (a -> (F b))";
        //String input = "(F((a U (b|c)) R ((X e) || ((WX f) && (G h) ) ) )) -> ((F d) R (((g)||(i)) U (l)))";
        //String input = "(G(rl -> (F aa))) & (G(aa -> (F dl))) & (G(aa -> (X dl)))";
        //String input = "(G(rl -> (F aa))) & (G(aa -> (X dl)))";
//        String input1 = "G (a || b) || (G c)";
//        String input2 = "G (a || b || c)";
//        String total = "(" + input1 + ") <-> (" + input2 + ")";
        //String notCoexistence = "(F a) -> (!(F b))";
        //String AxorB = "((a && !b) || (b && !a)) && WX(false)";
        //String input2 = "true & (WX (a -> (WX b)))";
//        String input = "X(true)";
        //String input2 = "(F pay) -> (F acc)";



/*
        LTLfAutomatonResultWrapper ltlfARW = Main.ltlfString2Aut(input2, signature, declare, minimize, trim, printing);
        AutomatonUtils.printAutomaton(ltlfARW.getAutomaton(), "ltlfAutomaton.gv");
        //ltlfARW.getAutomaton().terminals().isEmpty();
*/



//        String ltlf = "((!a) U (!b))";
//        LTLfFormula ltlfFormula = ParserUtils.parseLTLfFormula(ltlf);
//        LDLfFormula ldLfFormula = ltlfFormula.toLDLf();
//        LDLfTempNotFormula notLDLf = new LDLfTempNotFormula(ldLfFormula);
//
//        LDLfAutomatonResultWrapper ldlfARW = Main.ldlfFormula2Aut(notLDLf, signature, declare, minimize, trim, noEmptyTrace, printing);
//        AutomatonUtils.printAutomaton(ldlfARW.getAutomaton(), "ldlfNotAutomaton.gv");
//        System.out.println("Input formula:");
//        System.out.println(notLDLf);
//
//        String releaseLTL = "(a R b)";
//        LTLfAutomatonResultWrapper ltlfARW = Main.ltlfString2Aut(releaseLTL, signature, declare, minimize, trim, noEmptyTrace, printing);
//        AutomatonUtils.printAutomaton(ltlfARW.getAutomaton(), "ltlfReleaseAutomaton.gv");
    }
}