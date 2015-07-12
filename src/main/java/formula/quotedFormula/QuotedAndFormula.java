/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import formula.ldlf.LDLfFormula;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Conjunction;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedAndFormula extends QuotedBinaryFormula {

    public QuotedAndFormula(QuotedFormula left, QuotedFormula right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + this.getLeftFormula() + ") AND (" + this.getRightFormula() + ")";
    }

    @Override
    public QuotedFormula delta(PossibleWorld world) {
        QuotedFormula left = this.getLeftFormula().delta(world);
        QuotedFormula right = this.getRightFormula().delta(world);
        return new QuotedAndFormula(left, right);
    }

    @Override
    public QuotedAndFormula clone() {
        return new QuotedAndFormula(this.getLeftFormula().clone(), this.getRightFormula().clone());
    }

    @Override
    public PropositionalFormula quoted2Prop(HashMap<LDLfFormula, String> LDLf2String, HashMap<String, LDLfFormula> String2LDLf) {
        PropositionalFormula left = this.getLeftFormula().quoted2Prop(LDLf2String, String2LDLf);
        PropositionalFormula right = this.getRightFormula().quoted2Prop(LDLf2String, String2LDLf);
        return new Conjunction(left, right);
    }
}
