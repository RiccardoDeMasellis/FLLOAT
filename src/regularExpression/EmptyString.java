package regularExpression;

import java.util.HashMap;

public class EmptyString extends RegularExpression{
	
	static final long serialVersionUID = 500001;
	
	private String symbol;
	
	public EmptyString(){
		this.symbol="eps";
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	public String rewriteFromCharToString(HashMap<Character,String>map){
		return symbol;
	}

	@Override
	public int hashCode() {
		return symbol.hashCode();
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
		EmptyString other=(EmptyString) otherObject;
				
		return this.getSymbol().equals(other.getSymbol());
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public EmptyString clone(){
		EmptyString clonedAtom = (EmptyString) super.clone();
		
		return clonedAtom;
	}

}
