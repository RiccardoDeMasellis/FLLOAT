package formula.ldlf;

import formula.propositional.FalsePropFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropFalseFormula<S extends Symbol<?>> extends FalsePropFormula<S> implements LDLfPropFormula<S> {
    public LDLfPropFalseFormula() {
        super();
    }
}
