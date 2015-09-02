/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FalseLocalFormula;
import formula.FormulaType;
import formula.ldlf.LDLfLocalFalseFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalFalse;
import net.sf.tweety.logics.pl.syntax.Contradiction;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalFalseFormula extends FalseLocalFormula implements LTLfLocalFormula {

    public LTLfLocalFalseFormula() {
        super();
    }

    @Override
    public LTLfFormula nnf() {
        return new LTLfLocalFalseFormula();
    }


    @Override
    public LTLfFormula negate() {
        return new LTLfLocalTrueFormula();
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_FALSE;
    }

    @Override
    public LDLfLocalFalseFormula toLDLf() {
        return new LDLfLocalFalseFormula();
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        return new RegExpLocalFalse();
    }

	@Override
	public PropositionalFormula toTweetyProp(){
		return new Contradiction();
	}
}
