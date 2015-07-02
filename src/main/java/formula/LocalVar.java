/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LocalVar<S extends Symbol<?>> implements LocalFormula<S>, AtomicFormula<S> {

    private S symbol;

    public LocalVar(S symbol) {
        this.symbol = symbol;
    }

    public S getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalVar<?> propVar = (LocalVar<?>) o;

        return !(getSymbol() != null ? !getSymbol().equals(propVar.getSymbol()) : propVar.getSymbol() != null);

    }

    @Override
    public int hashCode() {
        return getSymbol() != null ? getSymbol().hashCode() : 0;
    }

    public String toString() {
        return symbol.toString();
    }

    public Formula<S> clone() {
        return this.formulaFactory(this.getFormulaType(), null, null, this.getSymbol());
    }
}
