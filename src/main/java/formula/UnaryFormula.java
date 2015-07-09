/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface UnaryFormula extends Formula {

    Formula getNestedFormula();

    String stringOperator();

    default PropositionalSignature getSignature() {
        PropositionalSignature sig = new PropositionalSignature();
        this.getSignatureRic(sig);
        return sig;
    }

    default void getSignatureRic(PropositionalSignature sig) {
        this.getNestedFormula().getSignatureRic(sig);
    }
}
