package formula.ldlf;

import formula.DoubleImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfTempDoubleImplFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfTempFormula<S>, DoubleImplFormula<S> {

    public LDLfTempDoubleImplFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }

    public String stringOperator() {
        return "Te" + DoubleImplFormula.super.stringOperator();
    }
}
