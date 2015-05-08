package regularExpression;

import operator.Operator;
import symbols.Symbol;

public class Or<S extends Symbol<?>> extends RegularExpression<S> {
	
	static final long serialVersionUID = 500001;
	
	RegularExpression<S> leftSide;
	RegularExpression<S> rightSide;
	String op;
	
	public Or(RegularExpression<S> l,RegularExpression<S> r){
		this.leftSide=l;
		this.rightSide=r;
		this.op=Operator.orRegularExpressionOperator;
	}
	
	@Override
	public String toString(){
		if((leftSide instanceof Or)&&(rightSide instanceof Or)){
			return leftSide.toString()+op+rightSide.toString();
		}
		else{
			return "("+leftSide.toString()+op+rightSide.toString()+")";
		}
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return "("+leftSide.rewriteFromCharToString(map)+op+rightSide.rewriteFromCharToString(map)+")";
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
		Or<S> other=(Or<S>) otherObject;
			
		return (this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide()))
				||
				(this.getLeftSide().equals(other.getRightSide())&&this.getRightSide().equals(other.getLeftSide()));
	}
	
	@Override
	public Or<S> clone(){
		Or<S> clonedOr = (Or<S>) super.clone();
		clonedOr.setLeftSide((RegularExpression<S>) this.getLeftSide().clone());
		clonedOr.setRightSide((RegularExpression<S>) this.getRightSide().clone());
			
		return clonedOr;
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
	
	public String getOp() {
		return op;
	}
	
	public void setOp(String op) {
		this.op = op;
	}

}
