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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LTLfBinaryFormula<?> that = (LTLfBinaryFormula<?>) o;

        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        return !(right != null ? !right.equals(that.right) : that.right != null);

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
}
