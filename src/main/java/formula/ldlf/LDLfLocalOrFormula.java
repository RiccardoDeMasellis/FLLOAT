/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalOrFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfBoolOpLocalFormula<S>, OrFormula<S> {
    public LDLfLocalOrFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_OR;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfLocalOrFormula<S> other = (LDLfLocalOrFormula<S>) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }
}
