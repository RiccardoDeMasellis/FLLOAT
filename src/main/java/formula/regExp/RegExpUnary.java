/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.Formula;
import formula.UnaryFormula;

/**
 * Created by Riccardo De Masellis on 21/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class RegExpUnary implements UnaryFormula, RegExp {
    private Formula nestedFormula;

    public RegExpUnary(Formula nestedFormula) {
        this.nestedFormula = nestedFormula;
    }

    @Override
    public int hashCode() {
        return getNestedFormula() != null ? getNestedFormula().hashCode() : 0;
    }

    @Override
    public Formula getNestedFormula() {
        return nestedFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            RegExpUnary other = (RegExpUnary) o;
            return this.getNestedFormula().equals(other.getNestedFormula());
        } else return false;
    }

    @Override
    public RegExpUnary clone() {
        return (RegExpUnary) this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone(), null, null);
    }


    public String toString() {
        return this.stringOperator() + "(" + getNestedFormula() + ")";
    }
}
