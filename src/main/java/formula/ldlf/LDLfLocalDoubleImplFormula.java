/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.DoubleImplFormula;
import formula.FormulaType;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalDoubleImplFormula extends LDLfBinaryFormula implements LDLfBoolOpLocalFormula, DoubleImplFormula {
    public LDLfLocalDoubleImplFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_DOUBLEIMPL;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && this.getClass().equals(o.getClass())) {
            LDLfLocalDoubleImplFormula other = (LDLfLocalDoubleImplFormula) o;
            return (this.getLeftFormula().equals(other.getLeftFormula()) && this.getRightFormula().equals(other.getRightFormula()))
                    ||
                    (this.getLeftFormula().equals(other.getRightFormula()) && this.getRightFormula().equals(other.getLeftFormula()));
        }
        return false;
    }

    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        return ((LDLfLocalFormula) this.nnf()).LDLfLocal2Prop();
    }
}
