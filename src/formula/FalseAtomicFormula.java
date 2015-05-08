package formula;

import symbols.Symbol;


/**
 * Class representing the *propositional* formula false.
 * 
 * @author demas
 *
 * @param <S>
 */

public class FalseAtomicFormula<S extends Symbol<?>> extends SpecialAtomicFormula<S> {
	
	public FalseAtomicFormula() {
	}
	
	@Override
	public int hashCode() {
		return "false".hashCode();
	}
	
	@Override
	public FalseAtomicFormula<S> clone() {
		return new FalseAtomicFormula<S>();	
	}
	
	@Override
	public String toString(){
		return "false";
	}

}
