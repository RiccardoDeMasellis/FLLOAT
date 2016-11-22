/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.DoubleImplFormula;
import formula.FormulaType;
import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempDoubleImplFormula extends LTLfBinaryFormula implements DoubleImplFormula, LTLfBoolOpTempFormula {

    public LTLfTempDoubleImplFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + DoubleImplFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_TEMP_DOUBLEIMPL;
    }

    @Override
    public LDLfFormula toLDLfRec() {
        throw new RuntimeException();
    }

}
