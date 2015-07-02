/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.Formula;
import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpStar<S extends Symbol<?>> extends RegExpUnary<S> implements RegExpTemp<S> {

    public RegExpStar(RegExp<S> nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "*";
    }

    @Override
    public Formula<S> nnf() {
        return new RegExpStar<>((RegExp<S>) this.getNestedFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest<S> negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpStar");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_STAR;
    }
}
