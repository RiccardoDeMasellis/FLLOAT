package formula;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface DoubleImplFormula<S extends Symbol<?>> extends BinaryFormula<S> {

    default String stringOperator() {
        return "DOUBLEIMPL";
    }
}
