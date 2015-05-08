package formula;

import operator.Operator;
import symbols.Symbol;

public class WeakUntilFormula<S extends Symbol<?>> extends BinaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	public WeakUntilFormula(Formula<S> left,Formula<S> right) {
		super(left,right);
		super.setOperator(Operator.weakUntilOperator);
	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a weakUntilFormula
		WeakUntilFormula<S> other=(WeakUntilFormula<S>) otherObject;
				
		return this.getLeftSide().equals(other.getLeftSide())&&this.getRightSide().equals(other.getRightSide());
	}
	
	//Return the negated formula rewriting it
	public BinaryFormula<S> toNNF(){	
		BinaryFormula<S> releaseFormula=(BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.releaseOperator,Operations.toNNF(this.getLeftSide(), true),Operations.toNNF(this.getRightSide(), true)); 
		UnaryFormula<S> globallyFormula=(UnaryFormula<S>)FormulaFactory.createUnaryFormula(Operator.globallyOperator,this.getLeftSide());
		return (BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.andOperator,releaseFormula,Operations.toNNF(globallyFormula,true));
	}
	
}