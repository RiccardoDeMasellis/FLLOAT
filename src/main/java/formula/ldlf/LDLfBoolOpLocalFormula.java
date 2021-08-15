/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.BoolOpType;
import formula.Formula;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LDLfBoolOpLocalFormula extends LDLfLocalFormula, LDLfBoolOpFormula {

    @Override
    default LDLfLocalFormula boolOpFormulaFactory(BoolOpType boolOp, Formula left, Formula right) {
        switch (boolOp) {
            case AND:
                return new LDLfLocalAndFormula((LDLfLocalFormula) left, (LDLfLocalFormula) right);
            case OR:
                return new LDLfLocalOrFormula((LDLfLocalFormula) left, (LDLfLocalFormula) right);
            case IMPL:
                return new LDLfLocalImplFormula((LDLfLocalFormula) left, (LDLfLocalFormula) right);
            case DOUBLEIMPL:
                return new LDLfLocalDoubleImplFormula((LDLfLocalFormula) left, (LDLfLocalFormula) right);
            case NOT:
                return new LDLfLocalNotFormula((LDLfLocalFormula) left);
            default:
                throw new RuntimeException("Error in LDLfBoolOpLocalFormula.boolOpFormulaFactory");
        }
    }
}
