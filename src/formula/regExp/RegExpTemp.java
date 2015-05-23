package formula.regExp;

import formula.TemporalFormula;
import symbols.Symbol;

/**
 * Created by Riccardo De Masellis on 15/05/15.
 * For any issue please write to r.demasellis@trentorise.eu.
 */
public interface RegExpTemp<S extends Symbol<?>> extends RegExp<S>, TemporalFormula<S> {
}
