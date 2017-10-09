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
public class LTLfGloballyFormula extends LTLfUnaryFormula implements LTLfTempOpTempFormula {

    public LTLfGloballyFormula(LTLfFormula nestedFormula) {
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
    public LTLfFormula nnf() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().nnf();
        return new LTLfReleaseFormula(new LTLfLocalFalseFormula(), nested);
    }


    /*
    NOT(G phi) = true U NOT(phi)
     */
    @Override
    public LTLfFormula negate() {
        LTLfFormula nested = (LTLfFormula) this.getNestedFormula().negate();
        return new LTLfUntilFormula(new LTLfLocalTrueFormula(), nested);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_GLOBALLY;
    }

    @Override
    public LDLfFormula toLDLf() {
        LTLfFormula negatedNested;
        if (this.getNestedFormula() instanceof TemporalFormula)
            negatedNested = new LTLfTempNotFormula(this.getNestedFormula());
        else
            negatedNested = new LTLfLocalNotFormula(this.getNestedFormula());
        LTLfFormula eventually = new LTLfEventuallyFormula(negatedNested);
        LTLfFormula negatedEventually = new LTLfTempNotFormula(eventually);
        return negatedEventually.toLDLf();
    }

}
