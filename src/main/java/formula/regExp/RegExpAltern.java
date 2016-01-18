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
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.transformations.Mix;
import rationals.transformations.Reducer;
import rationals.transformations.Union;

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

        QuotedVar quotedLeft = new QuotedVar(ldlfLeft);
        QuotedFormula quotedRight = new QuotedVar(ldlfRight);

        return new QuotedOrFormula(quotedLeft.delta(label), quotedRight.delta(label));
    }


    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        LDLfBoxFormula ldlfLeft = new LDLfBoxFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfBoxFormula ldlfRight = new LDLfBoxFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        QuotedVar quotedLeft = new QuotedVar(ldlfLeft);
        QuotedFormula quotedRight = new QuotedVar(ldlfRight);

        return new QuotedAndFormula(quotedLeft.delta(label), quotedRight.delta(label));
    }

    @Override
    public Automaton buildAutomatonDiamond(LDLfFormula goal, PropositionalSignature ps) {
        LDLfDiamondFormula ldlfLeft = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula ldlfRight = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        Automaton a1 = ldlfLeft.buildAutomaton(ps);
        Automaton a2 = ldlfRight.buildAutomaton(ps);
        Automaton result = new Union<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceDiamond(LDLfFormula goal, PropositionalSignature ps) {
        LDLfDiamondFormula ldlfLeft = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula ldlfRight = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        Automaton a1 = ldlfLeft.buildAutomatonForEmptyTrace(ps);
        Automaton a2 = ldlfRight.buildAutomatonForEmptyTrace(ps);
        Automaton result = new Union<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonBox(LDLfFormula goal, PropositionalSignature ps) {
        LDLfDiamondFormula ldlfLeft = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula ldlfRight = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        Automaton a1 = ldlfLeft.buildAutomaton(ps);
        Automaton a2 = ldlfRight.buildAutomaton(ps);
        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceBox(LDLfFormula goal, PropositionalSignature ps) {
        LDLfDiamondFormula ldlfLeft = new LDLfDiamondFormula((RegExp) this.getLeftFormula().clone(), (LDLfFormula) goal.clone());
        LDLfDiamondFormula ldlfRight = new LDLfDiamondFormula((RegExp) this.getRightFormula().clone(), (LDLfFormula) goal.clone());

        Automaton a1 = ldlfLeft.buildAutomatonForEmptyTrace(ps);
        Automaton a2 = ldlfRight.buildAutomatonForEmptyTrace(ps);
        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }
}
