package formula.regExp;

import formula.AndFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropAnd<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpProp<S>, AndFormula<S> {
    public RegExpPropAnd(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }
}
