/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpConcat<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpTemp<S> {

    public RegExpConcat(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return ";";
    }

    @Override
    public RegExpConcat<S> nnf() {
        return new RegExpConcat<>((RegExp<S>) this.getLeftFormula().nnf(), (RegExp<S>) this.getRightFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest<S> negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpConcat");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_CONCAT;
    }
}
