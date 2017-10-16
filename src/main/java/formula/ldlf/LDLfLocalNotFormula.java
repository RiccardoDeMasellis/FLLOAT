/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

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
public class LDLfLocalNotFormula extends LDLfUnaryFormula implements LDLfBoolOpLocalFormula, NotFormula {
    public LDLfLocalNotFormula(LDLfFormula nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_LOCAL_NOT;
    }

    @Override
    public PropositionalFormula LDLfLocal2Prop() {
        PropositionalFormula nested = ((LDLfLocalFormula) this.getNestedFormula()).LDLfLocal2Prop();
        return new Negation(nested);
    }

    @Override
    public RegExpLocal LDLfLocal2RegExp() {
        RegExpLocal nested = ((LDLfLocalFormula) this.getNestedFormula()).LDLfLocal2RegExp();
        return new RegExpLocalNot(nested);
    }
}
