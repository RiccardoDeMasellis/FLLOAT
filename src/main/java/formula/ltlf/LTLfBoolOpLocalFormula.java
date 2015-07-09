/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.BoolOpType;
import formula.Formula;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfBoolOpLocalFormula extends LTLfLocalFormula, LTLfBoolOpFormula {

    @Override
    default LTLfLocalFormula boolOpFormulaFactory(BoolOpType boolOp, Formula left, Formula right) {
        switch (boolOp) {
            case AND:
                return new LTLfLocalAndFormula((LTLfLocalFormula) left, (LTLfLocalFormula) right);
            case OR:
                return new LTLfLocalOrFormula((LTLfLocalFormula) left, (LTLfLocalFormula) right);
            case IMPL:
                return new LTLfLocalImplFormula((LTLfLocalFormula) left, (LTLfLocalFormula) right);
            case DOUBLEIMPL:
                return new LTLfLocalDoubleImplFormula((LTLfLocalFormula) left, (LTLfLocalFormula) right);
            case NOT:
                return new LTLfLocalNotFormula((LTLfLocalFormula) left);
            default:
                throw new RuntimeException("Error in LTLfBoolOpLocalFormula.boolOpFormulaFactory");
        }
    }
}
