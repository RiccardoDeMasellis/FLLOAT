/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.TransitionLabel;
import formula.Formula;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.ldlfStarFormula.LDLfFStarFormula;
import formula.ldlf.ldlfStarFormula.LDLfTStarFormula;
import formula.quotedFormula.QuotedAndFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedOrFormula;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpStar extends RegExpUnary implements RegExpTemp {

    public RegExpStar(RegExp nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "*";
    }

    @Override
    public Formula nnf() {
        return new RegExpStar((RegExp) this.getNestedFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpStar");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_STAR;
    }

    @Override
    public QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label) {
        LDLfDiamondFormula caller = new LDLfDiamondFormula(this, goal);
        LDLfFStarFormula starFFormula = new LDLfFStarFormula((LDLfDiamondFormula) caller.clone());

        LDLfDiamondFormula outer = new LDLfDiamondFormula((RegExp) this.getNestedFormula().clone(), starFFormula);

        return new QuotedOrFormula(((LDLfFormula) goal.clone()).delta(label), outer.delta(label));
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        LDLfBoxFormula caller = new LDLfBoxFormula(this, goal);
        LDLfTStarFormula starTFormula = new LDLfTStarFormula((LDLfBoxFormula) caller.clone());

        LDLfBoxFormula outer = new LDLfBoxFormula((RegExp) this.getNestedFormula().clone(), starTFormula);

        return new QuotedAndFormula(((LDLfFormula) goal.clone()).delta(label), outer.delta(label));
    }
}
