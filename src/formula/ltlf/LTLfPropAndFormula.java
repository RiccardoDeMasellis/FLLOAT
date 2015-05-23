package formula.ltlf;

import formula.AndFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropAndFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfPropFormula<S>, AndFormula<S> {

    public LTLfPropAndFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }
}
