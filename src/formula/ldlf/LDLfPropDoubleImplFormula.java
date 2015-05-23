package formula.ldlf;

import formula.DoubleImplFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropDoubleImplFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfPropFormula<S>, DoubleImplFormula<S> {
    public LDLfPropDoubleImplFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }
}
