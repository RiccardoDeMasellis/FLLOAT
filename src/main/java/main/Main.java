/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import RuntimeVerification.ExecutableAutomaton;
import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.transformations.Pruner;
import rationals.transformations.Reducer;
import utils.AutomatonUtils;
import utils.ParserUtils;

/**
 * Created by Riccardo De Masellis on 22/07/15.
 */
public class Main {


    public static LDLfAutomatonResultWrapper ldlfString2Aut(String input, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {

        /*
        Parsing
         */
        LDLfFormula formula = ParserUtils.parseLDLfFormula(input);

        return ldlfFormula2Aut(formula, signature, declare, minimize, trim, noEmptyTrace, printing);
    }

    public static LDLfAutomatonResultWrapper ldlfFormula2Aut(LDLfFormula formula, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {

        Automaton automaton;

        PropositionalSignature newSig = formula.getSignature();

        /*
        Check signature parameter
         */
        if (signature!=null)
            newSig.addAll(signature);

        /*
        Actual automaton construction
         */
        if(declare)
            automaton = AutomatonUtils.ldlf2AutomatonDeclare(formula, newSig);
        else
            automaton = AutomatonUtils.ldlf2Automaton(formula, newSig);

        // TRANSFORMATION
        automaton = transformations(automaton, minimize, trim, noEmptyTrace);


        if(printing)
            System.out.println(automaton);

        return new LDLfAutomatonResultWrapper(automaton, newSig, formula);
    }


    public static LTLfAutomatonResultWrapper ltlfString2Aut(String input, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {
        /*
        Parsing
         */
        LTLfFormula formula = ParserUtils.parseLTLfFormula(input);

        /*
        Translation to ldlf! Transform in ANTINNF before the actual translation!
         */
        LDLfFormula ldlff = formula.toLDLf();
        System.out.println("To LDLF: " + ldlff);

        return ltlfFormula2Aut(formula, signature, declare, minimize, trim, noEmptyTrace, printing);
    }

    public static LTLfAutomatonResultWrapper ltlfFormula2Aut(LTLfFormula formula, PropositionalSignature signature, boolean declare, boolean minimize, boolean trim, boolean noEmptyTrace, boolean printing) {

        LDLfFormula ldlff = formula.toLDLf();
        System.out.println("To LDLF: " + ldlff);

        Automaton automaton;

        PropositionalSignature newSig = formula.getSignature();

        /*
        Check signature parameter
         */
        if (signature!=null)
            newSig.addAll(signature);

        /*
        Actual automaton construction
         */
        if (declare)
            automaton = AutomatonUtils.ldlf2AutomatonDeclare(ldlff, newSig);
        else
            automaton = AutomatonUtils.ldlf2Automaton(ldlff, newSig);

        // TRANSFORMATION
        automaton = transformations(automaton, minimize, trim, noEmptyTrace);


        if (printing)
            System.out.println(automaton);

        return new LTLfAutomatonResultWrapper(automaton, newSig, ldlff, formula);
    }



    private static Automaton transformations(Automaton automaton, boolean minimize, boolean trim, boolean noEmptyTrace) {

        // WARNING! This must be called BEFORE the minimization!
        if(noEmptyTrace)
            automaton = AutomatonUtils.eliminateEmptyTrace(automaton);

        if (minimize)
            automaton = new Reducer<>().transform(automaton);

        if(trim)
            automaton = new Pruner<>().transform(automaton);

        //Always eliminate unreachable states from the initial one.
        automaton = AutomatonUtils.removeUnreachableStates(automaton);

        return automaton;
    }


    public static void provaExecutableAutomaton(Automaton a) {
        ExecutableAutomaton ea = new ExecutableAutomaton(a);
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
        System.out.println("outgoing good transition: ");
        System.out.println(ea.notFailingOutgoingTransitions(ea.getCurrentState()));
        //System.out.println(ea.declareNotFailingEvents());
        System.out.println("Performing transition a");
        ea.step("a");
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
        System.out.println("outgoing good transition: ");
        System.out.println(ea.notFailingOutgoingTransitions(ea.getCurrentState()));
        //System.out.println(ea.declareNotFailingEvents());

        System.out.println("Performing transition EmptyTrace");
        ea.step("EmptyTrace");
        System.out.println("Current state: " + ea.getCurrentState());
        System.out.println("Current state value: " + ea.currentRVTruthValue());
//
//        System.out.println("Performing transition c");
//        ea.step("c");
//        System.out.println(ea.getCurrentState());
//        System.out.println(ea.currentRVTruthValue());
//
//        System.out.println("Performing transition c");
//        ea.step("c");
//        System.out.println(ea.getCurrentState());
//        System.out.println(ea.currentRVTruthValue());
    }
}
