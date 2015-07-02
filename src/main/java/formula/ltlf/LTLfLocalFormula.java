/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ltlf;

import formula.LocalFormula;
import formula.LocalFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfLocalFormula<S extends Symbol<?>> extends LocalFormula<S>, LTLfFormula<S> {

    // Used with reflection in LocalVisitor, do not erase.
    static <S extends Symbol<?>> LTLfLocalFormula<S> localFormulaFactory(LocalFormulaType formulaType, LTLfLocalFormula<S> left, LTLfLocalFormula<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new LTLfLocalAndFormula<>(left, right);
            case PROP_DOUBLEIMPL:
                return new LTLfLocalDoubleImplFormula<>(left, right);
            case PROP_IMPL:
                return new LTLfLocalImplFormula<>(left, right);
            case PROP_NOT:
                return new LTLfLocalNotFormula<>(left);
            case PROP_OR:
                return new LTLfLocalOrFormula<>(left, right);
            case PROP_VAR:
                return new LTLfLocalVar<>(symbol);
            case PROP_TRUE:
                return new LTLfLocalTrueFormula<>();
            case PROP_FALSE:
                return new LTLfLocalFalseFormula<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LTLfLocalFormula.propFormulaFactory not found.");
        }
    }
}
