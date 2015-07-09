/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public abstract class LocalVar implements LocalFormula, AtomicFormula {

    private Proposition prop;

    public LocalVar(Proposition prop) {
        this.prop = prop;
    }

    public Proposition getProp() {
        return prop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalVar propVar = (LocalVar) o;

        return !(getProp() != null ? !getProp().equals(propVar.getProp()) : propVar.getProp() != null);

    }

    @Override
    public int hashCode() {
        return getProp() != null ? getProp().hashCode() : 0;
    }

    public String toString() {
        return prop.toString();
    }

    public Formula clone() {
        return this.formulaFactory(this.getFormulaType(), null, null, this.getProp());
    }

    public PropositionalSignature getSignature() {
        PropositionalSignature sig = new PropositionalSignature();
        this.getSignatureRic(sig);
        return sig;
    }

    public void getSignatureRic(PropositionalSignature sig) {
        sig.add(this.getProp());
    }
}
