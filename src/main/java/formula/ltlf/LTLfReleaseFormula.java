/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfffFormula;
import formula.regExp.*;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfReleaseFormula extends LTLfBinaryFormula implements LTLfTempOpTempFormula {

    public LTLfReleaseFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public String stringOperator() {
        return "R";
    }

    @Override
    public LTLfFormula nnf() {
        LTLfFormula left = (LTLfFormula) this.getLeftFormula().nnf();
        LTLfFormula right = (LTLfFormula) this.getRightFormula().nnf();
        return new LTLfReleaseFormula(left, right);
    }

    @Override
    public LTLfFormula negate() {
        LTLfFormula left = (LTLfFormula) this.getLeftFormula().negate();
        LTLfFormula right = (LTLfFormula) this.getRightFormula().negate();
        return new LTLfUntilFormula(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_RELEASE;
    }


    @Override
    public LDLfBoxFormula toLDLf() {

        // a R b = !(!a U !b) --> [(!a)*][!b]ff
        if (this.getLeftFormula() instanceof LTLfLocalFormula && this.getRightFormula() instanceof LTLfLocalFormula) {
            RegExpLocal a = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
            RegExpLocal b = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
            LDLfBoxFormula innerBox = new LDLfBoxFormula((RegExp) b.negate(), new LDLfffFormula());
            RegExpStar star = new RegExpStar((RegExp) a.negate());
            return new LDLfBoxFormula(star, innerBox);
        }


        // a R psi = !(!a U !psi) --> [(!a)*]psi
        if (this.getLeftFormula() instanceof LTLfLocalFormula && this.getRightFormula() instanceof LTLfTempFormula) {
            RegExpLocal a = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
            RegExpStar star = new RegExpStar((RegExp) a.negate());
            return new LDLfBoxFormula(star, this.getRightFormula().toLDLf());
        }


        // phi R b = !(!phi R !b) --> [(!phi)? ; true)*][!b]ff
        if(this.getLeftFormula() instanceof LTLfTempFormula && this.getRightFormula() instanceof LTLfLocalFormula) {
            RegExpLocal b = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
            LDLfBoxFormula innerBox = new LDLfBoxFormula((RegExp) b.negate(), new LDLfffFormula());
            RegExpTest test = new RegExpTest((LDLfFormula) this.getLeftFormula().toLDLf().negate());
            RegExpConcat concat = new RegExpConcat(test, new RegExpLocalTrue());
            RegExpStar star = new RegExpStar(concat);
            return new LDLfBoxFormula(star, innerBox);
        }


        // phi R psi = !(!phi U !psi) --> [((!phi)? ; true)*]psi
        if (this.getLeftFormula() instanceof LTLfTempFormula && this.getRightFormula() instanceof LTLfTempFormula) {
            RegExpTest test = new RegExpTest((LDLfFormula) this.getLeftFormula().toLDLf().negate());
            RegExpConcat concat = new RegExpConcat(test, new RegExpLocalTrue());
            RegExpStar star = new RegExpStar(concat);
            return new LDLfBoxFormula(star, this.getRightFormula().toLDLf());
        }

        throw new RuntimeException("Error in Release toLDLf()");
    }
}
