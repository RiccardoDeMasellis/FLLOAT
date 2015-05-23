package formula.ldlf;

import formula.AndFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempAndFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfTempFormula<S>, AndFormula<S> {
    public LDLfTempAndFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + AndFormula.super.stringOperator();
    }
}
