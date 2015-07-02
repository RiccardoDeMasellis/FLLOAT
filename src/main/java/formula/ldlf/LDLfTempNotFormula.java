/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempNotFormula<S extends Symbol<?>> extends LDLfUnaryFormula<S> implements LDLfBoolOpTempFormula<S>, NotFormula<S> {

    public LDLfTempNotFormula(LDLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "Te" + NotFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_NOT;
    }
}
