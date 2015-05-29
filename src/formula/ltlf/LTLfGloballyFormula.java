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
public class LTLfGloballyFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfTempOpTempFormula<S> {

    public LTLfGloballyFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "G";
    }


    /*
    G phi = false R phi
     */
    @Override
    public LTLfFormula<S> nnf() {
        LTLfFormula<S> nested = (LTLfFormula<S>) this.getNestedFormula().nnf();
        return new LTLfReleaseFormula<>(new LTLfLocalFalseFormula<>(), nested);
    }


    /*
    NOT(G phi) = true U NOT(phi)
     */
    @Override
    public LTLfFormula<S> negate() {
        LTLfFormula<S> nested = (LTLfFormula<S>) this.getNestedFormula().negate();
        return new LTLfUntilFormula<>(new LTLfLocalTrueFormula<>(), nested);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_GLOBALLY;
    }
}
