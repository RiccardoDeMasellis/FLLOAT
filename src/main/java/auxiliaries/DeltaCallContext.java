/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package auxiliaries;

import automaton.TransitionLabel;
import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 11/05/16.
 */
public class DeltaCallContext {

    private LDLfFormula formula;
    private TransitionLabel label;

    public DeltaCallContext(LDLfFormula formula, TransitionLabel label) {
        this.formula = formula;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeltaCallContext that = (DeltaCallContext) o;

        if (!formula.equals(that.formula)) return false;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        int result = formula.hashCode();
        result = 31 * result + label.hashCode();
        return result;
    }
}
