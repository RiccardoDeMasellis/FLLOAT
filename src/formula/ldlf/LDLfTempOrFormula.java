package formula.ldlf;

import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempOrFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfTempFormula<S>, OrFormula<S> {

    public LDLfTempOrFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + OrFormula.super.stringOperator();
    }
}
