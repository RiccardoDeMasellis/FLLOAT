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
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExp extends Formula {

    QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label);

    QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label);

    Automaton buildAutomatonDiamond(LDLfFormula goal, PropositionalSignature ps);
    Automaton buildAutomatonForEmptyTraceDiamond(LDLfFormula goal, PropositionalSignature ps);

    Automaton buildAutomatonBox(LDLfFormula goal, PropositionalSignature ps);
    Automaton buildAutomatonForEmptyTraceBox(LDLfFormula goal, PropositionalSignature ps);
}
