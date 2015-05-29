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
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface Formula<S extends Symbol<?>> extends Cloneable {

    Object clone();

    boolean equals(Object o);

    int hashCode();

    String toString();

    Formula<S> nnf();

    Formula<S> negate();

    FormulaType getFormulaType();

    default Formula<S> formulaFactory(FormulaType type, Formula<S> left, Formula<S> right, S symbol) {
        switch (type) {
            case LTLf_WEAK_UNTIL:
                return new LTLfWeakUntilFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_WEAK_NEXT:
                return new LTLfWeakNextFormula<>((LTLfFormula<S>) left);
            case LTLf_UNTIL:
                return new LTLfUntilFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_TEMP_OR:
                return new LTLfTempOrFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_TEMP_NOT:
                return new LTLfTempNotFormula<>((LTLfFormula<S>) left);
            case LTLf_TEMP_IMPL:
                return new LTLfTempImplFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_TEMP_DOUBLEIMPL:
                return new LTLfTempDoubleImplFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_TEMP_AND:
                return new LTLfTempAndFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_RELEASE:
                return new LTLfReleaseFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_LOCAL_TRUE:
                return new LTLfLocalTrueFormula<>();
            case LTLf_LOCAL_OR:
                return new LTLfLocalOrFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_LOCAL_NOT:
                return new LTLfLocalNotFormula<>((LTLfFormula<S>) left);
            case LTLf_LOCAL_IMPL:
                return new LTLfLocalImplFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_LOCAL_FALSE:
                return new LTLfLocalFalseFormula<>();
            case LTLf_LOCAL_DOUBLEIMPL:
                return new LTLfLocalDoubleImplFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_LOCAL_AND:
                return new LTLfLocalAndFormula<>((LTLfFormula<S>) left, (LTLfFormula<S>) right);
            case LTLf_NEXT:
                return new LTLfNextFormula<>((LTLfFormula<S>) left);
            case LTLf_GLOBALLY:
                return new LTLfGloballyFormula<>((LTLfFormula<S>) left);
            case LTLf_EVENTUALLY:
                return new LTLfEventuallyFormula<>((LTLfFormula<S>) left);
            case LTLf_LOCAL_VAR:
                return new LTLfLocalVar<>(symbol);
            case LDLf_TEMP_OR:
                return new LDLfTempOrFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_TEMP_NOT:
                return new LDLfTempNotFormula<>((LDLfFormula<S>) left);
            case LDLf_TEMP_IMPL:
                return new LDLfTempImplFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_TEMP_DOUBLEIMPL:
                return new LDLfTempDoubleImplFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_TEMP_AND:
                return new LDLfTempAndFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_LOCAL_TRUE:
                return new LDLfLocalTrueFormula<>();
            case LDLf_LOCAL_OR:
                return new LDLfLocalOrFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_LOCAL_NOT:
                return new LDLfLocalNotFormula<>((LDLfFormula<S>) left);
            case LDLf_LOCAL_IMPL:
                return new LDLfLocalImplFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_LOCAL_FALSE:
                return new LDLfLocalFalseFormula<>();
            case LDLf_LOCAL_DOUBLEIMPL:
                return new LDLfLocalDoubleImplFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_LOCAL_AND:
                return new LDLfLocalAndFormula<>((LDLfFormula<S>) left, (LDLfFormula<S>) right);
            case LDLf_LOCAL_VAR:
                return new LDLfLocalVar<>(symbol);
            case LDLf_tt:
                return new LDLfttFormula<>();
            case LDLf_ff:
                return new LDLfffFormula<>();
            case LDLf_BOX:
                return new LDLfBoxFormula<>((RegExp<S>) left, (LDLfFormula<S>) right);
            case LDLf_DIAMOND:
                return new LDLfDiamondFormula<>((RegExp<S>) left, (LDLfFormula<S>) right);
            case RE_TEST:
                return new RegExpTest<>((LDLfFormula<S>) left);
            case RE_STAR:
                return new RegExpStar<>((RegExp<S>) left);
            case RE_LOCAL_VAR:
                return new RegExpLocalVar<>(symbol);
            case RE_LOCAL_TRUE:
                return new RegExpLocalTrue<>();
            case RE_LOCAL_OR:
                return new RegExpLocalOr<>((RegExp<S>) left, (RegExp<S>) right);
            case RE_LOCAL_NOT:
                return new RegExpLocalNot<>((RegExp<S>) left);
            case RE_LOCAL_IMPL:
                return new RegExpLocalImpl<>((RegExp<S>) left, (RegExp<S>) right);
            case RE_LOCAL_FALSE:
                return new RegExpLocalFalse<>();
            case RE_LOCAL_DOUBLEIMPL:
                return new RegExpLocalDoubleImpl<>((RegExp<S>) left, (RegExp<S>) right);
            case RE_LOCAL_AND:
                return new RegExpLocalAnd<>((RegExp<S>) left, (RegExp<S>) right);
            case RE_CONCAT:
                return new RegExpConcat<>((RegExp<S>) left, (RegExp<S>) right);
            case RE_ALTERN:
                return new RegExpAltern<>((RegExp<S>) left, (RegExp<S>) right);
            default:
                throw new RuntimeException();
        }
    }

}