/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.FormulaType;
import formula.NotFormula;
import formula.quotedFormula.QuotedFormula;

import java.util.Set;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempNotFormula extends LDLfUnaryFormula implements LDLfBoolOpTempFormula, NotFormula {

    public LDLfTempNotFormula(LDLfFormula nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "Te" + NotFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_TEMP_NOT;
    }


    @Override
    public QuotedFormula delta(TransitionLabel label, Set<LDLfFormula> visited) {
        return ((LDLfFormula) this.nnf()).delta(label, visited);
    }
}
