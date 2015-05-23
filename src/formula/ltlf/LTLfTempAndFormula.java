package formula.ltlf;

import formula.AndFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempAndFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements AndFormula<S>, LTLfTempFormula<S> {

    public LTLfTempAndFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + AndFormula.super.stringOperator();
    }
}
