package formula.ltlf;

import formula.TemporalFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface LTLfTempFormula<S extends Symbol<?>> extends TemporalFormula<S>, LTLfFormula<S> {

}
