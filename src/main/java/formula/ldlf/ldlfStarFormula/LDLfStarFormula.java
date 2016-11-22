/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf.ldlfStarFormula;

import formula.FormulaType;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfTempNotFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

/**
 * Created by Riccardo De Masellis on 04/07/16.
 */
public abstract class LDLfStarFormula implements LDLfFormula {
    LDLfFormula starFormula;

    public abstract LDLfFormula clone();

    public LDLfFormula getStarFormula() {
        return starFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LDLfStarFormula that = (LDLfStarFormula) o;

        return getStarFormula().equals(that.getStarFormula());
    }

    @Override
    public int hashCode() {
        return getStarFormula().hashCode();
    }

    public LDLfFormula replaceStarFormulas() {
        return (LDLfFormula) this.getStarFormula().clone();
    }


    @Override
    public LDLfFormula negate() {
        return new LDLfTempNotFormula((LDLfStarFormula) this.clone());
    }

    @Override
    public LDLfFormula nnf() {
        return (LDLfStarFormula) this.clone();
    }


    /*
        Inherited method that does not make sense for LDLfStarFormulas!
     */
    public PropositionalSignature getSignature() {
        throw new RuntimeException("getSignature should not be called on LDLfStarFormulas!");
    }

    public void getSignatureRic(PropositionalSignature sig) {
        throw new RuntimeException("getSignature should not be called on LDLfStarFormulas!");
    }

    public FormulaType getFormulaType() {
        throw new RuntimeException("getFormulaType should not be called on LDLfStarFormulas!");
    }
}
