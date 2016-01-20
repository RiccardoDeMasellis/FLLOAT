/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.ImplFormula;
import formula.TemporalFormula;
import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempImplFormula extends LTLfBinaryFormula implements ImplFormula, LTLfBoolOpTempFormula {

    public LTLfTempImplFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + ImplFormula.super.stringOperator();
    }


    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_TEMP_IMPL;
    }

    @Override
    public LDLfFormula toLDLf() {
        throw new RuntimeException();
    }

    @Override
    public LTLfFormula antinnf() {
        LTLfFormula left = this.getLeftFormula();
        LTLfFormula not;
        if (left instanceof TemporalFormula)
            not = new LTLfTempNotFormula(left);
        else
            not = new LTLfLocalNotFormula(left);
        LTLfTempOrFormula or = new LTLfTempOrFormula(not, this.getRightFormula());
        return or.antinnf();
    }
}
