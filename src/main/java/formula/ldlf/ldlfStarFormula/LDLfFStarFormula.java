/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf.ldlfStarFormula;

import automaton.TransitionLabel;
import formula.ldlf.LDLfDiamondFormula;
import formula.quotedFormula.QuotedFalseFormula;
import formula.quotedFormula.QuotedFormula;
import formula.regExp.RegExpStar;

/**
 * Created by Riccardo De Masellis on 04/07/16.
 */
public class LDLfFStarFormula extends LDLfStarFormula {

    public LDLfFStarFormula(LDLfDiamondFormula diamondStarFormula) {
        if(diamondStarFormula==null || !(diamondStarFormula.getRegExp() instanceof RegExpStar))
            throw new RuntimeException("LDLfFStarFormula must have a diamond star formula as instance!");
        this.starFormula = diamondStarFormula;
    }

    public QuotedFormula delta(TransitionLabel label) {
        return new QuotedFalseFormula();
    }
}
