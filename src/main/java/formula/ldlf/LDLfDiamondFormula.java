/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import automaton.TransitionLabel;
import formula.FormulaType;
import formula.quotedFormula.QuotedFormula;
import formula.regExp.RegExp;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class LDLfDiamondFormula extends LDLfTempOpTempFormula {

    public LDLfDiamondFormula(RegExp regExp, LDLfFormula goalFormula) {
        super(regExp, goalFormula);
    }

    public String toString() {
        return "<" + this.getRegExp() + ">" + "(" + this.getGoalFormula() + ")";
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.LDLf_DIAMOND;
    }

    @Override
    public LDLfFormula nnf() {
        return new LDLfDiamondFormula((RegExp) this.getRegExp().nnf(), (LDLfFormula) this.getGoalFormula().nnf());
    }

    @Override
    public LDLfFormula negate() {
        return new LDLfBoxFormula((RegExp) this.getRegExp().clone(), (LDLfFormula) this.getGoalFormula().negate());
    }

    public PropositionalSignature getSignature() {
        PropositionalSignature sig = new PropositionalSignature();
        this.getSignatureRic(sig);
        return sig;
    }

    public void getSignatureRic(PropositionalSignature sig) {
        this.getGoalFormula().getSignatureRic(sig);
        this.getRegExp().getSignatureRic(sig);
    }

    @Override
    public QuotedFormula delta(TransitionLabel label) {
        return this.getRegExp().deltaDiamond(this.getGoalFormula(), label);
    }

    @Override
    public Automaton buildAutomaton(PropositionalSignature ps) {
        return this.getRegExp().buildAutomatonDiamond(this.getGoalFormula(), ps);
    }

    @Override
    public Automaton buildAutomatonForEmptyTrace(PropositionalSignature ps) {
        return this.getRegExp().buildAutomatonForEmptyTraceDiamond(this.getGoalFormula(), ps);
    }
}