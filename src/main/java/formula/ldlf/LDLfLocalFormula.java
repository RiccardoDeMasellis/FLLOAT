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
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;

import java.util.HashSet;
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

    /*
    As a first step, we DO NOT add all the transitions but only the ones which bring to the true state.
    Therefore, I am building a sort of already TRIMMED automaton.
     */
    default Automaton buildAutomaton(PropositionalSignature ps) {
        // First create a new automaton with the default state factory
        Automaton result = new Automaton(null);

        // Add the current state
        State currState = result.addState(true, false);

        // Add the final state
        State finalState = result.addState(false, true);

        //Find the transitions
        PropositionalFormula pf = this.LDLfLocal2Prop();
        Set<PossibleWorld> models = pf.getModels(ps);

        //Convert PossibleWorld in PossibleWorldWrap
        Set<PossibleWorldWrap> pwwModels = new HashSet<>();
        for (PossibleWorld pw : models) {
            pwwModels.add(new PossibleWorldWrap(pw));
        }

        for (PossibleWorldWrap pww : pwwModels) {
            Transition<TransitionLabel> t = new Transition<>(currState, pww, finalState);
            try {
                result.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }
    return result;
    }



    default Automaton buildAutomatonForEmptyTrace(PropositionalSignature ps) {
        // First create a new automaton with the default state factory
        Automaton result = new Automaton(null);

        // Add the current state
        State currState = result.addState(true, false);

        return result;
    }
}
