/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedFalseFormula<S extends Symbol<?>> extends QuotedAtomicFormula<S> {

    public QuotedFalseFormula() {
        super();
    }

    @Override
    public QuotedFormula<S> clone() {
        return new QuotedFalseFormula<>();
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public String toString() {
        return "false";
    }
}
