/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package main;

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;

/**
 * Created by Riccardo De Masellis on 28/06/16.
 */
public class LTLfAutomatonResultWrapper extends AutomatonResultWrapper {
    private LTLfFormula ltlfFormula;

    public LTLfAutomatonResultWrapper(Automaton automaton, PropositionalSignature completeSignature, LDLfFormula ldLfFormula, LTLfFormula ltlfFormula) {
        super(automaton, completeSignature, ldLfFormula);
        this.ltlfFormula = ltlfFormula;
    }

    public LTLfFormula getLtlfFormula() {
        return ltlfFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LTLfAutomatonResultWrapper that = (LTLfAutomatonResultWrapper) o;

        return getLtlfFormula().equals(that.getLtlfFormula());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getLtlfFormula().hashCode();
        return result;
    }
}
