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
public class RegExpTest extends RegExpUnary implements RegExpTemp {

    public RegExpTest(LDLfFormula nestedFormula) {
        super(nestedFormula);
    }

    @Override
    public String stringOperator() {
        return "?";
    }

    @Override
    public RegExp nnf() {
        return new RegExpTest((LDLfFormula) this.getNestedFormula().nnf());
    }

    // NOOP
    @Override
    public RegExpTest negate() {
        throw new RuntimeException("Method negate() should not be called on RegExpTest");
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_TEST;
    }


    @Override
    public QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label) {
        QuotedVar quotedLeft = new QuotedVar((LDLfFormula) this.getNestedFormula().clone());
        QuotedVar quotedRight = new QuotedVar((LDLfFormula) goal.clone());

        return new QuotedAndFormula(quotedLeft.delta(label), quotedRight.delta(label));
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label) {
        LDLfFormula left = (LDLfFormula) this.getNestedFormula().negate().nnf();

        QuotedVar quotedLeft = new QuotedVar(left);
        QuotedVar quotedRight = new QuotedVar((LDLfFormula) goal.clone());

        return new QuotedOrFormula(quotedLeft.delta(label), quotedRight.delta(label));
    }

    @Override
    public Automaton buildAutomatonDiamond(LDLfFormula goal, PropositionalSignature ps) {
        LDLfFormula nested = (LDLfFormula)this.getNestedFormula();
        Automaton a1 = nested.buildAutomaton(ps);

        Automaton a2 = goal.buildAutomaton(ps);
        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceDiamond(LDLfFormula goal, PropositionalSignature ps) {
        LDLfFormula nested = (LDLfFormula)this.getNestedFormula();
        Automaton a1 = nested.buildAutomatonForEmptyTrace(ps);

        Automaton a2 = goal.buildAutomatonForEmptyTrace(ps);

        Automaton result = new Mix<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonBox(LDLfFormula goal, PropositionalSignature ps) {
        LDLfFormula nnfNegatedNested = (LDLfFormula)this.getNestedFormula().negate().nnf();
        Automaton a1 = nnfNegatedNested.buildAutomaton(ps);

        Automaton a2 = goal.buildAutomaton(ps);

        Automaton result = new Union<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }

    @Override
    public Automaton buildAutomatonForEmptyTraceBox(LDLfFormula goal, PropositionalSignature ps) {
        LDLfFormula nnfNegatedNested = (LDLfFormula)this.getNestedFormula().negate().nnf();
        Automaton a1 = nnfNegatedNested.buildAutomatonForEmptyTrace(ps);

        Automaton a2 = goal.buildAutomatonForEmptyTrace(ps);

        Automaton result = new Union<>().transform(a1, a2);
        return new Reducer<>().transform(result);
    }
}
