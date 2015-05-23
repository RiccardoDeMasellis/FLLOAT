package formula.ltlf;

import formula.DoubleImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropDoubleImplFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfPropFormula<S>, DoubleImplFormula<S> {

    public LTLfPropDoubleImplFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }
}
