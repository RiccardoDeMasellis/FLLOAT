package formula.ltlf;

import formula.DoubleImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempDoubleImplFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements DoubleImplFormula<S>, LTLfTempFormula<S> {

    public LTLfTempDoubleImplFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + DoubleImplFormula.super.stringOperator();
    }
}
