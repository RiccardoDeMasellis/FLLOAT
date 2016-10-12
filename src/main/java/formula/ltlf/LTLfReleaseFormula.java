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
import formula.ldlf.*;
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
    public LDLfTempOrFormula toLDLfRec() {
        // phi R psi --> <(toLDLfRec(psi)? ; true)*> (toLDLfRec(phi & psi)) || [true* ; tr(nnf(!psi))?]ff
        RegExpTest test = new RegExpTest(this.getRightFormula().toLDLfRec());
        RegExpConcat concat = new RegExpConcat(test, new RegExpLocalTrue());
        RegExpStar star = new RegExpStar(concat);
        LTLfFormula ltlfAnd;
        /*Necessary check to understand if building an LTLfTemporalAndFormula or LTLfLocalAndFormula*/
        if (this.getLeftFormula() instanceof TemporalFormula || this.getRightFormula() instanceof TemporalFormula)
            ltlfAnd = new LTLfTempAndFormula(this.getLeftFormula(), this.getRightFormula());
        else
            ltlfAnd = new LTLfLocalAndFormula(this.getLeftFormula(), this.getRightFormula());
        LDLfDiamondFormula leftOr = new LDLfDiamondFormula(star, ltlfAnd.toLDLfRec());

        // Second part
        RegExpStar trueStar = new RegExpStar(new RegExpLocalTrue());
        LTLfFormula notPsi;
        if (this.getRightFormula() instanceof TemporalFormula)
            notPsi = new LTLfTempNotFormula(this.getRightFormula());
        else
            notPsi = new LTLfLocalNotFormula(this.getRightFormula());

        LDLfFormula ldlfNotPsi = ((LTLfFormula)notPsi.nnf()).toLDLfRec();

        RegExpTest ldlfNotPsiTest = new RegExpTest(ldlfNotPsi);
        RegExpConcat reconc = new RegExpConcat(trueStar, ldlfNotPsiTest);

        LDLfBoxFormula rightOr = new LDLfBoxFormula(reconc, new LDLfffFormula());

        return new LDLfTempOrFormula(leftOr, rightOr);
    }

}
