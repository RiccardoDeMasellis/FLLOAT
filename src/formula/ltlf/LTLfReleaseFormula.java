package formula.ltlf;

import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfReleaseFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfTempFormula<S> {

    public LTLfReleaseFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "R";
    }
}
