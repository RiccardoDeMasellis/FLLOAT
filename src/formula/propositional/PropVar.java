package formula.propositional;

import formula.AtomicFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class PropVar<S extends Symbol<?>> implements PropFormula<S>, AtomicFormula<S> {

    private S symbol;

    public PropVar(S symbol) {
        this.symbol = symbol;
    }

    public S getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropVar<?> propVar = (PropVar<?>) o;

        return !(getSymbol() != null ? !getSymbol().equals(propVar.getSymbol()) : propVar.getSymbol() != null);

    }

    @Override
    public int hashCode() {
        return getSymbol() != null ? getSymbol().hashCode() : 0;
    }

    public String toString() {
        return symbol.toString();
    }
}
