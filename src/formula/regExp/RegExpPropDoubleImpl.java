package formula.regExp;

import formula.DoubleImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpPropDoubleImpl<S extends Symbol<?>> extends RegExpBinary<S> implements RegExpProp<S>, DoubleImplFormula<S> {
    public RegExpPropDoubleImpl(RegExp<S> left, RegExp<S> right) {
        super(left, right);
    }
}
