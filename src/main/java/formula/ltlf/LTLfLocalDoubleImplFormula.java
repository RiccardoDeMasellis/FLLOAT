/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.DoubleImplFormula;
import formula.FormulaType;
import formula.ldlf.LDLfFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalDoubleImplFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfBoolOpLocalFormula<S>, DoubleImplFormula<S> {

    public LTLfLocalDoubleImplFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }


    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_DOUBLEIMPL;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LTLfLocalDoubleImplFormula<S> other = (LTLfLocalDoubleImplFormula<S>) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public LDLfFormula<S> toLDLf() {
        return ((LTLfFormula<S>) this.nnf()).toLDLf();
    }

}
