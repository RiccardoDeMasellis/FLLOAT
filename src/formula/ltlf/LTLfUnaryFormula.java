package formula.ltlf;

import formula.UnaryFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 19/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LTLfUnaryFormula<S extends Symbol<?>> implements UnaryFormula<S>, LTLfFormula<S> {
    private LTLfFormula<S> nestedFormula;

    public LTLfUnaryFormula(LTLfFormula<S> nestedFormula) {
        this.nestedFormula = nestedFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LTLfUnaryFormula<?> that = (LTLfUnaryFormula<?>) o;

        return !(getNestedFormula() != null ? !getNestedFormula().equals(that.getNestedFormula()) : that.getNestedFormula() != null);
    }

    @Override
    public int hashCode() {
        return getNestedFormula() != null ? getNestedFormula().hashCode() : 0;
    }

    @Override
    public LTLfFormula<S> getNestedFormula() {
        return nestedFormula;
    }

    public String toString() {
        return this.stringOperator() + "(" + getNestedFormula() + ")";
    }

}
