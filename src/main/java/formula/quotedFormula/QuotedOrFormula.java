/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Disjunction;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedOrFormula extends QuotedBinaryFormula {

    public QuotedOrFormula(QuotedFormula left, QuotedFormula right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + this.getLeftFormula() + ") OR (" + this.getRightFormula() + ")";
    }

    @Override
    public QuotedFormula delta(PossibleWorld world) {
        throw new RuntimeException("Something wrong: delta method cannot be called on QuotedOrFormula");
    }

    @Override
    public QuotedOrFormula clone() {
        return new QuotedOrFormula(this.getLeftFormula().clone(), this.getRightFormula().clone());
    }

    @Override
    public PropositionalFormula quoted2Prop(HashMap<QuotedVar, Proposition> quotedVar2Prop, HashMap<Proposition, QuotedVar> prop2QuotedVar) {
        PropositionalFormula left = this.getLeftFormula().quoted2Prop(quotedVar2Prop, prop2QuotedVar);
        PropositionalFormula right = this.getRightFormula().quoted2Prop(quotedVar2Prop, prop2QuotedVar);
        return new Disjunction(left, right);
    }


}
