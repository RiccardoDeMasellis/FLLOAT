package formula.ldlf;

import formula.OrFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropOrFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfPropFormula<S>, OrFormula<S> {
    public LDLfPropOrFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }
}
