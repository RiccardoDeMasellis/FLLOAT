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
public abstract class QuotedFormula<S extends Symbol<?>> implements Cloneable {

    public abstract QuotedFormula<S> clone();

    public abstract boolean equals(Object o);

    public abstract String toString();

    public abstract int hashCode();
}
