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
import formula.ldlf.LDLfttFormula;
import formula.regExp.RegExpLocalTrue;
import formula.regExp.RegExpStar;

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
    public LDLfFormula toLDLfRec() {
        // F Phi = <true*> (<true>tt && toLDLfRec(phi))
        RegExpStar star = new RegExpStar(new RegExpLocalTrue());
        LDLfDiamondFormula doAStep = new LDLfDiamondFormula(new RegExpLocalTrue(), new LDLfttFormula());
        LDLfTempAndFormula tempAndFormula = new LDLfTempAndFormula(doAStep, this.getNestedFormula().toLDLfRec());
        return new LDLfDiamondFormula(star, tempAndFormula);
    }

    @Override
    public LTLfFormula antinnf() {
        return new LTLfEventuallyFormula(this.getNestedFormula().antinnf());
    }
}
