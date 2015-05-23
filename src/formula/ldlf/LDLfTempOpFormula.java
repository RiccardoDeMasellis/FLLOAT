package formula.ldlf;

import formula.regExp.RegExp;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 22/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LDLfTempOpFormula<S extends Symbol<?>> implements LDLfTempFormula<S> {
    private RegExp<S> regExp;
    private LDLfFormula<S> goalFormula;

    public LDLfTempOpFormula(RegExp<S> regExp, LDLfFormula<S> goalFormula) {
        this.regExp = regExp;
        this.goalFormula = goalFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LDLfTempOpFormula<?> that = (LDLfTempOpFormula<?>) o;

        if (getRegExp() != null ? !getRegExp().equals(that.getRegExp()) : that.getRegExp() != null) return false;
        return !(getGoalFormula() != null ? !getGoalFormula().equals(that.getGoalFormula()) : that.getGoalFormula() != null);

    }

    @Override
    public int hashCode() {
        int result = getRegExp() != null ? getRegExp().hashCode() : 0;
        result = 31 * result + (getGoalFormula() != null ? getGoalFormula().hashCode() : 0);
        return result;
    }

    public RegExp<S> getRegExp() {
        return regExp;
    }

    public LDLfFormula<S> getGoalFormula() {
        return goalFormula;
    }
}
