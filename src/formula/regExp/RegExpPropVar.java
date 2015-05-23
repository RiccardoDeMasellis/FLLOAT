package formula.regExp;

import formula.propositional.PropVar;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropVar<S extends Symbol<?>> extends PropVar<S> implements RegExpProp<S> {

    public RegExpPropVar(S symbol) {
        super(symbol);
    }
}
