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
public class LTLfWeakNextFormula<S extends Symbol<?>> extends LTLfUnaryFormula<S> implements LTLfTempOpTempFormula<S> {

    public LTLfWeakNextFormula(LTLfFormula<S> nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "WX";
    }


    /*
    WN phi = NOT(N(NOT phi)) by definition, but, if we require the nnf,
    we need WN as a basic (not derived) operator.
    */
    @Override
    public LTLfFormula<S> nnf() {
        LTLfFormula<S> nested = (LTLfFormula<S>) this.getNestedFormula().nnf();
        return new LTLfWeakNextFormula<>(nested);
    }


    /*
    NOT (WN phi) = X NOT(phi)
     */
    @Override
    public LTLfFormula<S> negate() {
        LTLfFormula<S> nested = (LTLfFormula<S>) this.getNestedFormula().negate();
        return new LTLfNextFormula<>(nested);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_WEAK_NEXT;
    }
}
