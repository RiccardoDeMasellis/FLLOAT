package formula.ldlf;

import formula.propositional.PropVar;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropVar<S extends Symbol<?>> extends PropVar<S> implements LDLfPropFormula<S> {

    public LDLfPropVar(S symbol) {
        super(symbol);
    }
}
