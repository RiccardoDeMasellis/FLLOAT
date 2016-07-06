/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.TransitionLabel;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedAndFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpAltern extends RegExpBinary implements RegExpTemp {

    public RegExpAltern(RegExp left, RegExp right) {
        super(left, right);
    }

    @Override
    public String stringOperator() {
        return "+";
    }

    @Override
    public RegExpAltern nnf() {
        return new RegExpAltern((RegExp) this.getLeftFormula().nnf(), (RegExp) this.getRightFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpAltern");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_ALTERN;
    }


    public QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label) {
        LDLfDiamondFormula ldlfLeft = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula ldlfRight = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        return new QuotedOrFormula(ldlfLeft.delta(label), ldlfRight.delta(label));
    }


    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        LDLfBoxFormula ldlfLeft = new LDLfBoxFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfBoxFormula ldlfRight = new LDLfBoxFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        return new QuotedAndFormula(ldlfLeft.delta(label), ldlfRight.delta(label));
    }
}
