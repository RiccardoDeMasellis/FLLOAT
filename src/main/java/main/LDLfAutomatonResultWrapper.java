/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import formula.ldlf.LDLfFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;

/**
 * Created by Riccardo De Masellis on 28/06/16.
 */
public class LDLfAutomatonResultWrapper extends AutomatonResultWrapper {
    public LDLfAutomatonResultWrapper(Automaton automaton, PropositionalSignature completeSignature, LDLfFormula ldLfFormula) {
        super(automaton, completeSignature, ldLfFormula);
    }
}
