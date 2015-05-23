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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LDLfBinaryFormula<?> that = (LDLfBinaryFormula<?>) o;

        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        return !(right != null ? !right.equals(that.right) : that.right != null);

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