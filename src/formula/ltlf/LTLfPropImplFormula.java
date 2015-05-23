package formula.ltlf;

import formula.ImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropImplFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfPropFormula<S>, ImplFormula<S> {

    public LTLfPropImplFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }
}
