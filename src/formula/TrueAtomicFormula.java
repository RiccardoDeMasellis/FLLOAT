package formula;

import symbols.Symbol;

/**
 * Class representing the *propositional* formula true.
 * 
 * @author demas
 *
 * @param <S>
 */

public class TrueAtomicFormula<S extends Symbol<?>> extends SpecialAtomicFormula<S> {
	
	public TrueAtomicFormula() {
	}
	
	@Override
	public int hashCode() {
		return "true".hashCode();
	}
	
	@Override
	public TrueAtomicFormula<S> clone() {
		return new TrueAtomicFormula<S>();	
	}
	

	@Override
	public String toString(){
		return "true";
	}

}
