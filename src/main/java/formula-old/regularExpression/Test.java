package regularExpression;

import java.util.HashMap;

import operator.Operator;
import symbols.Symbol;
import formula.*;

public class Test<S extends Symbol<?>> extends RegularExpression<S> {
	
	static final long serialVersionUID = 500001;
	
	Formula<S> formula;
	String op;

	public Test(Formula<S> f){
		this.formula=f;
		op=Operator.testOperator;
	}

	@Override
	public String toString() {
		if(formula instanceof AtomicFormula){
			return formula.toString()+op;
		}
		else{
			return "("+formula.toString()+")"+op;
		}
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return "("+formula.rewriteFromCharToString(map)+")"+op;
//	}

	@Override
	public int hashCode() {
		return formula.hashCode()+op.hashCode();
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
		Test<S> other=(Test<S>) otherObject;
				
		return this.getFormula().equals(other.getFormula());
	}
	
	@Override
	public Test<S> clone(){
		Test<S> clonedTest = (Test<S>) super.clone();
		clonedTest.setFormula((Formula<S>) this.getFormula().clone());
		
		return clonedTest;
	}
	
	public Formula<S> getFormula() {
		return formula;
	}

	public void setFormula(Formula<S> formula) {
		this.formula = formula;
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

}
