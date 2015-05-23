package formula.ldlf;

import formula.AndFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropAndFormula<S extends Symbol<?>> extends LDLfBinaryFormula<S> implements LDLfPropFormula<S>, AndFormula<S> {

    public LDLfPropAndFormula(LDLfFormula<S> left, LDLfFormula<S> right) {
        super(left, right);
    }
}
