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
public interface AndFormula extends BinaryFormula, BooleanOpFormula {

    default String stringOperator() {
        return "AND";
    }

    default Formula nnf() {
        Formula left = this.getLeftFormula().nnf();
        Formula right = this.getRightFormula().nnf();
        return this.boolOpFormulaFactory(BoolOpType.AND, left, right);
    }

    @Override
    default Formula negate() {
        Formula left = this.getLeftFormula().negate();
        Formula right = this.getRightFormula().negate();
        return this.boolOpFormulaFactory(BoolOpType.OR, left, right);
    }
}
