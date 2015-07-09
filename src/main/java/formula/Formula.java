/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula;

import formula.ldlf.*;
import formula.ltlf.*;
import formula.regExp.*;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface Formula extends Cloneable {

    Formula clone();

    boolean equals(Object o);

    int hashCode();

    String toString();

    Formula nnf();

    Formula negate();

    FormulaType getFormulaType();

    PropositionalSignature getSignature();

    void getSignatureRic(PropositionalSignature sig);

    default Formula formulaFactory(FormulaType type, Formula left, Formula right, Proposition prop) {
        switch (type) {
            case LTLf_WEAK_UNTIL:
                return new LTLfWeakUntilFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_WEAK_NEXT:
                return new LTLfWeakNextFormula((LTLfFormula) left);
            case LTLf_UNTIL:
                return new LTLfUntilFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_TEMP_OR:
                return new LTLfTempOrFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_TEMP_NOT:
                return new LTLfTempNotFormula((LTLfFormula) left);
            case LTLf_TEMP_IMPL:
                return new LTLfTempImplFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_TEMP_DOUBLEIMPL:
                return new LTLfTempDoubleImplFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_TEMP_AND:
                return new LTLfTempAndFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_RELEASE:
                return new LTLfReleaseFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_LOCAL_TRUE:
                return new LTLfLocalTrueFormula();
            case LTLf_LOCAL_OR:
                return new LTLfLocalOrFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_LOCAL_NOT:
                return new LTLfLocalNotFormula((LTLfFormula) left);
            case LTLf_LOCAL_IMPL:
                return new LTLfLocalImplFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_LOCAL_FALSE:
                return new LTLfLocalFalseFormula();
            case LTLf_LOCAL_DOUBLEIMPL:
                return new LTLfLocalDoubleImplFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_LOCAL_AND:
                return new LTLfLocalAndFormula((LTLfFormula) left, (LTLfFormula) right);
            case LTLf_NEXT:
                return new LTLfNextFormula((LTLfFormula) left);
            case LTLf_GLOBALLY:
                return new LTLfGloballyFormula((LTLfFormula) left);
            case LTLf_EVENTUALLY:
                return new LTLfEventuallyFormula((LTLfFormula) left);
            case LTLf_LOCAL_VAR:
                return new LTLfLocalVar(prop);
            case LDLf_TEMP_OR:
                return new LDLfTempOrFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_TEMP_NOT:
                return new LDLfTempNotFormula((LDLfFormula) left);
            case LDLf_TEMP_IMPL:
                return new LDLfTempImplFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_TEMP_DOUBLEIMPL:
                return new LDLfTempDoubleImplFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_TEMP_AND:
                return new LDLfTempAndFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_LOCAL_TRUE:
                return new LDLfLocalTrueFormula();
            case LDLf_LOCAL_OR:
                return new LDLfLocalOrFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_LOCAL_NOT:
                return new LDLfLocalNotFormula((LDLfFormula) left);
            case LDLf_LOCAL_IMPL:
                return new LDLfLocalImplFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_LOCAL_FALSE:
                return new LDLfLocalFalseFormula();
            case LDLf_LOCAL_DOUBLEIMPL:
                return new LDLfLocalDoubleImplFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_LOCAL_AND:
                return new LDLfLocalAndFormula((LDLfFormula) left, (LDLfFormula) right);
            case LDLf_LOCAL_VAR:
                return new LDLfLocalVar(prop);
            case LDLf_tt:
                return new LDLfttFormula();
            case LDLf_ff:
                return new LDLfffFormula();
            case LDLf_BOX:
                return new LDLfBoxFormula((RegExp) left, (LDLfFormula) right);
            case LDLf_DIAMOND:
                return new LDLfDiamondFormula((RegExp) left, (LDLfFormula) right);
            case RE_TEST:
                return new RegExpTest((LDLfFormula) left);
            case RE_STAR:
                return new RegExpStar((RegExp) left);
            case RE_LOCAL_VAR:
                return new RegExpLocalVar(prop);
            case RE_LOCAL_TRUE:
                return new RegExpLocalTrue();
            case RE_LOCAL_OR:
                return new RegExpLocalOr((RegExp) left, (RegExp) right);
            case RE_LOCAL_NOT:
                return new RegExpLocalNot((RegExp) left);
            case RE_LOCAL_IMPL:
                return new RegExpLocalImpl((RegExp) left, (RegExp) right);
            case RE_LOCAL_FALSE:
                return new RegExpLocalFalse();
            case RE_LOCAL_DOUBLEIMPL:
                return new RegExpLocalDoubleImpl((RegExp) left, (RegExp) right);
            case RE_LOCAL_AND:
                return new RegExpLocalAnd((RegExp) left, (RegExp) right);
            case RE_CONCAT:
                return new RegExpConcat((RegExp) left, (RegExp) right);
            case RE_ALTERN:
                return new RegExpAltern((RegExp) left, (RegExp) right);
            default:
                throw new RuntimeException();
        }
    }

}