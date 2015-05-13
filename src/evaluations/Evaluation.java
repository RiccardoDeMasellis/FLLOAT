package evaluations;

import java.util.HashSet;
import java.util.Set;

import symbols.Symbol;


/**
 * This class represent (propositional) evaluations to symbols of a given <@link>Alphabet</link>.
 * Actually, since automata transitions are labeled by evaluations of symbols to the alphabet, such a class
 * is used for labeling automata transitions. For this reason there are <@link>SpecialEvaluation</@link>
 * which are <@link>TrueEvaluation</link> or <@link>EpsilonEvaluation</link>, even if they are not, formally,
 * evaluations for the symbols.
 * An evaluation is simply a set of Symbols, those that are set to TRUE, the other Symbols are assumed to be FALSE
 * (unless it is a SpecialEvaluation that are treated differently).
 *
 * Given an alphabet alph, the set of interpretation for alph is obtained by
 * <code>utils.Utilities.evalPowerset(alph.getAlphabet())</code>, which also adds the epsilonEvaluation.
 *
 * @param <S> the Symbols the alphabet.
 */
public class Evaluation<S extends Symbol<?>> {

	Set<S> eval;
	
	
	public Evaluation() {
		eval = new HashSet<>();
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
