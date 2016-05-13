/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.FormulaType;
import formula.ImplFormula;
import formula.quotedFormula.QuotedFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempImplFormula extends LDLfBinaryFormula implements LDLfBoolOpTempFormula, ImplFormula {

    public LDLfTempImplFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + ImplFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_IMPL;
    }

    @Override
    public QuotedFormula delta(TransitionLabel label, LDLfFormula lastCall) {
        return ((LDLfFormula) this.nnf()).delta(label, lastCall);
    }
}
