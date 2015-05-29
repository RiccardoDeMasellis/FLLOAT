/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package symbols;

import java.util.HashSet;

//TODO: Why there is no constructor in such a class?

//TODO: Re-think of whether adding the epsilonSymbol to the alphabet or not.

/**
 * This class represents the Alphabet of an automaton, i.e., a set of Symbols. Actually, there is a little
 * ambiguity here. Formally, for automata coming from formal logic (such as an LTL automaton) given a set
 * AP of atomic propositions, the alphabet is 2^AP, so each assignment is indeed an element of the alphabet.
 * Here alphabet = AP, because it is class <@link>Evaluation</@link> that represents the valuations of symbols in
 * the alphabet.
 * This class is used as follows. The visitor of an input formula, has an alphabet as its instance variable
 * which is populated while parsing the input formula. After the parsing, the alphabet can be retrieved by simply
 * calling <code>visitor.getAlphabet()</code>. Alternatively, the class <code>Formula</code> provides the method
 * <code>getFormulaAlphabet()</code> which recursively scans the formula structures up to atomic formulas (which
 * contains the alphabet symbols) and returns a new alphabet of those. Among the two, the first usage is preferred
 * as it does not require to re-scan the whole formula.
 * <p>
 * "Special" symbols as TRUE or FALSE are absolutiely not considered alphabet symbols, and they are not, indeed.
 * Such symbols can be used in input formulas but they are automatically translated in
 * <code>SpecialAtomicFormula</code>s during the parsing and not added to the alphabet.
 * <p>
 * This class is considered an Object, hence it *does not* override equals and hashCode.
 *
 * @param <S> the Objects which compose the alphabet.
 */
public class Alphabet<S extends Symbol<?>> {

    //This set will be filled with elements of the alphabet.
    //Each element is an instance of S implementing the Symbol class.
    private HashSet<S> alphabet;


    public Alphabet() {
        alphabet = new HashSet<>();
    }


    //Add a "Symbol" to the alphabet, if it is the first "Symbol", then add also the "OtherSymbol",
    //which meaning is any OTHER Symbol, no matter which

    public void addSymbol(S symbol) {
/*		OtherSymbol<?> otherSymbol = new OtherSymbol<Object>();
        EpsilonSymbol<?> epsilonSymbol = new EpsilonSymbol<Object>();
		
		if(!(alphabet.contains(otherSymbol)))
			alphabet.add((S)otherSymbol);
		
		if(!(alphabet.contains(epsilonSymbol)))
			alphabet.add((S)epsilonSymbol);*/

        alphabet.add(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alphabet<?> alphabet1 = (Alphabet<?>) o;

        return !(getAlphabet() != null ? !getAlphabet().equals(alphabet1.getAlphabet()) : alphabet1.getAlphabet() != null);

    }

    @Override
    public int hashCode() {
        return getAlphabet() != null ? getAlphabet().hashCode() : 0;
    }

    public HashSet<S> getAlphabet() {
        return alphabet;
    }

    @Override
    public String toString() {
        return this.alphabet.toString();
    }

}
