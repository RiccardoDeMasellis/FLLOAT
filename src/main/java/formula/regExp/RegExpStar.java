/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import automaton.EmptyTrace;
import automaton.TransitionLabel;
import formula.Formula;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedAndFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedOrFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.transformations.Mix;
import rationals.transformations.Reducer;
import rationals.transformations.Star;
import rationals.transformations.Union;

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
        if (label instanceof EmptyTrace) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(label);
        }

        if (this.getNestedFormula() instanceof RegExpTest) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(label);
        } else {
            LDLfDiamondFormula inner = new LDLfDiamondFormula(this.clone(), (LDLfFormula) goal.clone());
            LDLfDiamondFormula outer = new LDLfDiamondFormula((RegExp) this.getNestedFormula().clone(), inner);

            QuotedFormula quotedLeft = new QuotedVar((LDLfFormula) goal.clone());
            QuotedFormula quotedRight = new QuotedVar(outer);

            return new QuotedOrFormula(quotedLeft.delta(label), quotedRight.delta(label));
        }
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        if (label instanceof EmptyTrace) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(label);
        }

        if (this.getNestedFormula() instanceof RegExpTest) {
            QuotedVar quoted = new QuotedVar((LDLfFormula) goal.clone());
            return quoted.delta(label);
        } else {
            LDLfBoxFormula inner = new LDLfBoxFormula(this.clone(), (LDLfFormula) goal.clone());
            LDLfBoxFormula outer = new LDLfBoxFormula((RegExp) this.getNestedFormula().clone(), inner);

            QuotedFormula quotedLeft = new QuotedVar((LDLfFormula) goal.clone());
            QuotedFormula quotedRight = new QuotedVar(outer);

            return new QuotedAndFormula(quotedLeft.delta(label), quotedRight.delta(label));
        }
    }

    /*
    CHECK CHECK CHECK
     */
    @Override
    public Automaton buildAutomatonDiamond(LDLfFormula goal, PropositionalSignature ps) {
        if (this.getNestedFormula() instanceof RegExpTest)
            return goal.buildAutomaton(ps);
        else {
            LDLfDiamondFormula f = new LDLfDiamondFormula((RegExp) this.getNestedFormula().clone(), goal);

            Automaton a1 = goal.buildAutomaton(ps);
            Automaton a2 = f.buildAutomaton(ps);
            Automaton result = new Union<>().transform(a1, a2);
            result = new Reducer<>().transform(result);
            result = new Star<>().transform(result);
            return new Reducer<>().transform(result);
        }
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceDiamond(LDLfFormula goal, PropositionalSignature ps) {
        return goal.buildAutomaton(ps);
    }

    /*
    CHECK CHECK CHECK
     */
    @Override
    public Automaton buildAutomatonBox(LDLfFormula goal, PropositionalSignature ps) {
        if (this.getNestedFormula() instanceof RegExpTest)
            return goal.buildAutomaton(ps);
        else {
            LDLfBoxFormula f = new LDLfBoxFormula((RegExp) this.getNestedFormula().clone(), goal);

            Automaton a1 = goal.buildAutomaton(ps);
            Automaton a2 = f.buildAutomaton(ps);
            Automaton result = new Mix<>().transform(a1, a2);
            result = new Reducer<>().transform(result);
            result = new Star<>().transform(result);
            return new Reducer<>().transform(result);
        }
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceBox(LDLfFormula goal, PropositionalSignature ps) {
        return goal.buildAutomaton(ps);
    }
}
