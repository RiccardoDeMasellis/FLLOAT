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
public interface OrFormula<S extends Symbol<?>> extends BinaryFormula<S>, BooleanOpFormula<S> {

    default String stringOperator() {
        return "OR";
    }

    default Formula<S> nnf() {
        Formula<S> left = this.getLeftFormula().nnf();
        Formula<S> right = this.getRightFormula().nnf();
        return this.boolOpFormulaFactory(BoolOpType.OR, left, right);
    }

    @Override
    default Formula<S> negate() {
        Formula<S> left = this.getLeftFormula().negate();
        Formula<S> right = this.getRightFormula().negate();
        return this.boolOpFormulaFactory(BoolOpType.AND, left, right);
    }
}
