/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.TrueLocalFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalTrueFormula<S extends Symbol<?>> extends TrueLocalFormula<S> implements LDLfLocalFormula<S> {
    public LDLfLocalTrueFormula() {
        super();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_TRUE;
    }

    @Override
    public LDLfFormula<S> nnf() {
        return new LDLfLocalTrueFormula<>();
    }


    @Override
    public LDLfFormula<S> negate() {
        return new LDLfLocalFalseFormula<>();
    }
}
