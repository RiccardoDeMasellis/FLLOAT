package formula.regExp;

import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropNot<S extends Symbol<?>> extends RegExpUnary<S> implements RegExpProp<S>, NotFormula<S> {

    public RegExpPropNot(RegExpProp<S> nestedFormula) {
        super(nestedFormula);
    }
}
