/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import formula.ldlf.LDLfFormula;
import net.sf.tweety.logics.pl.syntax.Contradiction;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public class QuotedFalseFormula extends QuotedAtomicFormula {

    public QuotedFalseFormula() {
        super();
    }

    @Override
    public QuotedFormula clone() {
        return new QuotedFalseFormula();
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public String toString() {
        return "false";
    }

    @Override
    public PropositionalFormula quoted2Prop(HashMap<LDLfFormula, String> LDLf2String, HashMap<String, LDLfFormula> String2LDLf) {
        return new Contradiction();
    }
}
