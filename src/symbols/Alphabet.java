package symbols;

import java.util.HashSet;

public class Alphabet<S extends Symbol<?>> {

	//This set will be filled with the element of the alphabet.
	//Each element of the set is an instance of the "Symbol" class
	private HashSet<S> alphabet = new HashSet<S>();
	

	public HashSet<HashSet<S>> words = new HashSet<HashSet<S>>();
	
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
	
	public HashSet<S> getAlphabet() {
		return alphabet;
	}
	
	public void setAlphabet(HashSet<S> alphabet) {
		this.alphabet = alphabet;
	}

	public void setWords(HashSet<HashSet<S>> words) {
		this.words = words;
	}
	
	@Override
	public String toString() {
		return this.alphabet.toString();
	}
	
	
	
	
//	public void evaluatePowersetAlphabet(){
//		
//		HashSet<Symbol> epsilonSet=new HashSet<Symbol>();
//		epsilonSet.add(Symbol.espilonSymbol());
//		
//		if(alphabet.contains(Symbol.espilonSymbol())){
//			alphabet.remove(Symbol.espilonSymbol());
//		}
//		
//		words=powersetSymbol(alphabet);
//		words.add(epsilonSet);
//		words.remove(new HashSet<Symbol>());
//	} 
	
//	public static void alphabet(){
//		//If alphabet is not empty, then works with the symbols that belong to the alphabet,
//		//else, add "T" to the alphabet since we are not interested in a particular element 
//		if(!alphabet.isEmpty()){
//			for(Symbol s:alphabet){
//				HashSet<Symbol> word=new HashSet<Symbol>();
//				word.add(s);
//				words.add(word);
//			}
//		}
//		else{
//			alphabet.add(new Symbol('T'));
//			words.add(alphabet);
//			
//			HashSet<Symbol> word=new HashSet<Symbol>();
//			word.add(Symbol.espilonSymbol());
//			words.add(word);
//		}
//	}
//	
//	public static void clear(){
//		alphabet.clear();
//		words.clear();
//	}
	
	
	
//	//Return the power set of a given set of Symbols
//	public static <S extends Symbol<?>> HashSet<HashSet<S>> powersetSymbol(HashSet<S> list) {
//		HashSet<HashSet<S>> ps = new HashSet<HashSet<S>>();
//		ps.add(new HashSet<S>());   // add the empty set
//					 
//		// for every item in the original list
//		for (S item : list) {
//			HashSet<HashSet<S>> newPs = new HashSet<HashSet<S>>();
//				 
//			for (HashSet<S> subset : ps) {
//				// copy all of the current powerset's subsets
//				newPs.add(subset);
//				 
//				// plus the subsets appended with the current item
//				HashSet<S> newSubset = new HashSet<S>(subset);
//				newSubset.add(item);
//				newPs.add(newSubset);
//			}
//					 
//			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
//			ps = newPs;
//		}
//		return ps;
//	}
}
