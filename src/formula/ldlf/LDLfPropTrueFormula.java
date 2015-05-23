package formula.ldlf;

import formula.propositional.TruePropFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropTrueFormula<S extends Symbol<?>> extends TruePropFormula<S> implements LDLfPropFormula<S> {
    public LDLfPropTrueFormula() {
        super();
    }
}
