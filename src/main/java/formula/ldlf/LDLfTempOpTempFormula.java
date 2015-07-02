/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.regExp.RegExp;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 23/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LDLfTempOpTempFormula<S extends Symbol<?>> implements LDLfTempFormula<S> {

    private RegExp<S> regExp;
    private LDLfFormula<S> goalFormula;

    public LDLfTempOpTempFormula(RegExp<S> regExp, LDLfFormula<S> goalFormula) {
        this.regExp = regExp;
        this.goalFormula = goalFormula;
    }


    @Override
    public LDLfTempOpTempFormula<S> clone() {
        return (LDLfTempOpTempFormula<S>) this.formulaFactory(this.getFormulaType(), regExp.clone(), goalFormula.clone(), null);
    }


    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfTempOpTempFormula<S> other = (LDLfTempOpTempFormula<S>) o;
            return this.getRegExp().equals(other.getRegExp()) && this.getGoalFormula().equals(other.getGoalFormula());
        }
        return false;
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
