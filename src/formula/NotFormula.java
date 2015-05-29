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
public interface NotFormula<S extends Symbol<?>> extends UnaryFormula<S>, BooleanOpFormula<S> {

    default String stringOperator() {
        return "NOT";
    }

    default Formula<S> nnf() {
        if (this.getNestedFormula() instanceof LocalVar)
            return (Formula<S>) this.clone();
        else
            return this.getNestedFormula().negate().nnf();
    }

    default Formula<S> negate() {
        return (Formula<S>) this.getNestedFormula().clone();
    }
}