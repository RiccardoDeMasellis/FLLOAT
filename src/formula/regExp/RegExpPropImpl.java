package formula.regExp;

import formula.ImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropImpl<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpProp<S>, ImplFormula<S> {

    public RegExpPropImpl(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }
}
