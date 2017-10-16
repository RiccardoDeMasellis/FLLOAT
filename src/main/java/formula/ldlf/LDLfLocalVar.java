/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.LocalVar;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalVar;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalVar extends LocalVar implements LDLfLocalFormula {

    public LDLfLocalVar(Proposition prop) {
        super(prop);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_VAR;
    }

    @Override
    public LDLfFormula negate() {
        return new LDLfLocalNotFormula((LDLfFormula) this.clone());
    }

    @Override
    public LDLfFormula nnf() {
        return (LDLfFormula) this.clone();
    }

    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        return this.getProp().clone();
    }

    @Override
    public RegExpLocal LDLfLocal2RegExp() {
        return new RegExpLocalVar(this.getProp().clone());
    }

    public LDLfFormula replaceStarFormulas() {
        return (LDLfLocalVar) this.clone();
    }
}
