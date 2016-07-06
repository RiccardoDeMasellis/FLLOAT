/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.UnaryFormula;

/**
 * Created by Riccardo De Masellis on 21/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LDLfUnaryFormula implements UnaryFormula, LDLfFormula {
    private LDLfFormula nestedFormula;

    public LDLfUnaryFormula(LDLfFormula nestedFormula) {
        this.nestedFormula = nestedFormula;
    }

    @Override
    public LDLfUnaryFormula clone() {
        return (LDLfUnaryFormula) this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone(), null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfUnaryFormula other = (LDLfUnaryFormula) o;
            return this.getNestedFormula().equals(other.getNestedFormula());
        } else return false;
    }

    @Override
    public int hashCode() {
        return getNestedFormula() != null ? getNestedFormula().hashCode() : 0;
    }

    @Override
    public LDLfFormula getNestedFormula() {
        return nestedFormula;
    }


    public String toString() {
        return this.stringOperator() + "(" + getNestedFormula() + ")";
    }

    public LDLfFormula replaceStarFormulas() {
        return (LDLfUnaryFormula) this.formulaFactory(this.getFormulaType(), this.getNestedFormula().replaceStarFormulas(), null, null);
    }
}
