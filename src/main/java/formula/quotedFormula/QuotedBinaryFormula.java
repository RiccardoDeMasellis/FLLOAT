/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public abstract class QuotedBinaryFormula extends QuotedFormula {

    private QuotedFormula left;
    private QuotedFormula right;

    public QuotedBinaryFormula(QuotedFormula left, QuotedFormula right) {
        this.left = left;
        this.right = right;
    }

    public QuotedFormula getLeftFormula() {
        return left;
    }

    public QuotedFormula getRightFormula() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            QuotedBinaryFormula other = (QuotedBinaryFormula) o;
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

    public abstract String toString();

}
