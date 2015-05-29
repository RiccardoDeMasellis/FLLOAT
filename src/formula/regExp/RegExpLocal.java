/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.regExp;

import formula.LocalFormula;
import formula.LocalFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpLocal<S extends Symbol<?>> extends RegExp<S>, LocalFormula<S> {

    static <S extends Symbol<?>> RegExpLocal<S> localFormulaFactory(LocalFormulaType formulaType, RegExpLocal<S> left, RegExpLocal<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new RegExpLocalAnd<>(left, right);
            case PROP_DOUBLEIMPL:
                return new RegExpLocalDoubleImpl<>(left, right);
            case PROP_IMPL:
                return new RegExpLocalImpl<>(left, right);
            case PROP_NOT:
                return new RegExpLocalNot<>(left);
            case PROP_OR:
                return new RegExpLocalOr<>(left, right);
            case PROP_VAR:
                return new RegExpLocalVar<>(symbol);
            case PROP_TRUE:
                return new RegExpLocalTrue<>();
            case PROP_FALSE:
                return new RegExpLocalFalse<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in RegExpLocal.propFormulaFactory not found.");
        }
    }

}
