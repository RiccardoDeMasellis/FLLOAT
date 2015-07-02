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
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfBoolOpTempFormula<S extends Symbol<?>> extends LTLfTempFormula<S>, LTLfBoolOpFormula<S> {

    @Override
    default LTLfTempFormula<S> boolOpFormulaFactory(BoolOpType boolOp, Formula<S> left, Formula<S> right) {
        switch (boolOp) {
            case AND:
                return new LTLfTempAndFormula<>(((LTLfFormula<S>) left), ((LTLfFormula<S>) right));
            case OR:
                return new LTLfTempOrFormula<>(((LTLfFormula<S>) left), ((LTLfFormula<S>) right));
            case IMPL:
                return new LTLfTempImplFormula<>(((LTLfFormula<S>) left), ((LTLfFormula<S>) right));
            case DOUBLEIMPL:
                return new LTLfTempDoubleImplFormula<>(((LTLfFormula<S>) left), ((LTLfFormula<S>) right));
            case NOT:
                return new LTLfTempNotFormula<>(((LTLfFormula<S>) left));
            default:
                throw new RuntimeException("Error in LTLfBoolOpTemporalFormula.boolOpFormulaFactory");
        }
    }
}
