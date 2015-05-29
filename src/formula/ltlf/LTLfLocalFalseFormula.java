/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FalseLocalFormula;
import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalFalseFormula<S extends Symbol<?>> extends FalseLocalFormula<S> implements LTLfLocalFormula<S> {

    public LTLfLocalFalseFormula() {
        super();
    }

    @Override
    public LTLfFormula<S> nnf() {
        return new LTLfLocalFalseFormula<>();
    }


    @Override
    public LTLfFormula<S> negate() {
        return new LTLfLocalTrueFormula<>();
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_FALSE;
    }

}
