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
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempAndFormula;
import formula.ldlf.LDLfTempNotFormula;
import formula.regExp.RegExp;
import formula.regExp.RegExpLocalTrue;
import formula.regExp.RegExpStar;
import utils.FormulaUtils;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfEventuallyFormula extends LTLfUnaryFormula implements LTLfTempOpTempFormula {

    public LTLfEventuallyFormula(LTLfFormula nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "F";
    }

    /*
    F phi = true U phi
    */
    @Override
    public LTLfFormula nnf() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().nnf();
        return new LTLfUntilFormula(new LTLfLocalTrueFormula(), nested);
    }


    /*
    NOT(F phi) = false R NOT(phi)
     */
    @Override
    public LTLfFormula negate() {
        return (LTLfFormula)this.nnf().negate();
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_EVENTUALLY;
    }

    @Override
    public LDLfFormula toLDLf() {
        LDLfFormula ended = FormulaUtils.generateLDLfEndedFormula();
        LDLfFormula notEnded = new LDLfTempNotFormula(ended);
        LDLfFormula and = new LDLfTempAndFormula(this.getNestedFormula().toLDLf(), notEnded);

        RegExp trueStar = new RegExpStar(new RegExpLocalTrue());
        return new LDLfDiamondFormula(trueStar, and);
    }

}
