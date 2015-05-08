package regularExpression;

import java.util.HashMap;

import operator.Operator;
import symbols.Symbol;

public class Concatenation<S extends Symbol<?>> extends RegularExpression<S> {

	static final long serialVersionUID = 500001;
	
	RegularExpression<S> leftSide;
	RegularExpression<S> rightSide;
	String op;
	
	public Concatenation(RegularExpression<S> l,RegularExpression<S> r){
		this.leftSide=l;
		this.rightSide=r;
		this.op=Operator.concatenationRegularExpressionOperator;
	}
	
	@Override
	public String toString() {
		return leftSide.toString()+op+rightSide.toString();
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return leftSide.rewriteFromCharToString(map)+op+rightSide.rewriteFromCharToString(map);
//	}
	
	@Override
	public int hashCode(){
		return leftSide.hashCode()+rightSide.hashCode();
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
			
		//Check if the argument object is null 
		if(otherObject==null) return false;
			
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
			
		//Cast otherObject to an andFormula
		Concatenation<S> other=(Concatenation<S>) otherObject;
			
		return this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide());
	}
	
	@Override
	public Concatenation<S> clone(){
		Concatenation<S> clonedConcatenation = (Concatenation<S>) super.clone();
		clonedConcatenation.setLeftSide((RegularExpression<S>) this.getLeftSide().clone());
		clonedConcatenation.setRightSide((RegularExpression<S>) this.getRightSide().clone());
			
		return clonedConcatenation;
	}
	
	public RegularExpression<S> getLeftSide() {
		return leftSide;
	}
	
	public void setLeftSide(RegularExpression<S> leftSide) {
		this.leftSide = leftSide;
	}
	
	public RegularExpression<S> getRightSide() {
		return rightSide;
	}
	
	public void setRightSide(RegularExpression<S> rightSide) {
		this.rightSide = rightSide;
	}
}
