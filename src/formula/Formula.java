package formula;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import symbols.Alphabet;
import symbols.Symbol;

public abstract class Formula<S extends Symbol<?>> implements Serializable, Cloneable, Comparable<Formula<S>> {
	
	static final long serialVersionUID = 100001;
	
	@Override
	public Formula<S> clone(){
		Formula<S> clonedFormula=null;
		try {
			clonedFormula = (Formula<S>) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clonedFormula;
	}
	
	public int compareTo(Formula<S> f) {
		return this.toString().compareTo(f.toString());
	}

	public static <S extends Symbol<?>> Formula<S> load(InputStream stream) throws IOException, OptionalDataException, ClassCastException, ClassNotFoundException, InvalidClassException{
		ObjectInputStream s = new ObjectInputStream(stream);
		return (Formula<S>)s.readObject();
	}
	
	public void store(OutputStream stream) throws IOException{
		ObjectOutputStream s = new ObjectOutputStream(stream);
		s.writeObject(this);
		s.flush();
	}
	
	
	
	/**
	 * @return The alphabet, i.e., a set of symbols contained in the formula.
	 */
	public Alphabet<S> getFormulaAlphabet() {
		Alphabet<S> alphabet = new Alphabet<S>();
		
		if(this instanceof AtomicFormula) {
			if (this instanceof SpecialAtomicFormula) {
				return alphabet;
			}
			else {
				AtomicFormula<S> af = (AtomicFormula<S>)this;
				alphabet.getAlphabet().add(af.getSymbol());
				return alphabet;
			}
		}
		
		if(this instanceof UnaryFormula) {
			UnaryFormula<S> uf = (UnaryFormula<S>)this;
			HashSet<S> unarySet = uf.getUnaryFormula().getFormulaAlphabet().getAlphabet();
			alphabet.getAlphabet().addAll(unarySet);
			return alphabet;
		}
		
		if (this instanceof BinaryFormula) {
			BinaryFormula<S> bf = (BinaryFormula<S>)this;
			HashSet<S> left = bf.getLeftSide().getFormulaAlphabet().getAlphabet();
			HashSet<S> right = bf.getRightSide().getFormulaAlphabet().getAlphabet();
			left.addAll(right);
			alphabet.getAlphabet().addAll(left);
			return alphabet;
		}
		return alphabet;
	}
	
}
