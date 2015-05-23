package formula.ltlf;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfEventuallyFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfTempFormula<S> {

    public LTLfEventuallyFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "F";
    }
}
