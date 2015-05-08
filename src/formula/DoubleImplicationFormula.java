package formula;

import operator.Operator;
import symbols.Symbol;

public class DoubleImplicationFormula<S extends Symbol<?>> extends BinaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public DoubleImplicationFormula(Formula<S> left,Formula<S> right) {
		super(left,right);
		super.setOperator(Operator.doubleImplicationOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a doubleImplicationFormula
		DoubleImplicationFormula<S> other=(DoubleImplicationFormula<S>) otherObject;
				
		return this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide());
	}
	
	//Return the negated formula rewriting it in term of "or" and "and" formulae
	public BinaryFormula<S> toNNF(){
		BinaryFormula<S> leftSide=(BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.andOperator, Operations.toNNF(this.getLeftSide(),false), Operations.toNNF(this.getRightSide(),true));
		BinaryFormula<S> rightSide=(BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.andOperator,Operations.toNNF(this.getRightSide(),false),Operations.toNNF(this.getLeftSide(),true));
		return (BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.orOperator, leftSide, rightSide);
	}
	
}
