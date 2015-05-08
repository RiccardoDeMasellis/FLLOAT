package formula;

import operator.Operator;
import symbols.Symbol;

public class UntilFormula<S extends Symbol<?>> extends BinaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public UntilFormula(Formula<S> left,Formula<S> right) {
		super(left,right);
		super.setOperator(Operator.untilOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to an untilFormula
		UntilFormula<S> other=(UntilFormula<S>) otherObject;
				
		return this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide());
	}
	
	//Return the negated formula
	public BinaryFormula<S> toNNF(){	
		return (BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.releaseOperator,Operations.toNNF(this.getLeftSide(),true),Operations.toNNF(this.getRightSide(), true));	
	}
	
}