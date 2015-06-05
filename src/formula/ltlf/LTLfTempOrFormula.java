/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.OrFormula;
import formula.ldlf.LDLfTempOrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempOrFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements OrFormula<S>, LTLfBoolOpTempFormula<S> {

    public LTLfTempOrFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + OrFormula.super.stringOperator();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_TEMP_OR;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LTLfTempOrFormula<S> other = (LTLfTempOrFormula<S>) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public LDLfTempOrFormula<S> toLDLf() {
        return new LDLfTempOrFormula<>(this.getLeftFormula().toLDLf(), this.getRightFormula().toLDLf());
    }
}
