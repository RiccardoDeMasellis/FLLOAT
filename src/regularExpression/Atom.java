package regularExpression;

import java.util.HashMap;

import symbols.Symbol;
import formula.AtomicFormula;
import formula.Formula;

public class Atom<S extends Symbol<?>> extends RegularExpression<S> {
	
	static final long serialVersionUID = 500001;
	
	private String symbol;
	private Formula<S> formula;
	
	public Atom(String s){
		this.symbol=s;
		this.formula=AtomicFormula.falseFormula();
	}
	
	public Atom(Formula<S> f){
		this.formula=f;
		this.symbol="";
	}

	@Override
	public String toString() {
		if(symbol.equals("")){
//			return "("+formula.toString()+")";
			return formula.toString();
		}
		else{
			return symbol;
		}
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		if(symbol.equals("")){
//			return formula.rewriteFromCharToString(map);
//		}
//		else{
//			return symbol;
//		}
//	}

	@Override
	public int hashCode() {
		return symbol.hashCode()+formula.hashCode();
	}

	@Override
	public boolean equals(Object otherObject){
			
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to an atomicFormula
		Atom<S> other=(Atom<S>) otherObject;
				
		return this.getSymbol().equals(other.getSymbol())&&this.getFormula().equals(other.getFormula());
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Formula<S> getFormula() {
		return formula;
	}

	public void setFormula(Formula<S> formula) {
		this.formula = formula;
	}
	
	@Override
	public Atom<S> clone(){
		Atom<S> clonedAtom = (Atom<S>) super.clone();
		clonedAtom.setFormula((Formula<S>) this.getFormula().clone());
		
		return clonedAtom;
	}

}
