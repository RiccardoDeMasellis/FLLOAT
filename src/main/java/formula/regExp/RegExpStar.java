/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import evaluations.EmptyTrace;
import formula.Formula;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedAndFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedOrFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;

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
    public QuotedFormula deltaDiamond(LDLfFormula goal, PossibleWorld world) {
        if (world instanceof EmptyTrace) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(world);
        }

        if (this.getNestedFormula() instanceof RegExpTest) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(world);
        } else {
            LDLfDiamondFormula inner = new LDLfDiamondFormula(this.clone(), (LDLfFormula) goal.clone());
            LDLfDiamondFormula outer = new LDLfDiamondFormula((RegExp) this.getNestedFormula().clone(), inner);

            QuotedFormula quotedLeft = new QuotedVar((LDLfFormula) goal.clone());
            QuotedFormula quotedRight = new QuotedVar(outer);

            return new QuotedOrFormula(quotedLeft.delta(world), quotedRight.delta(world));
        }
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, PossibleWorld world) {
        if (world instanceof EmptyTrace) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(world);
        }

        if (this.getNestedFormula() instanceof RegExpTest) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(world);
        } else {
            LDLfBoxFormula inner = new LDLfBoxFormula(this.clone(), (LDLfFormula) goal.clone());
            LDLfBoxFormula outer = new LDLfBoxFormula((RegExp) this.getNestedFormula().clone(), inner);

            QuotedFormula quotedLeft = new QuotedVar((LDLfFormula) goal.clone());
            QuotedFormula quotedRight = new QuotedVar(outer);

            return new QuotedAndFormula(quotedLeft.delta(world), quotedRight.delta(world));
        }
    }
}
