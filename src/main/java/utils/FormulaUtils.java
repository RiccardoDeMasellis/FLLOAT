/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package utils;

import formula.ldlf.LDLfBoxFormula;
import formula.ldlf.LDLfFormula;
import formula.ldlf.LDLfffFormula;
import formula.quotedFormula.QuotedVar;
import formula.regExp.RegExpLocalTrue;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Riccardo De Masellis on 13/07/15.
 */
public class FormulaUtils {

    public static LDLfFormula generateLDLfEndedFormula() {
        return new LDLfBoxFormula(new RegExpLocalTrue(), new LDLfffFormula());
    }

    public static Set<Set<QuotedVar>> propModelsToMinModels(Set<PossibleWorld> propModels, HashMap<Proposition, QuotedVar> prop2QuotedVar) {
        Set<PossibleWorld> minimalPropModels = minimizeModels(propModels);
        Set<Set<QuotedVar>> minimalQuotedModels = new HashSet<>();
        for (PossibleWorld propWorld : minimalPropModels) {
            HashSet<QuotedVar> quotedWorld = new HashSet<>();
            for (Proposition prop : propWorld)
                quotedWorld.add(prop2QuotedVar.get(prop));
            minimalQuotedModels.add(quotedWorld);
        }
        return minimalQuotedModels;
    }

    public static Set<PossibleWorld> minimizeModels(Set<PossibleWorld> propModels) {
        HashSet<PossibleWorld> minimalModels = new HashSet<>();
        for (PossibleWorld pw : propModels) {
            PossibleWorld minimalWorld = pw;
            for (PossibleWorld pw2 : propModels) {
                if (minimalWorld.containsAll(pw2)) {
                    minimalWorld = pw2;
                }
            }
            minimalModels.add(minimalWorld);
        }
        return minimalModels;
    }
}
