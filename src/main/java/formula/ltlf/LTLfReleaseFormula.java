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
import formula.regExp.RegExpConcat;
import formula.regExp.RegExpLocalTrue;
import formula.regExp.RegExpStar;
import formula.regExp.RegExpTest;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfReleaseFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfTempOpTempFormula<S> {

    public LTLfReleaseFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "R";
    }

    @Override
    public LTLfFormula<S> nnf() {
        LTLfFormula<S> left = (LTLfFormula<S>) this.getLeftFormula().nnf();
        LTLfFormula<S> right = (LTLfFormula<S>) this.getRightFormula().nnf();
        return new LTLfReleaseFormula<>(left, right);
    }

    @Override
    public LTLfFormula<S> negate() {
        LTLfFormula<S> left = (LTLfFormula<S>) this.getLeftFormula().negate();
        LTLfFormula<S> right = (LTLfFormula<S>) this.getRightFormula().negate();
        return new LTLfUntilFormula<>(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_RELEASE;
    }


    @Override
    public LDLfBoxFormula<S> toLDLf() {
        RegExpTest<S> test = new RegExpTest<>((LDLfFormula<S>) this.getLeftFormula().toLDLf().negate());
        RegExpConcat<S> concat = new RegExpConcat<>(test, new RegExpLocalTrue<>());
        RegExpStar<S> star = new RegExpStar<>(concat);
        return new LDLfBoxFormula<>(star, this.getRightFormula().toLDLf());
    }
}
