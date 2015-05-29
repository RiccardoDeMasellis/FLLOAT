/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.BinaryFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 19/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LTLfBinaryFormula<S extends Symbol<?>> implements BinaryFormula<S>, LTLfFormula<S> {

    private LTLfFormula<S> left, right;

    public LTLfBinaryFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LTLfBinaryFormula<S> other = (LTLfBinaryFormula<S>) o;
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

    public LTLfFormula<S> getLeftFormula() {
        return left;
    }

    public LTLfFormula<S> getRightFormula() {
        return right;
    }

    public String toString() {
        return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
    }

    @Override
    public LTLfBinaryFormula<S> clone() {
        return (LTLfBinaryFormula<S>) this.formulaFactory(this.getFormulaType(), (LTLfFormula<S>) this.getLeftFormula().clone(), (LTLfFormula<S>) this.getRightFormula().clone(), null);
    }
}
