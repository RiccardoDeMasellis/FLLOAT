package formula;

import symbols.Symbol;


/**
 * Class representing the *LDLf* formula ff.
 * 
 * @author demas
 *
 * @param <S>
 */

public class ffAtomicFormula<S extends Symbol<?>> extends SpecialAtomicFormula<S> {

	public ffAtomicFormula() {
	}
	
	@Override
	public int hashCode() {
		return "ff".hashCode();
	}
	
	@Override
	public ffAtomicFormula<S> clone() {
		return new ffAtomicFormula<S>();	
	}

	@Override
	public String toString() {
		return "ff";
	}
	
	
}
