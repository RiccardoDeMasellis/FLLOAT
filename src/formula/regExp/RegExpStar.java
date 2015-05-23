package formula.regExp;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpStar<S extends Symbol<?>> extends RegExpUnary<S> implements RegExpTemp<S> {

    public RegExpStar(RegExp<S> nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "*";
    }
}
