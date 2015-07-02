/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.DoubleImplFormula;
import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalDoubleImpl<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpBoolOpLocal<S>, DoubleImplFormula<S> {
    public RegExpLocalDoubleImpl(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_DOUBLEIMPL;
    }
}
