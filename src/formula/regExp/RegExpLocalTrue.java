/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FormulaType;
import formula.TrueLocalFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalTrue<S extends Symbol<?>> extends TrueLocalFormula<S> implements RegExpLocal<S> {

    public RegExpLocalTrue() {
        super();
    }

    @Override
    public RegExpLocalTrue<S> nnf() {
        return (RegExpLocalTrue<S>) this.clone();
    }

    @Override
    public RegExpLocalFalse<S> negate() {
        return new RegExpLocalFalse<>();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_TRUE;
    }
}