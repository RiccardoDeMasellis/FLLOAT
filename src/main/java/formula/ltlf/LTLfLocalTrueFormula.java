/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.TrueLocalFormula;
import formula.ldlf.LDLfLocalTrueFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalTrue;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalTrueFormula extends TrueLocalFormula implements LTLfLocalFormula {

    public LTLfLocalTrueFormula() {
        super();
    }

    @Override
    public LTLfFormula nnf() {
        return new LTLfLocalTrueFormula();
    }


    @Override
    public LTLfFormula negate() {
        return new LTLfLocalFalseFormula();
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_TRUE;
    }

    @Override
    public LDLfLocalTrueFormula toLDLf() {
        return new LDLfLocalTrueFormula();
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        return new RegExpLocalTrue();
    }
}
