package formula.ltlf;

import formula.propositional.PropVar;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropVar<S extends Symbol<?>> extends PropVar<S> implements LTLfPropFormula<S> {

    public LTLfPropVar(S symbol) {
        super(symbol);
    }
}
