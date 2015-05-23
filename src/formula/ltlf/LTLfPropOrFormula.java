package formula.ltlf;

import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropOrFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfPropFormula<S>, OrFormula<S> {

    public LTLfPropOrFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }
}
