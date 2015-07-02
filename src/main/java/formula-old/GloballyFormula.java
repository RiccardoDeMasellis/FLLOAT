package formula;

import operator.Operator;
import symbols.Symbol;

public class GloballyFormula<S extends Symbol<?>> extends UnaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public GloballyFormula(Formula<S> formula){
		super(formula);
		super.setOperator(Operator.globallyOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a globallyFormula
		GloballyFormula<S> other=(GloballyFormula<S>) otherObject;
				
		return this.getUnaryFormula().equals(other.getUnaryFormula());
	}
	
	//Return the negated formula
	public UnaryFormula<S> toNNF(){	
		return (UnaryFormula<S>) FormulaFactory.createUnaryFormula(Operator.eventuallyOperator,Operations.toNNF(this.getUnaryFormula(),true));
	}
	
}
