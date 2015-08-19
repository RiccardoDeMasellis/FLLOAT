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
import formula.ldlf.LDLfLocalOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalOrFormula extends LTLfBinaryFormula implements LTLfBoolOpLocalFormula, OrFormula {

    public LTLfLocalOrFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_OR;
    }

    @Override
    public LDLfLocalOrFormula toLDLf() {
        return new LDLfLocalOrFormula(this.getLeftFormula().toLDLf(), this.getRightFormula().toLDLf());
    }
}
