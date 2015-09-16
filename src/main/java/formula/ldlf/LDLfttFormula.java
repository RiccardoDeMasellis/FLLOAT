/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.AtomicFormula;
import formula.Formula;
import formula.FormulaType;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedTrueFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfttFormula implements AtomicFormula, LDLfTempFormula {

    public LDLfttFormula() {
        super();
    }

    @Override
    public LDLfttFormula clone() {
        return new LDLfttFormula();
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        else
            return this.getClass().equals(o.getClass());
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public String toString() {
        return "tt";
    }

    @Override
    public LDLfFormula nnf() {
        return this.clone();
    }

    @Override
    public Formula negate() {
        return new LDLfttFormula();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_tt;
    }

    public PropositionalSignature getSignature() {
        PropositionalSignature sig = new PropositionalSignature();
        this.getSignatureRic(sig);
        return sig;
    }

    public void getSignatureRic(PropositionalSignature sig) {
        return;
    }

    @Override
    public QuotedFormula delta(TransitionLabel label) {
        return new QuotedTrueFormula();
    }
}
