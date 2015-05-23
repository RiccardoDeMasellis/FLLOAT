package formula.regExp;

import formula.propositional.FalsePropFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropFalse<S extends Symbol<?>> extends FalsePropFormula<S> implements RegExpProp<S> {

    public RegExpPropFalse() {
        super();
    }
}
