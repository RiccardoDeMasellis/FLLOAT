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
import formula.ldlf.LDLfBoxFormula;

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
    public LDLfBoxFormula toLDLfRec() {
        throw new RuntimeException();
    }

    @Override
    public LTLfFormula antinnf() {
        LTLfFormula leftNot, rightNot, left, right;
        left = this.getLeftFormula().antinnf();
        right = this.getRightFormula().antinnf();

        if (left instanceof TemporalFormula)
            leftNot = new LTLfTempNotFormula(left);
        else
            leftNot = new LTLfLocalNotFormula(left);


        if (right instanceof TemporalFormula)
            rightNot = new LTLfTempNotFormula(right);
        else
            rightNot = new LTLfLocalNotFormula(right);

        LTLfUntilFormula until = new LTLfUntilFormula(leftNot, rightNot);
        return new LTLfTempNotFormula(until);
    }
}
