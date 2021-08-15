/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.TemporalFormula;
import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfWeakNextFormula extends LTLfUnaryFormula implements LTLfTempOpTempFormula {

    public LTLfWeakNextFormula(LTLfFormula nestedFormula) {
        super(nestedFormula);
    }

    public String stringOperator() {
        return "WX";
    }


    /*
    WX phi = NOT(X(NOT phi)) by definition, but, if we require the nnf,
    we need WX as a basic (not derived) operator.
    */
    @Override
    public LTLfFormula nnf() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().nnf();
        return new LTLfWeakNextFormula(nested);
    }


    /*
    NOT (WN phi) = X NOT(phi)
     */
    @Override
    public LTLfFormula negate() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().negate();
        return new LTLfNextFormula(nested);
    }


    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_WEAK_NEXT;
    }

    @Override
    public LDLfFormula toLDLf() {
        LTLfFormula negatedNested;
        if (this.getNestedFormula() instanceof TemporalFormula)
            negatedNested = new LTLfTempNotFormula(this.getNestedFormula());
        else
            negatedNested = new LTLfLocalNotFormula(this.getNestedFormula());
        LTLfFormula next = new LTLfNextFormula(negatedNested);
        LTLfFormula negatedNext = new LTLfTempNotFormula(next);
        return negatedNext.toLDLf();
    }

}
