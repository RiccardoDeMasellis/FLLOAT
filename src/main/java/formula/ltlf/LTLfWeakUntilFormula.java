/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfWeakUntilFormula extends LTLfBinaryFormula implements LTLfTempOpTempFormula {

    public LTLfWeakUntilFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return "WU";
    }

    // Wikipedia: phi WU psi = psi R (psi OR phi)
    @Override
    public LTLfFormula nnf() {
        LTLfFormula phi = (LTLfFormula) this.getLeftFormula().nnf();
        LTLfFormula psi = (LTLfFormula) this.getRightFormula().nnf();
        LTLfFormula or;

        if (phi instanceof LTLfLocalFormula && psi instanceof LTLfLocalFormula)
            or = new LTLfLocalOrFormula(psi, phi);

        else
            or = new LTLfTempOrFormula(psi, phi);

        return new LTLfReleaseFormula(psi, or);
    }

    @Override
    public LTLfFormula antinnf() {
        LTLfUntilFormula until = new LTLfUntilFormula((LTLfFormula) this.getLeftFormula().clone(), (LTLfFormula) this.getRightFormula().clone());
        LTLfGloballyFormula globally = new LTLfGloballyFormula((LTLfFormula) this.getLeftFormula().clone());
        LTLfTempOrFormula or = new LTLfTempOrFormula(until, globally);
        return or.antinnf();
    }

    @Override
    public LTLfFormula negate() {
        return (LTLfFormula) this.nnf().negate();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_WEAK_UNTIL;
    }


    @Override
    public LDLfFormula toLDLfRec() {
        throw new RuntimeException();
    }
}
