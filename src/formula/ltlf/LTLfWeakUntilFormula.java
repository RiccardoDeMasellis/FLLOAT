/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfWeakUntilFormula<S extends Symbol<?>> extends LTLfBinaryFormula<S> implements LTLfTempOpTempFormula<S> {

    public LTLfWeakUntilFormula(LTLfFormula<S> left, LTLfFormula<S> right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return "WU";
    }

    // Wikipedia: phi WU psi = psi R (psi OR phi)
    @Override
    public LTLfFormula<S> nnf() {
        LTLfFormula<S> left = (LTLfFormula<S>) this.getLeftFormula().nnf();
        LTLfFormula<S> right = (LTLfFormula<S>) this.getRightFormula().nnf();
        LTLfFormula<S> or;

        if (left instanceof LTLfLocalFormula && right instanceof LTLfLocalFormula)
            or = new LTLfLocalOrFormula<>(left, right);

        else
            or = new LTLfTempOrFormula<>(left, right);

        return new LTLfReleaseFormula<>(left, or);
    }

    @Override
    public LTLfFormula<S> negate() {
        return (LTLfFormula<S>) this.nnf().negate();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_WEAK_UNTIL;
    }

}
