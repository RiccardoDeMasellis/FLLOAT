package formula.regExp;

import formula.propositional.TruePropFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropTrue<S extends Symbol<?>> extends TruePropFormula<S> implements RegExpProp<S> {

    public RegExpPropTrue() {
        super();
    }
}