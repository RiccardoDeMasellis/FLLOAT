/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FormulaType;
import formula.LocalVar;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalVar<S extends Symbol<?>> extends LocalVar<S> implements RegExpLocal<S> {

    public RegExpLocalVar(S symbol) {
        super(symbol);
    }

    @Override
    public RegExpLocalVar<S> nnf() {
        return (RegExpLocalVar<S>) this.clone();
    }

    @Override
    public RegExpLocalNot<S> negate() {
        return new RegExpLocalNot<>((RegExpLocalVar<S>) this.clone());
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_VAR;
    }
}
