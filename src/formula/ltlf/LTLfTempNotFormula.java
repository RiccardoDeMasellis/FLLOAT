package formula.ltlf;

import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfTempNotFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements NotFormula<S>, LTLfTempFormula<S> {

    public LTLfTempNotFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "Te" + NotFormula.super.stringOperator();
    }
}
