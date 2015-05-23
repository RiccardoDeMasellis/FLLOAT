package formula.ltlf;

import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempOrFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements OrFormula<S>, LTLfTempFormula<S> {

    public LTLfTempOrFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + OrFormula.super.stringOperator();
    }
}
