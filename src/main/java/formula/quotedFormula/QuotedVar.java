/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import formula.ldlf.LDLfFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedVar<S extends Symbol<?>> extends QuotedAtomicFormula<S> {

    private LDLfFormula<S> unquotedFormula;

    public QuotedVar(LDLfFormula<S> unquotedFormula) {
        this.unquotedFormula = unquotedFormula;
    }

    public LDLfFormula<S> getUnquotedFormula() {
        return unquotedFormula;
    }

    public boolean equals(Object o) {
        if (this.getClass().equals(o.getClass())) {
            QuotedVar other = (QuotedVar<S>) o;
            return this.getUnquotedFormula().equals(other.getUnquotedFormula());
        }
        return false;
    }


    @Override
    public String toString() {
        return "''" + this.getUnquotedFormula().toString() + "''";
    }


    @Override
    public int hashCode() {
        return getUnquotedFormula() != null ? getUnquotedFormula().hashCode() : 0;
    }


    public QuotedVar<S> clone() {
        return new QuotedVar<>((LDLfFormula<S>) this.getUnquotedFormula().clone());
    }
}
