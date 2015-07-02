/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package formula.ldlf;

import formula.LocalFormula;
import formula.LocalFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LDLfLocalFormula<S extends Symbol<?>> extends LDLfFormula<S>, LocalFormula<S> {

    static <S extends Symbol<?>> LDLfLocalFormula<S> localFormulaFactory(LocalFormulaType formulaType, LDLfLocalFormula<S> left, LDLfLocalFormula<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new LDLfLocalAndFormula<>(left, right);
            case PROP_DOUBLEIMPL:
                return new LDLfLocalDoubleImplFormula<>(left, right);
            case PROP_IMPL:
                return new LDLfLocalImplFormula<>(left, right);
            case PROP_NOT:
                return new LDLfLocalNotFormula<>(left);
            case PROP_OR:
                return new LDLfLocalOrFormula<>(left, right);
            case PROP_VAR:
                return new LDLfLocalVar<>(symbol);
            case PROP_TRUE:
                return new LDLfLocalTrueFormula<>();
            case PROP_FALSE:
                return new LDLfLocalFalseFormula<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LDLfLocalFormula.LDLfPropFormulaFactory not found.");
        }
    }
}
