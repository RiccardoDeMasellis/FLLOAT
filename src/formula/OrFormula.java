package formula;

import operator.Operator;
import symbols.Symbol;

public class OrFormula<S extends Symbol<?>> extends BinaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public OrFormula(Formula<S> left,Formula<S> right) {
		super(left,right);
		super.setOperator(Operator.orOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
			
		//Check if the argument object is null 
		if(otherObject==null) return false;
			
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
			
		//Cast otherObject to an orFormula
		OrFormula<S> other=(OrFormula<S>) otherObject;
			
		return (this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide()))
				||
				(this.getLeftSide().equals(other.getRightSide())&&this.getRightSide().equals(other.getLeftSide()));
	}
	
	//Return the negated formula
	public BinaryFormula<S> toNNF(){	
		return (BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.andOperator,Operations.toNNF(this.getLeftSide(),true),Operations.toNNF(this.getRightSide(), true));
	}
}