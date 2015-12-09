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
import formula.quotedFormula.QuotedFalseFormula;
import formula.quotedFormula.QuotedFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.State;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfffFormula implements AtomicFormula, LDLfTempFormula {

    public LDLfffFormula() {
        super();
    }

    @Override
    public LDLfffFormula clone() {
        return new LDLfffFormula();
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass()))
            return true;
        else
            return false;
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public String toString() {
        return "ff";
    }

    @Override
    public LDLfFormula nnf() {
        return this.clone();
    }

    @Override
    public Formula negate() {
        return new LDLfffFormula();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_ff;
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
        return new QuotedFalseFormula();
    }

    @Override
    public Automaton buildAutomaton(PropositionalSignature ps) {
        // First create a new automaton with the default state factory
        Automaton result = new Automaton(null);

        // Add the current state
        State currState = result.addState(true, false);

        return result;
    }

    @Override
    public Automaton buildAutomatonForEmptyTrace(PropositionalSignature ps) {
        return buildAutomaton(ps);
    }

}
