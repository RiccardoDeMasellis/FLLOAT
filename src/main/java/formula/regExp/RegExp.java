/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.TransitionLabel;
import formula.Formula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;
import utils.FormulaUtils;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExp extends Formula {

    QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label);

    QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label);

    // Transforms a regex rho into the equivalent LDLf <rho>end
    default LDLfFormula toLDLf() {
        return new LDLfDiamondFormula(this, FormulaUtils.generateLDLfEndedFormula());
    }
}
