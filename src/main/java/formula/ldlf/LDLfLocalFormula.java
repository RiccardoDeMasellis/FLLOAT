/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.EmptyTrace;
import automaton.PossibleWorldWrap;
import automaton.TransitionLabel;
import formula.LocalFormula;
import formula.LocalFormulaType;
import formula.quotedFormula.QuotedFalseFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedTrueFormula;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.*;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;
import rationals.transformations.Reducer;
import rationals.transformations.Union;
import utils.AutomatonUtils;

import java.util.Set;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LDLfLocalFormula extends LDLfFormula, LocalFormula {

    static LDLfLocalFormula localFormulaFactory(LocalFormulaType formulaType, LDLfLocalFormula left, LDLfLocalFormula right, Proposition prop) {
        switch (formulaType) {
            case PROP_AND:
                return new LDLfLocalAndFormula(left, right);
            case PROP_DOUBLEIMPL:
                return new LDLfLocalDoubleImplFormula(left, right);
            case PROP_IMPL:
                return new LDLfLocalImplFormula(left, right);
            case PROP_NOT:
                return new LDLfLocalNotFormula(left);
            case PROP_OR:
                return new LDLfLocalOrFormula(left, right);
            case PROP_VAR:
                return new LDLfLocalVar(prop);
            case PROP_TRUE:
                return new LDLfLocalTrueFormula();
            case PROP_FALSE:
                return new LDLfLocalFalseFormula();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LDLfLocalFormula.LDLfPropFormulaFactory not found.");
        }
    }

    PropositionalFormula LDLfLocal2Prop();

    default QuotedFormula delta(TransitionLabel label) {
        if (label instanceof EmptyTrace)
            return new QuotedFalseFormula();

        if (label instanceof PossibleWorldWrap) {
            PossibleWorldWrap pwwLabel = (PossibleWorldWrap)label;
            PropositionalFormula pf = this.LDLfLocal2Prop();
            if (pwwLabel.satisfies(pf))
                return new QuotedTrueFormula();
            else
                return new QuotedFalseFormula();
        }
        else
            throw new RuntimeException("The label is neither EmptyTrace nor PossibleWorldWrap");
    }


    /*
    This is a base case for the optimized algorithm.
     */
    default Automaton buildAutomaton(PropositionalSignature ps) {
        // First create a new automaton with the default state factory
        Automaton firstCase = new Automaton();
        PropositionalFormula pf = this.LDLfLocal2Prop();

        // Add the current state
        State currState = firstCase.addState(true, false);

        /*
        First case: transitions to the accpting state.
         */
        // Add the final accepting state
        State acceptingState = firstCase.addState(false, true);

        //Find the transitions leading to the acceptingState
        Set<PossibleWorld> models = pf.getModels(ps);

        Set<TransitionLabel> labels = AutomatonUtils.possWorldToTransLabel(models);

        for (TransitionLabel l : labels) {
            Transition<TransitionLabel> t = new Transition<>(currState, l, acceptingState);
            try {
                firstCase.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        // Looping in the final state with all transitions.
        Set<PossibleWorld> allModels = new Tautology().getModels(ps);
        Set<TransitionLabel> allLabels = AutomatonUtils.possWorldToTransLabel(allModels);
        for (TransitionLabel l : allLabels) {
            Transition<TransitionLabel> t = new Transition<>(acceptingState, l, acceptingState);
            try {
                firstCase.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        /*
        Second case: transition to the non-accepting state.
         */
        // Add the final accepting state
        Automaton secondCase = new Automaton();
        State currState2 = secondCase.addState(true, false);
        State nonAcceptingState = secondCase.addState(false, false);

        Negation notPf = new Negation(pf);
        Set<PossibleWorld> notModels = notPf.getModels(ps);
        Set<TransitionLabel> notLabels = AutomatonUtils.possWorldToTransLabel(notModels);
        for (TransitionLabel l : notLabels) {
            Transition<TransitionLabel> t = new Transition<>(currState2, l, nonAcceptingState);
            try {
                secondCase.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        // Looping in the nonAcceptingState with all transitions
        for (TransitionLabel l : allLabels) {
            Transition<TransitionLabel> t = new Transition<>(nonAcceptingState, l, nonAcceptingState);
            try {
                secondCase.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        // Putting all together
        Automaton result = new Union<>().transform(firstCase, secondCase);
        return new Reducer<>().transform(result);
    }



    default Automaton buildAutomatonForEmptyTrace(PropositionalSignature ps) {
        return AutomatonUtils.buildFalseAutomaton(ps);
    }
}
