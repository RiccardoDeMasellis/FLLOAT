/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.LocalFormula;
import formula.LocalFormulaType;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfLocalFormula;
import formula.ldlf.LDLfttFormula;
import formula.regExp.RegExpLocal;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfLocalFormula extends LocalFormula, LTLfFormula {

	PropositionalFormula toTweetyProp();

    RegExpLocal toRegExpLocal();

    LDLfLocalFormula toLDLfLocal();

    // Used with reflection in LocalVisitor, do not erase.
    static LTLfLocalFormula localFormulaFactory(LocalFormulaType formulaType, LTLfLocalFormula left, LTLfLocalFormula right, Proposition prop) {
        switch (formulaType) {
            case PROP_AND:
                return new LTLfLocalAndFormula(left, right);
            case PROP_DOUBLEIMPL:
                return new LTLfLocalDoubleImplFormula(left, right);
            case PROP_IMPL:
                return new LTLfLocalImplFormula(left, right);
            case PROP_NOT:
                return new LTLfLocalNotFormula(left);
            case PROP_OR:
                return new LTLfLocalOrFormula(left, right);
            case PROP_VAR:
                return new LTLfLocalVar(prop);
            case PROP_TRUE:
                return new LTLfLocalTrueFormula();
            case PROP_FALSE:
                return new LTLfLocalFalseFormula();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LTLfLocalFormula.propFormulaFactory not found.");
        }
    }

//    @Override
//    default LDLfFormula toLDLf() {
//        RegExpTest retest = new RegExpTest(this.toLDLfLocal());
//        return new LDLfDiamondFormula(retest, new LDLfttFormula());
//    }

    default LDLfFormula toLDLf() {
        return new LDLfDiamondFormula(((LTLfLocalFormula)this.nnf()).toRegExpLocal(), new LDLfttFormula());
    }

}
