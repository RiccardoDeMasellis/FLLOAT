/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf.ldlfStarFormula;

import formula.ldlf.LDLfFormula;

/**
 * Created by Riccardo De Masellis on 04/07/16.
 */
public abstract class LDLfStarFormula implements LDLfFormula {
    LDLfFormula starFormula;

    public LDLfFormula getStarFormula() {
        return starFormula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LDLfStarFormula that = (LDLfStarFormula) o;

        return getStarFormula().equals(that.getStarFormula());
    }

    @Override
    public int hashCode() {
        return getStarFormula().hashCode();
    }

    public LDLfFormula replaceStarFormulas() {
        return (LDLfFormula) this.getStarFormula().clone();
    }
}
