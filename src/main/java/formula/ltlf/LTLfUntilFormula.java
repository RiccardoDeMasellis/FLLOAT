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
import formula.ldlf.LDLfttFormula;
import formula.regExp.*;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfUntilFormula extends LTLfBinaryFormula implements LTLfTempOpTempFormula {

    public LTLfUntilFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "U";
    }


    @Override
    public LTLfFormula nnf() {
        LTLfFormula left = (LTLfFormula) this.getLeftFormula().nnf();
        LTLfFormula right = (LTLfFormula) this.getRightFormula().nnf();
        return new LTLfUntilFormula(left, right);
    }

    @Override
    public LTLfFormula negate() {
        LTLfFormula left = (LTLfFormula) this.getLeftFormula().negate();
        LTLfFormula right = (LTLfFormula) this.getRightFormula().negate();
        return new LTLfReleaseFormula(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_UNTIL;
    }


    @Override
    public LDLfDiamondFormula toLDLf() {

        // a U b --> <a*><b>tt
        if (this.getLeftFormula() instanceof LTLfLocalFormula && this.getRightFormula() instanceof LTLfLocalFormula) {
            RegExpLocal a = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
            RegExpLocal b = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
            LDLfDiamondFormula innerDiamond = new LDLfDiamondFormula(b, new LDLfttFormula());
            return new LDLfDiamondFormula(a, innerDiamond);
        }

        // a U psi --> <a*> psi
        if (this.getLeftFormula() instanceof LTLfLocalFormula && this.getRightFormula() instanceof LTLfTempFormula) {
            RegExpLocal a = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
            LDLfFormula psi = this.getRightFormula().toLDLf();
            return new LDLfDiamondFormula(a, psi);
        }

        // phi U b --> <(phi? ; true)*><b>tt (me)
        if (this.getLeftFormula() instanceof LTLfTempFormula && this.getRightFormula() instanceof LTLfLocalFormula) {
            LDLfFormula phi = this.getLeftFormula().toLDLf();
            RegExpLocal b = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
            LDLfDiamondFormula innerDiamond = new LDLfDiamondFormula(b, new LDLfttFormula());
            RegExpTest test = new RegExpTest(phi);
            RegExpConcat concat = new RegExpConcat(test, new RegExpLocalTrue());
            RegExpStar star = new RegExpStar(concat);
            return new LDLfDiamondFormula(star, innerDiamond);
        }

        // phi U psi --> <(phi? ; true)*>psi
        if (this.getLeftFormula() instanceof LTLfTempFormula && this.getRightFormula() instanceof LTLfTempFormula) {
            RegExpTest test = new RegExpTest(this.getLeftFormula().toLDLf());
            RegExpConcat concat = new RegExpConcat(test, new RegExpLocalTrue());
            RegExpStar star = new RegExpStar(concat);
            return new LDLfDiamondFormula(star, this.getRightFormula().toLDLf());
        }

        throw new RuntimeException("Error in Until toLDLf()");
    }

}
