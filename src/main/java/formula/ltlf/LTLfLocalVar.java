/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.LocalVar;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfLocalVar;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalVar;
import net.sf.tweety.logics.pl.syntax.Proposition;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalVar extends LocalVar implements LTLfLocalFormula {

    public LTLfLocalVar(Proposition prop) {
        super(prop);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_VAR;
    }


    @Override
    public LTLfFormula negate() {
        return new LTLfLocalNotFormula((LTLfFormula) this.clone());
    }

    @Override
    public LTLfFormula nnf() {
        return (LTLfFormula) this.clone();
    }

    @Override
    public LDLfFormula toLDLf() {
        return new LDLfLocalVar(this.getProp());
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        return new RegExpLocalVar(this.getProp());
    }
}
