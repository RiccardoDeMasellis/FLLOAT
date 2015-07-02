package formula;

import symbols.Symbol;

/**
 * Class representing the *LDLf/LTLf* formula ended (actually is not a formula).
 * 
 * @author demas
 *
 * @param <S>
 */


public class EndedAtomicFormula<S extends Symbol<?>> extends SpecialAtomicFormula<S> {

	public EndedAtomicFormula() {
	}
	
	
	@Override
	public int hashCode() {
		return "ended".hashCode();
	}
	
	
	@Override
	public EndedAtomicFormula<S> clone() {
		return new EndedAtomicFormula<S>();	
	}
	

	@Override
	public String toString() {
		return "ended";
	}
	
}
