package formula;

import operator.Operator;
import symbols.Symbol;

public class WeakNextFormula<S extends Symbol<?>> extends UnaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public WeakNextFormula(Formula<S> formula){
		super(formula);
		super.setOperator(Operator.weakNextOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a weakNextFormula
		WeakNextFormula<S> other=(WeakNextFormula<S>) otherObject;
				
		return this.getUnaryFormula().equals(other.getUnaryFormula());
	}
	
	//Return the negated formula
	public UnaryFormula<S> toNNF(){	
		return (UnaryFormula<S>) FormulaFactory.createUnaryFormula(Operator.nextOperator,Operations.toNNF(this.getUnaryFormula(),true));
	}
	
}