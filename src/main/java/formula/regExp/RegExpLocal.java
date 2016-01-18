/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.EmptyTrace;
import automaton.PossibleWorldWrap;
import automaton.TransitionLabel;
import evaluations.PropositionLast;
import formula.LocalFormula;
import formula.LocalFormulaType;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFalseFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedTrueFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.*;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;
import rationals.transformations.Concatenation;
import rationals.transformations.Reducer;
import rationals.transformations.Union;
import utils.AutomatonUtils;

import java.util.Set;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpLocal extends RegExp, LocalFormula {

    static RegExpLocal localFormulaFactory(LocalFormulaType formulaType, RegExpLocal left, RegExpLocal right, Proposition prop) {
        switch (formulaType) {
            case PROP_AND:
                return new RegExpLocalAnd(left, right);
            case PROP_DOUBLEIMPL:
                return new RegExpLocalDoubleImpl(left, right);
            case PROP_IMPL:
                return new RegExpLocalImpl(left, right);
            case PROP_NOT:
                return new RegExpLocalNot(left);
            case PROP_OR:
                return new RegExpLocalOr(left, right);
            case PROP_VAR:
                return new RegExpLocalVar(prop);
            case PROP_TRUE:
                return new RegExpLocalTrue();
            case PROP_FALSE:
                return new RegExpLocalFalse();
            default:
                throw new RuntimeException("Enum " + formulaType + " in RegExpLocal.propFormulaFactory not found.");
        }
    }

    PropositionalFormula regExpLocal2Propositional();


    default QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label) {
        if (label instanceof EmptyTrace)
            return new QuotedFalseFormula();

        if (label instanceof PossibleWorldWrap) {
            PossibleWorldWrap pwwLabel = (PossibleWorldWrap)label;
            PropositionLast last = new PropositionLast();
            PropositionalFormula pf = this.regExpLocal2Propositional();

            if (pwwLabel.satisfies(pf)) {
                if (pwwLabel.contains(last)) {
                    QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
                    return quoted.delta(new EmptyTrace());
                } else
                    return new QuotedVar((LDLfFormula) goal.clone());
            } else { // !world.satisfies(pf)
                return new QuotedFalseFormula();
            }
        }
        else
            throw new RuntimeException("The label is neither EmptyTrace nor PossibleWorldWrap");
    }


    default QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        if (label instanceof EmptyTrace)
            return new QuotedTrueFormula();

        if (label instanceof PossibleWorldWrap) {
            PossibleWorldWrap pwwLabel = (PossibleWorldWrap)label;
            PropositionLast last = new PropositionLast();
            PropositionalFormula pf = this.regExpLocal2Propositional();

            if (pwwLabel.satisfies(pf)) {
                if (pwwLabel.contains(last)) {
                    QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
                    return quoted.delta(new EmptyTrace());
                } else
                    return new QuotedVar((LDLfFormula) goal.clone());
            } else { // !world.satisfies(pf)
                return new QuotedTrueFormula();
            }
        }
        else
            throw new RuntimeException("The label is neither EmptyTrace nor PossibleWorldWrap");
    }

    /*
    This is a base case. Uses concatenation and union!
     */
    default Automaton buildAutomatonDiamond(LDLfFormula goal, PropositionalSignature ps) {

        PropositionalFormula regExpProp = this.regExpLocal2Propositional();

        /*
        First case
         */
        Automaton firstCase = new Automaton();
        State initial = firstCase.addState(true, false);

        // First case: not last and \Pi \models \phi
        Proposition last = new PropositionLast();
        Negation notLast = new Negation(last);
        Conjunction conj = new Conjunction(notLast, regExpProp);
        Set<PossibleWorld> models = conj.getModels(ps);

        Set<TransitionLabel> labels = AutomatonUtils.possWorldToTransLabel(models);

        /*
        Is this really final?!? I guess so, for the properties of the concatenation of two automata.
         */
        State ending = firstCase.addState(false, true);

        for(TransitionLabel l : labels) {
            Transition<TransitionLabel> trans = new Transition<>(initial, l, ending);
            try {
                firstCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }
        // Creation of the automaton with "\varphi"
        Automaton varphi = goal.buildAutomaton(ps);
        // CONCATENATION!
        Automaton result1 = new Concatenation<>().transform(firstCase, varphi);
        result1 = new Reducer<>().transform(result1);


        /*
        Second case
         */
        Automaton secondCase = new Automaton();
        State initial2 = secondCase.addState(true, false);
        Conjunction conj2 = new Conjunction(last, regExpProp);
        Set<PossibleWorld> models2 = conj2.getModels(ps);
        Set<TransitionLabel> labels2 = AutomatonUtils.possWorldToTransLabel(models2);

        /*
        Is this realy final? Same story...
         */
        State ending2 = secondCase.addState(false, true);
        for(TransitionLabel l : labels2) {
            Transition<TransitionLabel> trans = new Transition<>(initial2, l, ending2);
            try {
                secondCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        Automaton varphiEmpty = goal.buildAutomatonForEmptyTrace(ps);
        Automaton result2 = new Concatenation<>().transform(secondCase, varphiEmpty);
        result2 = new Reducer<>().transform(result2);


        /*
        Third case
         */
        Automaton thirdCase = new Automaton();
        State initial3 = thirdCase.addState(true, false);
        State ending3 = thirdCase.addState(false, false);

        Negation notPhi = new Negation(regExpProp);
        Set<PossibleWorld> models3 = notPhi.getModels(ps);
        Set<TransitionLabel> labels3 = AutomatonUtils.possWorldToTransLabel(models3);

        for(TransitionLabel l : labels3) {
            Transition<TransitionLabel> trans = new Transition<>(initial3, l, ending3);
            try {
                thirdCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }


        /*
        Building the result
         */
        Automaton result = new Union<>().transform(result1, result2);
        result = new Union<>().transform(result, thirdCase);
        result = new Reducer<>().transform(result);

        return result;
    }


    /*
    Returns the false automaton
     */
    default Automaton buildAutomatonForEmptyTraceDiamond(LDLfFormula goal, PropositionalSignature ps) {
        return AutomatonUtils.buildFalseAutomaton(ps);
    }


    /*
    Analogous to the diamond case.
     */
    default Automaton buildAutomatonBox(LDLfFormula goal, PropositionalSignature ps) {
        PropositionalFormula regExpProp = this.regExpLocal2Propositional();

        /*
        First case
         */
        Automaton firstCase = new Automaton();
        State initial = firstCase.addState(true, false);

        // First case: not last and \Pi \models \phi
        Proposition last = new PropositionLast();
        Negation notLast = new Negation(last);
        Conjunction conj = new Conjunction(notLast, regExpProp);
        Set<PossibleWorld> models = conj.getModels(ps);

        Set<TransitionLabel> labels = AutomatonUtils.possWorldToTransLabel(models);

                /*
        Is this really final?!? I guess so, for the properties of the concatenation of two automata.
         */
        State ending = firstCase.addState(false, true);

        for(TransitionLabel l : labels) {
            Transition<TransitionLabel> trans = new Transition<>(initial, l, ending);
            try {
                firstCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }
        // Creation of the automaton with "\varphi"
        Automaton varphi = goal.buildAutomaton(ps);
        // CONCATENATION!
        Automaton result1 = new Concatenation<>().transform(firstCase, varphi);
        result1 = new Reducer<>().transform(result1);


        /*
        Second case
         */
        Automaton secondCase = new Automaton();
        State initial2 = secondCase.addState(true, false);
        Conjunction conj2 = new Conjunction(last, regExpProp);
        Set<PossibleWorld> models2 = conj2.getModels(ps);
        Set<TransitionLabel> labels2 = AutomatonUtils.possWorldToTransLabel(models2);

        /*
        Is this realy final? Same story...
         */
        State ending2 = secondCase.addState(false, true);
        for(TransitionLabel l : labels2) {
            Transition<TransitionLabel> trans = new Transition<>(initial2, l, ending2);
            try {
                secondCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        Automaton varphiEmpty = goal.buildAutomatonForEmptyTrace(ps);
        Automaton result2 = new Concatenation<>().transform(secondCase, varphiEmpty);
        result2 = new Reducer<>().transform(result2);


        /*
        Third case
         */
        Automaton thirdCase = new Automaton();
        State initial3 = thirdCase.addState(true, false);
        // This is really final! It is "true"!
        State ending3 = thirdCase.addState(false, true);

        Negation notPhi = new Negation(regExpProp);
        Set<PossibleWorld> models3 = notPhi.getModels(ps);
        Set<TransitionLabel> labels3 = AutomatonUtils.possWorldToTransLabel(models3);

        for(TransitionLabel l : labels3) {
            Transition<TransitionLabel> trans = new Transition<>(initial3, l, ending3);
            try {
                thirdCase.addTransition(trans);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        /*
        Building the result
         */
        Automaton result = new Union<>().transform(result1, result2);
        result = new Union<>().transform(result, thirdCase);
        result = new Reducer<>().transform(result);

        return result;
    }


    /*
    Returns the true automaton
    */
    default Automaton buildAutomatonForEmptyTraceBox(LDLfFormula goal, PropositionalSignature ps) {
        return AutomatonUtils.buildTrueAutomaton(ps);
    }

}
