package formula;

import operator.Operator;
import symbols.Symbol;

public class ImplicationFormula<S extends Symbol<?>> extends BinaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public ImplicationFormula(Formula<S> left,Formula<S> right) {
		super(left,right);
		super.setOperator(Operator.implicationOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to an implicationFormula
		ImplicationFormula<S> other=(ImplicationFormula<S>) otherObject;
				
		return this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide());
	}
	
	//Return the negated formula rewriting it in term of "and" formula
	public BinaryFormula<S> toNNF(){	 
		return (BinaryFormula<S>) FormulaFactory.createBinaryFormula(Operator.andOperator,Operations.toNNF(this.getLeftSide(),false),Operations.toNNF(this.getRightSide(),true));
	}
	
}
