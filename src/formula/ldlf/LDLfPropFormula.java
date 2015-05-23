package formula.ldlf;

import formula.propositional.PropFormula;
import formula.propositional.PropFormulaType;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 14/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LDLfPropFormula<S extends Symbol<?>> extends LDLfFormula<S>, PropFormula<S> {

    static <S extends Symbol<?>> LDLfPropFormula<S> propFormulaFactory(PropFormulaType formulaType, LDLfPropFormula<S> left, LDLfPropFormula<S> right, S symbol) {
        switch (formulaType) {
            case PROP_AND:
                return new LDLfPropAndFormula<>(left, right);
            case PROP_DOUBLEIMPL:
                return new LDLfPropDoubleImplFormula<>(left, right);
            case PROP_IMPL:
                return new LDLfPropImplFormula<>(left, right);
            case PROP_NOT:
                return new LDLfPropNotFormula<>(left);
            case PROP_OR:
                return new LDLfPropOrFormula<>(left, right);
            case PROP_VAR:
                return new LDLfPropVar<>(symbol);
            case PROP_TRUE:
                return new LDLfPropTrueFormula<>();
            case PROP_FALSE:
                return new LDLfPropFalseFormula<>();
            default:
                throw new RuntimeException("Enum " + formulaType + " in LDLfPropFormula.LDLfPropFormulaFactory not found.");
        }
    }
}
