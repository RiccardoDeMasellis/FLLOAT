/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.regExp.RegExp;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfBoxFormula<S extends Symbol<?>> extends LDLfTempOpTempFormula<S> {

    public LDLfBoxFormula(RegExp<S> regExp, LDLfFormula<S> goalFormula) {
        super(regExp, goalFormula);
    }

    public String toString() {
        return "[" + this.getRegExp() + "]" + "(" + this.getGoalFormula() + ")";
    }

    @Override
    public LDLfFormula<S> nnf() {
        return new LDLfBoxFormula<>((RegExp<S>) this.getRegExp().nnf(), (LDLfFormula<S>) this.getGoalFormula().nnf());
    }

    @Override
    public LDLfFormula<S> negate() {
        return new LDLfDiamondFormula<>((RegExp<S>) this.getRegExp().clone(), (LDLfFormula<S>) this.getGoalFormula().negate());
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_BOX;
    }
}
