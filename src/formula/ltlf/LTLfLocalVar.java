/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.LocalVar;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalVar<S extends Symbol<?>> extends LocalVar<S> implements LTLfLocalFormula<S> {

    public LTLfLocalVar(S symbol) {
        super(symbol);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_VAR;
    }


    @Override
    public LTLfFormula<S> negate() {
        return new LTLfLocalNotFormula<>((LTLfFormula<S>) this.clone());
    }

    @Override
    public LTLfFormula<S> nnf() {
        return (LTLfFormula<S>) this.clone();
    }
}
