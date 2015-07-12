/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.AndFormula;
import formula.FormulaType;
import net.sf.tweety.logics.pl.syntax.Conjunction;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalAnd extends RegExpBinary implements RegExpBoolOpLocal, AndFormula {
    public RegExpLocalAnd(RegExp left, RegExp right) {
        super(left, right);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_AND;
    }

    @Override
    public PropositionalFormula regExpLocal2Propositional() {
        PropositionalFormula left = ((RegExpLocal) this.getLeftFormula()).regExpLocal2Propositional();
        PropositionalFormula right = ((RegExpLocal) this.getRightFormula()).regExpLocal2Propositional();
        return new Conjunction(left, right);
    }
}
