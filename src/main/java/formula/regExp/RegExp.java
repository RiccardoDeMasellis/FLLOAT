/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.Formula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExp extends Formula {

    QuotedFormula deltaDiamond(LDLfFormula goal, PossibleWorld world);

    QuotedFormula deltaBox(LDLfFormula goal, PossibleWorld world);
}
