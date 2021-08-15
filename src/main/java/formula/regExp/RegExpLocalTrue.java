/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.FormulaType;
import formula.TrueLocalFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.Tautology;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public class RegExpLocalTrue extends TrueLocalFormula implements RegExpLocal {

    public RegExpLocalTrue() {
        super();
    }

    @Override
    public RegExpLocalTrue nnf() {
        return (RegExpLocalTrue) this.clone();
    }

    @Override
    public RegExpLocalFalse negate() {
        return new RegExpLocalFalse();
    }

    @Override
    public FormulaType getFormulaType() {
        return FormulaType.RE_LOCAL_TRUE;
    }

    @Override
    public PropositionalFormula regExpLocal2Propositional() {
        return new Tautology();
    }
}