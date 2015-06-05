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
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LDLfBoolOpTempFormula<S extends Symbol<?>> extends LDLfTempFormula<S>, LDLfBoolOpFormula<S> {

    @Override
    default LDLfTempFormula<S> boolOpFormulaFactory(BoolOpType boolOp, Formula<S> left, Formula<S> right) {
        switch (boolOp) {
            case AND:
                return new LDLfTempAndFormula<>(((LDLfFormula<S>) left), ((LDLfFormula<S>) right));
            case OR:
                return new LDLfTempOrFormula<>(((LDLfFormula<S>) left), ((LDLfFormula<S>) right));
            case IMPL:
                return new LDLfTempImplFormula<>(((LDLfFormula<S>) left), ((LDLfFormula<S>) right));
            case DOUBLEIMPL:
                return new LDLfTempDoubleImplFormula<>(((LDLfFormula<S>) left), ((LDLfFormula<S>) right));
            case NOT:
                return new LDLfTempNotFormula<>(((LDLfFormula<S>) left));
            default:
                throw new RuntimeException("Error in LDLfBoolOpTemporalFormula.boolOpFormulaFactory");
        }
    }
}
