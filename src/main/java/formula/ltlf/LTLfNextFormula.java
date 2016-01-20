/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.ldlf.LDLfDiamondFormula;
import formula.regExp.RegExpLocalTrue;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfNextFormula extends LTLfUnaryFormula implements LTLfTempOpTempFormula {

    public LTLfNextFormula(LTLfFormula nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "X";
    }


    @Override
    public LTLfFormula nnf() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().nnf();
        return new LTLfNextFormula(nested);
    }


    @Override
    public LTLfFormula negate() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().negate();
        return new LTLfWeakNextFormula(nested);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_NEXT;
    }

    @Override
    public LDLfDiamondFormula toLDLf() {
            return new LDLfDiamondFormula(new RegExpLocalTrue(), this.getNestedFormula().toLDLf());
    }

    @Override
    public LTLfFormula antinnf() {
        return new LTLfNextFormula(this.getNestedFormula().antinnf());
    }
}
