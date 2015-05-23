package formula.regExp;

import formula.Formula;
import formula.UnaryFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 21/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class RegExpUnary<S extends Symbol<?>> implements UnaryFormula<S>, RegExp<S> {
    private Formula<S> nestedFormula;

    public RegExpUnary(Formula<S> nestedFormula) {
        this.nestedFormula = nestedFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegExpUnary<?> that = (RegExpUnary<?>) o;

        return !(getNestedFormula() != null ? !getNestedFormula().equals(that.getNestedFormula()) : that.getNestedFormula() != null);

    }

    @Override
    public int hashCode() {
        return getNestedFormula() != null ? getNestedFormula().hashCode() : 0;
    }

    @Override
    public Formula<S> getNestedFormula() {
        return nestedFormula;
    }


    public String toString() {
        return this.stringOperator() + "(" + getNestedFormula() + ")";
    }
}
