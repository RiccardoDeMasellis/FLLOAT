package formula.ldlf;

import formula.regExp.RegExp;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfBoxFormula<S extends Symbol<?>> extends LDLfTempOpFormula<S> {

    public LDLfBoxFormula(RegExp<S> regExp, LDLfFormula<S> goalFormula) {
        super(regExp, goalFormula);
    }

    public String toString() {
        return "[" + this.getRegExp() + "]" + "(" + this.getGoalFormula() + ")";
    }
}
