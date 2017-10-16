/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.TrueLocalFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalTrue;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.Tautology;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalTrueFormula extends TrueLocalFormula implements LDLfLocalFormula {
    public LDLfLocalTrueFormula() {
        super();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_TRUE;
    }

    @Override
    public LDLfFormula nnf() {
        return new LDLfLocalTrueFormula();
    }


    @Override
    public LDLfFormula negate() {
        return new LDLfLocalFalseFormula();
    }

    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        return new Tautology();
    }

    @Override
    public RegExpLocal LDLfLocal2RegExp() {
        return new RegExpLocalTrue();
    }

    @Override
    public LDLfFormula replaceStarFormulas() {
        return new LDLfLocalTrueFormula();
    }
}
