/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.FormulaType;
import formula.OrFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempOrFormula extends LDLfBinaryFormula implements LDLfBoolOpTempFormula, OrFormula {

    public LDLfTempOrFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + OrFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_OR;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfTempOrFormula other = (LDLfTempOrFormula) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public QuotedFormula delta(TransitionLabel label) {
        return new QuotedOrFormula(this.getLeftFormula().delta(label), this.getRightFormula().delta(label));
    }
}
