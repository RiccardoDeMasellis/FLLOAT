package formula.ltlf;

import formula.propositional.PropFormula;
import formula.propositional.PropFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfPropFormula<S extends Symbol<?>> extends PropFormula<S>, LTLfFormula<S> {

    static <S extends Symbol<?>> LTLfPropFormula<S> propFormulaFactory(PropFormulaType formulaType, LTLfPropFormula<S> left, LTLfPropFormula<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new LTLfPropAndFormula<>(left, right);
            case PROP_DOUBLEIMPL:
                return new LTLfPropDoubleImplFormula<>(left, right);
            case PROP_IMPL:
                return new LTLfPropImplFormula<>(left, right);
            case PROP_NOT:
                return new LTLfPropNotFormula<>(left);
            case PROP_OR:
                return new LTLfPropOrFormula<>(left, right);
            case PROP_VAR:
                return new LTLfPropVar<>(symbol);
            case PROP_TRUE:
                return new LTLfPropTrueFormula<>();
            case PROP_FALSE:
                return new LTLfPropFalseFormula<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LTLfPropFormula.propFormulaFactory not found.");
        }
    }
}
