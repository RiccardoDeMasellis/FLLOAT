package formula.ldlf;

import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfPropNotFormula<S extends Symbol<?>> extends LDLfUnaryFormula<S> implements LDLfPropFormula<S>, NotFormula<S> {
    public LDLfPropNotFormula(LDLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }
}
