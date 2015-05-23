package formula.regExp;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpAltern<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpTemp<S> {

    public RegExpAltern(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return "+";
    }

}
