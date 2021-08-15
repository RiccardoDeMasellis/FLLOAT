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

/**
 * Created by Riccardo De Masellis on 28/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpBoolOpLocal extends RegExpLocal, BooleanOpFormula {

    @Override
    default RegExpLocal boolOpFormulaFactory(BoolOpType boolOp, Formula left, Formula right) {
        switch (boolOp) {
            case AND:
                return new RegExpLocalAnd((RegExp) left, (RegExp) right);
            case OR:
                return new RegExpLocalOr((RegExp) left, (RegExp) right);
            case IMPL:
                return new RegExpLocalImpl((RegExp) left, (RegExp) right);
            case DOUBLEIMPL:
                return new RegExpLocalDoubleImpl((RegExp) left, (RegExp) right);
            case NOT:
                return new RegExpLocalNot((RegExp) left);
            default:
                throw new RuntimeException("Error in RegExpBoolOpLocal.boolOpFormulaFactory");
        }
    }

}
