package formula.ltlf;

import formula.ImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempImplFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements ImplFormula<S>, LTLfTempFormula<S> {

    public LTLfTempImplFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + ImplFormula.super.stringOperator();
    }
}
