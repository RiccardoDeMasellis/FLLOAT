/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.UnaryFormula;

/**
 * Created by Riccardo De Masellis on 19/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LTLfUnaryFormula implements UnaryFormula, LTLfFormula {
    private LTLfFormula nestedFormula;

    public LTLfUnaryFormula(LTLfFormula nestedFormula) {
        this.nestedFormula = nestedFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LTLfUnaryFormula other = (LTLfUnaryFormula) o;
            return this.getNestedFormula().equals(other.getNestedFormula());
        } else return false;
    }


    @Override
    public int hashCode() {
        return getNestedFormula() != null ? getNestedFormula().hashCode() : 0;
    }

    @Override
    public LTLfFormula getNestedFormula() {
        return nestedFormula;
    }


    public String toString() {
        return this.stringOperator() + "(" + getNestedFormula() + ")";
    }


    @Override
    public LTLfUnaryFormula clone() {
        return (LTLfUnaryFormula) this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone(), null, null);
    }

}
