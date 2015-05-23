package formula.ldlf;

import formula.ImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropImplFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfPropFormula<S>, ImplFormula<S> {
    public LDLfPropImplFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }
}
