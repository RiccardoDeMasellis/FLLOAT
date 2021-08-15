/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FormulaType;
import formula.LocalVar;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalVar extends LocalVar implements RegExpLocal {

    public RegExpLocalVar(Proposition prop) {
        super(prop);
    }

    @Override
    public RegExpLocalVar nnf() {
        return (RegExpLocalVar) this.clone();
    }

    @Override
    public RegExpLocalNot negate() {
        return new RegExpLocalNot((RegExpLocalVar) this.clone());
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_VAR;
    }

    @Override
    public PropositionalFormula regExpLocal2Propositional() {
        return this.getProp().clone();
    }
}
