package formula.regExp;

import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropOr<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpProp<S>, OrFormula<S> {

    public RegExpPropOr(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }
}
