package evaluations;

import java.util.HashSet;
import java.util.Set;

import symbols.Symbol;

public class Evaluation<S extends Symbol<?>> {

	Set<S> eval;
	
	
	public Evaluation() {
		eval = new HashSet<S>();
	}
	
	public Evaluation(Set<S> eval) {
		this.eval = eval;
	}
	
	public Set<S> getEval() {
		return eval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eval == null) ? 0 : eval.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluation<S> other = (Evaluation<S>) obj;
		if (eval == null) {
			if (other.eval != null)
				return false;
		} else if (!eval.equals(other.eval))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return eval.toString();
	}
	
}
