/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.BoolOpType;
import formula.BooleanOpFormula;
import formula.Formula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 28/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpBoolOpLocal<S extends Symbol<?>> extends RegExpLocal<S>, BooleanOpFormula<S> {

    @Override
    default RegExpLocal<S> boolOpFormulaFactory(BoolOpType boolOp, Formula<S> left, Formula<S> right) {
        switch (boolOp) {
            case AND:
                return new RegExpLocalAnd<>((RegExp<S>) left, (RegExp<S>) right);
            case OR:
                return new RegExpLocalOr<>((RegExp<S>) left, (RegExp<S>) right);
            case IMPL:
                return new RegExpLocalImpl<>((RegExp<S>) left, (RegExp<S>) right);
            case DOUBLEIMPL:
                return new RegExpLocalDoubleImpl<>((RegExp<S>) left, (RegExp<S>) right);
            case NOT:
                return new RegExpLocalNot<>((RegExp<S>) left);
            default:
                throw new RuntimeException("Error in RegExpBoolOpLocal.boolOpFormulaFactory");
        }
    }

}
