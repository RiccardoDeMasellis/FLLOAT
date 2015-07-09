/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.BinaryFormula;

/**
 * Created by Riccardo De Masellis on 19/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LTLfBinaryFormula implements BinaryFormula, LTLfFormula {

    private LTLfFormula left, right;

    public LTLfBinaryFormula(LTLfFormula left, LTLfFormula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LTLfBinaryFormula other = (LTLfBinaryFormula) o;
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

    public LTLfFormula getLeftFormula() {
        return left;
    }

    public LTLfFormula getRightFormula() {
        return right;
    }

    public String toString() {
        return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
    }

    @Override
    public LTLfBinaryFormula clone() {
        return (LTLfBinaryFormula) this.formulaFactory(this.getFormulaType(), this.getLeftFormula().clone(), this.getRightFormula().clone(), null);
    }
}
