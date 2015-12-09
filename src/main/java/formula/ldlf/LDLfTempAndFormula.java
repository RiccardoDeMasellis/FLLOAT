/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.AndFormula;
import formula.FormulaType;
import formula.quotedFormula.QuotedAndFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.transformations.Mix;
import rationals.transformations.Reducer;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempAndFormula extends LDLfBinaryFormula implements LDLfBoolOpTempFormula, AndFormula {
    public LDLfTempAndFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + AndFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_AND;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfTempAndFormula other = (LDLfTempAndFormula) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public QuotedFormula delta(TransitionLabel label) {
        QuotedVar quotedLeft = new QuotedVar(this.getLeftFormula());
        QuotedVar quotedRight = new QuotedVar(this.getRightFormula());

        return new QuotedAndFormula(quotedLeft.delta(label), quotedRight.delta(label));
    }

    @Override
    public Automaton buildAutomaton(PropositionalSignature ps) {
        Automaton a1 = this.getLeftFormula().buildAutomaton(ps);
        Automaton a2 = this.getRightFormula().buildAutomaton(ps);
        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);

    }

    @Override
    public Automaton buildAutomatonForEmptyTrace(PropositionalSignature ps) {
        Automaton a1 = this.getLeftFormula().buildAutomatonForEmptyTrace(ps);
        Automaton a2 = this.getRightFormula().buildAutomatonForEmptyTrace(ps);
        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }
}
