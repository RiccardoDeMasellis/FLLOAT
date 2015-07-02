package formula;

import java.util.HashMap;

import symbols.Symbol;

public class AtomicFormula<S extends Symbol<?>> extends Formula<S> {

	static final long serialVersionUID = 100001;
	
	
//	private static TrueAtomicFormula trueFormula = new TrueAtomicFormula();
//	private static FalseAtomicFormula falseFormula = new FalseAtomicFormula();
//	private static EndedAtomicFormula endedFormula = new EndedAtomicFormula();
//	private static ttAtomicFormula ttFormula = new ttAtomicFormula();
//	private static ffAtomicFormula ffFormula = new ffAtomicFormula();
	

	private S atomicSymbol;

	public AtomicFormula() {}

	public AtomicFormula(S symbol){
		atomicSymbol=symbol;
	}

	//Return the Symbol object associated to the formula
	public S getSymbol(){
		if (this instanceof SpecialAtomicFormula)
			throw new RuntimeException("Special atomic formulas does not have an associated Symbol!");
		return atomicSymbol;
	}

	//Set the Symbol object associated to the formula
	private void setSymbol(S symbol){
		if (this instanceof SpecialAtomicFormula)
			throw new RuntimeException("Special atomic formulas does not have an associated Symbol!");
		atomicSymbol=symbol;
	}

	@Override
	public String toString() {
		return atomicSymbol.toString();
	}


	//Return the "true" formula
	public static <S extends Symbol<?>> TrueAtomicFormula<S> trueFormula(){
		return new TrueAtomicFormula<S>();
	}

	//Return the "false" formula
	public static <S extends Symbol<?>> FalseAtomicFormula<S> falseFormula(){
		return new FalseAtomicFormula<S>();
	}

	//Return the "end" formula
	public static <S extends Symbol<?>> EndedAtomicFormula<S> endFormula(){
		return new EndedAtomicFormula<S>();
	}

	public static <S extends Symbol<?>> ttAtomicFormula<S> ttFormula(){
		return new ttAtomicFormula<S>();
	}

	public static <S extends Symbol<?>> ffAtomicFormula<S> ffFormula(){
		return new ffAtomicFormula<S>();
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtomicFormula<S> other = (AtomicFormula<S>) obj;
		if (atomicSymbol == null) {
			if (other.atomicSymbol != null)
				return false;
		} else if (!atomicSymbol.equals(other.atomicSymbol))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atomicSymbol == null) ? 0 : atomicSymbol.hashCode());
		return result;
	}


	/**
	 * The S symbol is not cloned! 
	 */
	@Override
	public AtomicFormula<S> clone(){
		AtomicFormula<S> clonedFormula = (AtomicFormula<S>) super.clone();
		clonedFormula.setSymbol((S) this.getSymbol());

		return clonedFormula;
	}


}
