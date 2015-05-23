package formula.regExp;

import formula.ldlf.LDLfFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpTest<S extends Symbol<?>> extends RegExpUnary<S> implements RegExpTemp<S> {

    public RegExpTest(LDLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "?";
    }
}
