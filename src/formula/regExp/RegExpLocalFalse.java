/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FalseLocalFormula;
import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalFalse<S extends Symbol<?>> extends FalseLocalFormula<S> implements RegExpLocal<S> {

    public RegExpLocalFalse() {
        super();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_FALSE;
    }

    @Override
    public RegExpLocalFalse<S> nnf() {
        return (RegExpLocalFalse<S>) this.clone();
    }

    @Override
    public RegExpLocalTrue<S> negate() {
        return new RegExpLocalTrue<>();
    }
}
