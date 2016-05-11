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
import auxiliaries.DeltaCallContext;
import formula.Formula;
import formula.FormulaType;
import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfDiamondFormula;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.*;

import java.util.HashSet;
import java.util.Set;

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
    public QuotedFormula deltaDiamond(LDLfFormula goal, TransitionLabel label, Set<DeltaCallContext> previousCalls) {
        /*
           To see if I reached a fixpoint, I check if I already expanded the same formula IN THE SAME BRANCH
        */
        // First of all, I re-build the formula that caused this recursive call:
        LDLfDiamondFormula caller = new LDLfDiamondFormula(this, goal);
        DeltaCallContext callContext = new DeltaCallContext(caller, label);

        if (previousCalls.contains(callContext)) {
            // I am expanding a diamond formula, so if I reached a fixpoint is bad!
            return new QuotedFalseFormula();
        }

        else {

            /*
             Add the formula that caused this recursive call to the visited set but CLONE IT before! So not to
             side-effect the data structure on other branches of the recursive call tree.
             */
            Set<DeltaCallContext> newCalls = new HashSet<>();
            newCalls.addAll(previousCalls);
            newCalls.add(callContext);

            if (label instanceof EmptyTrace) {
                return ((LDLfFormula) goal.clone()).delta(label, newCalls);
            }

            if (this.getNestedFormula() instanceof RegExpTest) {
                return ((LDLfFormula) goal.clone()).delta(label, newCalls);
            }

            else {
                LDLfDiamondFormula inner = new LDLfDiamondFormula(this.clone(), (LDLfFormula) goal.clone());
                LDLfDiamondFormula outer = new LDLfDiamondFormula((RegExp) this.getNestedFormula().clone(), inner);

                LDLfFormula left = (LDLfFormula) goal.clone();

                return new QuotedOrFormula(left.delta(label, previousCalls), outer.delta(label, newCalls));
            }
        }
    }

    @Override
    public QuotedFormula deltaBox(LDLfFormula goal, TransitionLabel label, Set<DeltaCallContext> previousCalls) {
        /*
           To see if I reached a fixpoint, I check if I already expanded the same formula IN THE SAME BRANCH
        */
        // First of all, I re-build the formula that caused this recursive call:
        LDLfBoxFormula caller = new LDLfBoxFormula(this, goal);
        DeltaCallContext callContext = new DeltaCallContext(caller, label);

        if (previousCalls.contains(callContext)) {
            // I am expanding a box formula, so if I reached a fixpoint is good!
            return new QuotedTrueFormula();
        }

        else {

            /*
             Add the formula that caused this recursive call to the visited set but CLONE IT before! So not to
             side-effect the data structure on other branches of the recursive call tree.
             */
            Set<DeltaCallContext> newCalls = new HashSet<>();
            newCalls.addAll(previousCalls);
            newCalls.add(callContext);

            if (label instanceof EmptyTrace) {
                return ((LDLfFormula) goal.clone()).delta(label, newCalls);
            }

            if (this.getNestedFormula() instanceof RegExpTest) {
                return ((LDLfFormula) goal.clone()).delta(label, newCalls);


            }
            else {
                LDLfBoxFormula inner = new LDLfBoxFormula(this.clone(), (LDLfFormula) goal.clone());
                LDLfBoxFormula outer = new LDLfBoxFormula((RegExp) this.getNestedFormula().clone(), inner);

                LDLfFormula left = (LDLfFormula) goal.clone();

                return new QuotedAndFormula(left.delta(label, previousCalls), outer.delta(label, newCalls));
            }
        }
    }
}
