package formula.ltlf;

import formula.NotFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfPropNotFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfPropFormula<S>, NotFormula<S> {

    public LTLfPropNotFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }
}
