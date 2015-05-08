package formula;

import operator.Operator;
import symbols.Symbol;

public class NextFormula<S extends Symbol<?>> extends UnaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public NextFormula(Formula<S> formula){
		super(formula);
		super.setOperator(Operator.nextOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a nextFormula
		NextFormula<S> other=(NextFormula<S>) otherObject;
				
		return this.getUnaryFormula().equals(other.getUnaryFormula());
	}
	
	//Return the negated formula
	public UnaryFormula<S> toNNF(){	
		return (UnaryFormula<S>)FormulaFactory.createUnaryFormula(Operator.weakNextOperator,Operations.toNNF(this.getUnaryFormula(),true));
	}
	
}
