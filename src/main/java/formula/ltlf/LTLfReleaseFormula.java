/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.TemporalFormula;
import formula.ldlf.LDLfFormula;

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
    public LDLfFormula toLDLf() {
        LTLfFormula negatedLeft;
        if (this.getLeftFormula() instanceof TemporalFormula)
            negatedLeft = new LTLfTempNotFormula(this.getLeftFormula());
        else
            negatedLeft = new LTLfLocalNotFormula(this.getLeftFormula());

        LTLfFormula negatedRight;
        if (this.getRightFormula() instanceof TemporalFormula)
            negatedRight = new LTLfTempNotFormula(this.getRightFormula());
        else
            negatedRight = new LTLfLocalNotFormula(this.getRightFormula());

        LTLfFormula until = new LTLfUntilFormula(negatedLeft, negatedRight);
        LTLfFormula negatedUntil = new LTLfTempNotFormula(until);
        return negatedUntil.toLDLf();
    }

}
