package formula.ldlf;

import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempNotFormula<S extends Symbol<?>> extends LDLfUnaryFormula<S> implements LDLfTempFormula<S>, NotFormula<S> {

    public LDLfTempNotFormula(LDLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "Te" + NotFormula.super.stringOperator();
    }
}
