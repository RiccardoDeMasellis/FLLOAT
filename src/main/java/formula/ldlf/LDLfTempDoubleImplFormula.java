/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.DoubleImplFormula;
import formula.FormulaType;
import formula.quotedFormula.QuotedFormula;

import java.util.Set;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempDoubleImplFormula extends LDLfBinaryFormula implements LDLfBoolOpTempFormula, DoubleImplFormula {

    public LDLfTempDoubleImplFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + DoubleImplFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_DOUBLEIMPL;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfTempDoubleImplFormula other = (LDLfTempDoubleImplFormula) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public QuotedFormula delta(TransitionLabel label, Set<LDLfFormula> previousCalls) {
        return ((LDLfFormula) this.nnf()).delta(label, previousCalls);
    }
}
