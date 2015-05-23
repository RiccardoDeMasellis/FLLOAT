package formula.regExp;

import formula.propositional.PropFormula;
import formula.propositional.PropFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpProp<S extends Symbol<?>> extends RegExp<S>, PropFormula<S> {

    static <S extends Symbol<?>> RegExpProp<S> propFormulaFactory(PropFormulaType formulaType, RegExpProp<S> left, RegExpProp<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new RegExpPropAnd<>(left, right);
            case PROP_DOUBLEIMPL:
                return new RegExpPropDoubleImpl<>(left, right);
            case PROP_IMPL:
                return new RegExpPropImpl<>(left, right);
            case PROP_NOT:
                return new RegExpPropNot<>(left);
            case PROP_OR:
                return new RegExpPropOr<>(left, right);
            case PROP_VAR:
                return new RegExpPropVar<>(symbol);
            case PROP_TRUE:
                return new RegExpPropTrue<>();
            case PROP_FALSE:
                return new RegExpPropFalse<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in RegExpProp.propFormulaFactory not found.");
        }
    }

}
