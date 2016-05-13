/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import automaton.TransitionLabel;
import formula.ldlf.LDLfFormula;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedVar extends QuotedAtomicFormula {

    private LDLfFormula unquotedFormula;

    public QuotedVar(LDLfFormula unquotedFormula) {
        this.unquotedFormula = unquotedFormula;
    }

    public LDLfFormula getUnquotedFormula() {
        return unquotedFormula;
    }

    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass()))
            return false;
        else {
            QuotedVar other = (QuotedVar) o;
            return this.getUnquotedFormula().equals(other.getUnquotedFormula());
        }
    }

    @Override
    public String toString() {
        return "''" + this.getUnquotedFormula().toString() + "''";
    }


    @Override
    public int hashCode() {
        return getUnquotedFormula() != null ? getUnquotedFormula().hashCode() : 0;
    }

    public QuotedVar clone() {
        return new QuotedVar((LDLfFormula) this.getUnquotedFormula().clone());
    }

    @Override
    public PropositionalFormula quoted2Prop(HashMap<QuotedVar, Proposition> quotedVar2Prop, HashMap<Proposition, QuotedVar> prop2QuotedVar) {
        Proposition prop;
        if (quotedVar2Prop.containsKey(this))
            prop = quotedVar2Prop.get(this);
        else {
            prop = new Proposition(Integer.toString(quotedVar2Prop.size()));
            quotedVar2Prop.put(this, prop);
            prop2QuotedVar.put(prop, this);
        }
        return new Proposition(prop);
    }

    @Override
    public QuotedFormula delta(TransitionLabel label) {
        return this.getUnquotedFormula().delta(label, null);
    }
}
