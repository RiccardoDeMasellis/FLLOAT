/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FalseLocalFormula;
import formula.FormulaType;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalFalse;
import net.sf.tweety.logics.pl.syntax.Contradiction;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalFalseFormula extends FalseLocalFormula implements LDLfLocalFormula {
    public LDLfLocalFalseFormula() {
        super();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_FALSE;
    }

    @Override
    public LDLfFormula nnf() {
        return new LDLfLocalFalseFormula();
    }


    @Override
    public LDLfFormula negate() {
        return new LDLfLocalTrueFormula();
    }

    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        return new Contradiction();
    }

    @Override
    public RegExpLocal LDLfLocal2RegExp() {
        return new RegExpLocalFalse();
    }

    @Override
    public LDLfFormula replaceStarFormulas() {
        return new LDLfLocalFalseFormula();
    }
}
