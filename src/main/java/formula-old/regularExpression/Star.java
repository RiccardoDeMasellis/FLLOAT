package regularExpression;

import operator.Operator;
import symbols.Symbol;

public class Star<S extends Symbol<?>> extends RegularExpression<S> {

	static final long serialVersionUID = 500001;
	
	RegularExpression<S> expression;
	String op;
	
	public Star(RegularExpression<S> e){
		this.expression=e;
		op=Operator.starOperator;
	}
	
	@Override
	public String toString() {
//		if((this.expression instanceof Atom)||(this.expression instanceof Or)){
//			return expression.toString()+op;
//		}
//		else{
			return "("+expression.toString()+")"+op;
//		}
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return "("+expression.rewriteFromCharToString(map)+")"+op;
//	}

	@Override
	public int hashCode() {
		return expression.hashCode()+op.hashCode();
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
		Star<S> other=(Star<S>) otherObject;
				
		return this.getExpression().equals(other.getExpression());
	}
	
	@Override
	public Star<S> clone(){
		Star<S> clonedStar = (Star<S>) super.clone();
		clonedStar.setExpression((RegularExpression<S>) this.getExpression().clone());
		
		return clonedStar;
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public RegularExpression<S> getExpression() {
		return expression;
	}

	public void setExpression(RegularExpression<S> expression) {
		this.expression = expression;
	}
	
}
