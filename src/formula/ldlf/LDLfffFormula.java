/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.AtomicFormula;
import formula.Formula;
import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfffFormula<S extends Symbol<?>> implements AtomicFormula<S>, LDLfTempFormula<S> {

    public LDLfffFormula() {
        super();
    }

    @Override
    public LDLfffFormula<S> clone() {
        return new LDLfffFormula<>();
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        else
            return this.getClass().equals(o.getClass());
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public String toString() {
        return "ff";
    }

    @Override
    public LDLfFormula<S> nnf() {
        return this.clone();
    }

    @Override
    public Formula<S> negate() {
        return new LDLfffFormula<>();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_ff;
    }
}
