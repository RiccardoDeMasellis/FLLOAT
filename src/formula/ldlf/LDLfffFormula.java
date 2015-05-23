package formula.ldlf;

import formula.AtomicFormula;
import formula.TemporalFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfffFormula<S extends Symbol<?>> implements AtomicFormula<S>, LDLfFormula<S>, TemporalFormula<S> {

    public LDLfffFormula() {
        super();
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
}
