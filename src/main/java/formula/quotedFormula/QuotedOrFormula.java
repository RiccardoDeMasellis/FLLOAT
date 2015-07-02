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
public class QuotedOrFormula<S extends Symbol<?>> extends QuotedBinaryFormula<S> {

    public QuotedOrFormula(QuotedFormula left, QuotedFormula right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + this.getLeftFormula() + ") OR (" + this.getRightFormula() + ")";
    }

    @Override
    public QuotedOrFormula<S> clone() {
        return new QuotedOrFormula<>(this.getLeftFormula().clone(), this.getRightFormula().clone());
    }
}
