/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.FormulaType;
import formula.ImplFormula;
import formula.regExp.RegExpLocal;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfLocalImplFormula extends LDLfBinaryFormula implements LDLfBoolOpLocalFormula, ImplFormula {
    public LDLfLocalImplFormula(LDLfFormula left, LDLfFormula right) {
        super(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_IMPL;
    }


    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        return ((LDLfLocalFormula) this.nnf()).LDLfLocal2Prop();
    }

    @Override
    public RegExpLocal LDLfLocal2RegExp() {
        return ((LDLfLocalFormula) this.nnf()).LDLfLocal2RegExp();
    }
}
