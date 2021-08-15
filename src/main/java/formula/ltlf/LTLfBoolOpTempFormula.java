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
public interface LTLfBoolOpTempFormula extends LTLfTempFormula, LTLfBoolOpFormula {

    @Override
    default LTLfTempFormula boolOpFormulaFactory(BoolOpType boolOp, Formula left, Formula right) {
        switch (boolOp) {
            case AND:
                return new LTLfTempAndFormula(((LTLfFormula) left), ((LTLfFormula) right));
            case OR:
                return new LTLfTempOrFormula(((LTLfFormula) left), ((LTLfFormula) right));
            case IMPL:
                return new LTLfTempImplFormula(((LTLfFormula) left), ((LTLfFormula) right));
            case DOUBLEIMPL:
                return new LTLfTempDoubleImplFormula(((LTLfFormula) left), ((LTLfFormula) right));
            case NOT:
                return new LTLfTempNotFormula(((LTLfFormula) left));
            default:
                throw new RuntimeException("Error in LTLfBoolOpTemporalFormula.boolOpFormulaFactory");
        }
    }
}
