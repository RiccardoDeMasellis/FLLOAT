/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.BinaryFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 21/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LDLfBinaryFormula<S extends Symbol<?>> implements BinaryFormula<S>, LDLfFormula<S> {

    private LDLfFormula<S> left, right;

    public LDLfBinaryFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public LDLfBinaryFormula<S> clone() {
        return (LDLfBinaryFormula<S>) this.formulaFactory(this.getFormulaType(), this.getLeftFormula().clone(), this.getRightFormula().clone(), null);
    }


    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfBinaryFormula<S> other = (LDLfBinaryFormula<S>) o;
            return this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    public LDLfFormula<S> getLeftFormula() {
        return left;
    }

    public LDLfFormula<S> getRightFormula() {
        return right;
    }

    public String toString() {
        return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
    }
}