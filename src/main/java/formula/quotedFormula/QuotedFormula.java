/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.quotedFormula;

import automaton.TransitionLabel;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Riccardo De Masellis on 08/06/15.
 */
public abstract class QuotedFormula implements Cloneable {

    public abstract PropositionalFormula quoted2Prop(HashMap<QuotedVar, Proposition> quotedVar2Prop, HashMap<Proposition, QuotedVar> prop2QuotedVar);

    public abstract QuotedFormula clone();

    public abstract boolean equals(Object o);

    public abstract String toString();

    public abstract int hashCode();

    public abstract QuotedFormula delta(TransitionLabel label);

    public Set<Set<QuotedVar>> getMinimalModels() {
        HashMap<QuotedVar, Proposition> quotedVar2Prop = new HashMap<>();
        HashMap<Proposition, QuotedVar> prop2QuotedVar = new HashMap<>();
        PropositionalFormula pf = this.quoted2Prop(quotedVar2Prop, prop2QuotedVar);
        Set<PossibleWorld> models = pf.getModels();
        return utils.FormulaUtils.propModelsToMinModels(models, prop2QuotedVar);
    }
}
