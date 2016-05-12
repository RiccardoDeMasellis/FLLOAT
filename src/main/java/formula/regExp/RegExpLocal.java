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
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

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


    default QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label, Set<LDLfFormula> previousCalls) {
        if (label instanceof EmptyTrace)
            return new QuotedFalseFormula();

        if (label instanceof PossibleWorldWrap) {
            PossibleWorldWrap pwwLabel = (PossibleWorldWrap)label;
            PropositionLast last = new PropositionLast();
            PropositionalFormula pf = this.regExpLocal2Propositional();

            if (pwwLabel.satisfies(pf)) {
                if (pwwLabel.contains(last)) {
                    return ((LDLfFormula) goal.clone()).delta(new EmptyTrace(), previousCalls);
                } else
                    return new QuotedVar((LDLfFormula) goal.clone());
            } else { // !world.satisfies(pf)
                return new QuotedFalseFormula();
            }
        }
        else
            throw new RuntimeException("The label is neither EmptyTrace nor PossibleWorldWrap");
    }


    default QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label, Set<LDLfFormula> previousCalls) {
        if (label instanceof EmptyTrace)
            return new QuotedTrueFormula();

        if (label instanceof PossibleWorldWrap) {
            PossibleWorldWrap pwwLabel = (PossibleWorldWrap)label;
            PropositionLast last = new PropositionLast();
            PropositionalFormula pf = this.regExpLocal2Propositional();

            if (pwwLabel.satisfies(pf)) {
                if (pwwLabel.contains(last)) {
                    return ((LDLfFormula) goal.clone()).delta(new EmptyTrace(), previousCalls);
                } else
                    return new QuotedVar((LDLfFormula) goal.clone());
            } else { // !world.satisfies(pf)
                return new QuotedTrueFormula();
            }
        }
        else
            throw new RuntimeException("The label is neither EmptyTrace nor PossibleWorldWrap");
    }

}
