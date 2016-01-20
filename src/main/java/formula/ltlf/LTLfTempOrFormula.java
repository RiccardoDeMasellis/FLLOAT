/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.OrFormula;
import formula.ldlf.LDLfTempOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempOrFormula extends LTLfBinaryFormula implements OrFormula, LTLfBoolOpTempFormula {

    public LTLfTempOrFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + OrFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_TEMP_OR;
    }

    @Override
    public LDLfTempOrFormula toLDLf() {
        return new LDLfTempOrFormula(this.getLeftFormula().toLDLf(), this.getRightFormula().toLDLf());
    }

    @Override
    public LTLfFormula antinnf() {
        return new LTLfTempOrFormula(this.getLeftFormula().antinnf(), this.getRightFormula().antinnf());
    }
}
