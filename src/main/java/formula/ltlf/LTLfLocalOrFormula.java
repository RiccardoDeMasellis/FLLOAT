/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.OrFormula;
import formula.ldlf.LDLfLocalFormula;
import formula.ldlf.LDLfLocalOrFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalOr;
import net.sf.tweety.logics.pl.syntax.Disjunction;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalOrFormula extends LTLfBinaryFormula implements LTLfBoolOpLocalFormula, OrFormula {

    public LTLfLocalOrFormula(LTLfFormula left, LTLfFormula right) {
        super(left, right);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_OR;
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        RegExpLocal left = ((LTLfLocalFormula) this.getLeftFormula()).toRegExpLocal();
        RegExpLocal right = ((LTLfLocalFormula) this.getRightFormula()).toRegExpLocal();
        return new RegExpLocalOr(left, right);
    }

    @Override
    public LDLfLocalFormula toLDLfLocal() {
        return new LDLfLocalOrFormula(((LTLfLocalFormula)this.getLeftFormula()).toLDLfLocal(),((LTLfLocalFormula)this.getRightFormula()).toLDLfLocal());
    }

    @Override
	public PropositionalFormula toTweetyProp(){
		LTLfLocalFormula left = (LTLfLocalFormula) this.getLeftFormula();
		LTLfLocalFormula right = (LTLfLocalFormula) this.getRightFormula();

		PropositionalFormula res = new Disjunction(left.toTweetyProp(), right.toTweetyProp());

		return res;
	}
}
