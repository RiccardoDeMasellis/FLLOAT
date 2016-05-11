/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.TransitionLabel;
import auxiliaries.DeltaCallContext;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;

import java.util.Set;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpConcat extends RegExpBinary implements RegExpTemp {

    public RegExpConcat(RegExp left, RegExp right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return ";";
    }

    @Override
    public RegExpConcat nnf() {
        return new RegExpConcat((RegExp) this.getLeftFormula().nnf(), (RegExp) this.getRightFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpConcat");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_CONCAT;
    }


    @Override
    public QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label, Set<DeltaCallContext> previousCalls) {
        LDLfDiamondFormula nestedLdlf = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula outer = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), nestedLdlf);

        return outer.delta(label, previousCalls);
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label, Set<DeltaCallContext> previousCalls) {
        LDLfBoxFormula nestedLdlf = new LDLfBoxFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());
        LDLfBoxFormula outer = new LDLfBoxFormula((RegExp) this.getLeftFormula().clone(), nestedLdlf);

        return outer.delta(label, previousCalls);
    }
}
