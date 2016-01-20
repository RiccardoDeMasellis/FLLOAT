/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.FormulaType;
import formula.NotFormula;
import formula.regExp.RegExpLocal;
import formula.regExp.RegExpLocalNot;
import net.sf.tweety.logics.pl.syntax.Negation;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LTLfLocalNotFormula extends LTLfUnaryFormula implements LTLfBoolOpLocalFormula, NotFormula {

    public LTLfLocalNotFormula(LTLfFormula nestedFormula) {
        super(nestedFormula);
    }

    public FormulaType getFormulaType() {
        return FormulaType.LTLf_LOCAL_NOT;
    }

    @Override
    public RegExpLocal toRegExpLocal() {
        return new RegExpLocalNot(((LTLfLocalFormula) this.getNestedFormula()).toRegExpLocal());
    }

	@Override
	public PropositionalFormula toTweetyProp(){
		LTLfLocalFormula nested = (LTLfLocalFormula) this.getNestedFormula();

		PropositionalFormula res = new Negation(nested.toTweetyProp());

		return res;
	}
}
