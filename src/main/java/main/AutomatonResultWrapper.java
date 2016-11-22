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
 * Created by Riccardo De Masellis on 27/06/16.
 *
 * This class is used to wrap all the objects returned by the Main.ldlfString2Aut or Main.ltlfString2Aut.
 * WARNING! If it is the result of Main.ldlfString2Aut, the instance ltlfFormula is null!
 */
public abstract class AutomatonResultWrapper {
    private Automaton automaton;
    private PropositionalSignature completeSignature;
    private LDLfFormula ldLfFormula;


    public AutomatonResultWrapper(Automaton automaton, PropositionalSignature completeSignature, LDLfFormula ldLfFormula) {
        this.automaton = automaton;
        this.completeSignature = completeSignature;
        this.ldLfFormula = ldLfFormula;
    }

    public Automaton getAutomaton() {
        return automaton;
    }

    public PropositionalSignature getCompleteSignature() {
        return completeSignature;
    }

    public LDLfFormula getLdLfFormula() {
        return ldLfFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutomatonResultWrapper that = (AutomatonResultWrapper) o;

        if (!getAutomaton().equals(that.getAutomaton())) return false;
        if (!getCompleteSignature().equals(that.getCompleteSignature())) return false;
        return getLdLfFormula().equals(that.getLdLfFormula());

    }

    @Override
    public int hashCode() {
        int result = getAutomaton().hashCode();
        result = 31 * result + getCompleteSignature().hashCode();
        result = 31 * result + getLdLfFormula().hashCode();
        return result;
    }
}
