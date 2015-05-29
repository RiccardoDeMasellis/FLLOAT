/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalNotFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfBoolOpLocalFormula<S>, NotFormula<S> {

    public LTLfLocalNotFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_NOT;
    }
}
