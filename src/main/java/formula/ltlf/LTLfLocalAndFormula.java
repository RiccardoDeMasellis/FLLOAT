/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.AndFormula;
import formula.FormulaType;
import formula.ldlf.LDLfLocalAndFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalAnd;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalAndFormula extends LTLfBinaryFormula implements LTLfBoolOpLocalFormula, AndFormula {

    public LTLfLocalAndFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_AND;
    }


    @Override
    public LDLfLocalAndFormula toLDLf() {
        return new LDLfLocalAndFormula(this.getLeftFormula().toLDLf(), this.getRightFormula().toLDLf());
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        RegExpLocal left = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
        RegExpLocal right = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
        return new RegExpLocalAnd(left, right);
    }
}
