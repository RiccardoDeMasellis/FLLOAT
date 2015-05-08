package formula;

import symbols.Symbol;


/**
 * Class representing the *LDLf* formula tt.
 * 
 * @author demas
 *
 * @param <S>
 */

public class ttAtomicFormula<S extends Symbol<?>> extends SpecialAtomicFormula<S> {
	
	public ttAtomicFormula() {
	}
	
	@Override
	public int hashCode() {
		return "tt".hashCode();
	}
	
	@Override
	public ttAtomicFormula<S> clone() {
		return new ttAtomicFormula<S>();	
	}

	@Override
	public String toString() {
		return "tt";
	}
	
}
