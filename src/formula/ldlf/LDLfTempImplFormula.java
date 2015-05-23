package formula.ldlf;

import formula.ImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempImplFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfTempFormula<S>, ImplFormula<S> {

    public LDLfTempImplFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + ImplFormula.super.stringOperator();
    }

}
