/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf.ldlfStarFormula;

import automaton.TransitionLabel;
import formula.ldlf.LDLfBoxFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedTrueFormula;
import formula.regExp.RegExpStar;

/**
 * Created by Riccardo De Masellis on 04/07/16.
 */
public class LDLfTStarFormula extends LDLfStarFormula {

    public LDLfTStarFormula(LDLfBoxFormula boxStarFormula) {
        if (boxStarFormula==null || !(boxStarFormula.getRegExp() instanceof RegExpStar))
            throw new RuntimeException("LDLfTStarFormula must have a box star formula as instance!");
        this.starFormula = boxStarFormula;
    }

    public LDLfTStarFormula clone() {
        return new LDLfTStarFormula((LDLfBoxFormula) this.getStarFormula().clone());
    }

    @Override
    public String toString() {
        return "T_{" + this.getStarFormula().toString() +"}";
    }

    public QuotedFormula delta(TransitionLabel label) {
        return new QuotedTrueFormula();
    }
}
