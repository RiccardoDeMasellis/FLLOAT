package formula;

import symbols.Symbol;

public abstract class SpecialAtomicFormula<S extends Symbol<?>> extends AtomicFormula<S> {

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass());
	}
	
}
