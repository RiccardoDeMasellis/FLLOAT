package formula.ltlf;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfWeakNextFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfTempFormula<S> {

    public LTLfWeakNextFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "WX";
    }
}
