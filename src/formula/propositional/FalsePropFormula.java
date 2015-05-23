package formula.propositional;

import formula.AtomicFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class FalsePropFormula<S extends Symbol<?>> implements AtomicFormula<S>, PropFormula<S> {

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
        return "false";
    }
}
