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
public interface LDLfBoolOpTempFormula extends LDLfTempFormula, LDLfBoolOpFormula {

    @Override
    default LDLfTempFormula boolOpFormulaFactory(BoolOpType boolOp, Formula left, Formula right) {
        switch (boolOp) {
            case AND:
                return new LDLfTempAndFormula(((LDLfFormula) left), ((LDLfFormula) right));
            case OR:
                return new LDLfTempOrFormula(((LDLfFormula) left), ((LDLfFormula) right));
            case IMPL:
                return new LDLfTempImplFormula(((LDLfFormula) left), ((LDLfFormula) right));
            case DOUBLEIMPL:
                return new LDLfTempDoubleImplFormula(((LDLfFormula) left), ((LDLfFormula) right));
            case NOT:
                return new LDLfTempNotFormula(((LDLfFormula) left));
            default:
                throw new RuntimeException("Error in LDLfBoolOpTemporalFormula.boolOpFormulaFactory");
        }
    }
}
