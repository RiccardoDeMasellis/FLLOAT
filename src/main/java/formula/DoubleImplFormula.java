/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface DoubleImplFormula extends BinaryFormula, BooleanOpFormula {

    default String stringOperator() {
        return "DOUBLEIMPL";
    }

    default Formula nnf() {
        Formula left = this.getLeftFormula().clone();
        Formula right = this.getRightFormula().clone();
        Formula impl1 = this.boolOpFormulaFactory(BoolOpType.IMPL, left, right);
        Formula impl2 = this.boolOpFormulaFactory(BoolOpType.IMPL, right, left);
        return this.boolOpFormulaFactory(BoolOpType.AND, impl1.nnf(), impl2.nnf());
    }

    default Formula negate() {
        return this.nnf().negate();
    }
}
