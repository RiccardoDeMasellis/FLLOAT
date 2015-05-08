package formula;

import java.util.HashMap;

import symbols.Symbol;

public class BinaryFormula<S extends Symbol<?>> extends Formula<S> implements Cloneable {

	static final long serialVersionUID = 100001;
	
	private Formula<S> leftSide;
	private Formula<S> rightSide;
	private String op;
	
	public BinaryFormula(Formula<S> left, Formula<S> right){
		leftSide=left;
		rightSide=right;
		op=null;
	}
	
	//Return the left formula of the binary formula
	public Formula<S> getLeftSide(){
		return leftSide;
	}
	
	//Set the left formula of the binary formula
	public void setLeftSide(Formula<S> left){
		leftSide=left;
	}

	//Return the right formula of the binary formula
	public Formula<S> getRightSide(){
		return rightSide;
	}
	
	//Set the right formula of the binary formula
	public void setRightSide(Formula<S> right){
		rightSide=right;
	}
	
	//Set the operator of the binary formula
	protected void setOperator(String o){
		op=o;
	}
	
	//Return the operator of the binary formula
	public String getOperator(){
		return op;
	}
	
	@Override
	public String toString(){
		return "("+this.getLeftSide().toString()+")"+this.getOperator()+"("+this.getRightSide().toString()+")";
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String> map){
//		return "("+this.getLeftSide().rewriteFromCharToString(map)+")"+this.getOperator()+"("+this.getRightSide().rewriteFromCharToString(map)+")";
//	}
	
	@Override
	public int hashCode(){
		return leftSide.hashCode()+rightSide.hashCode();
	}
	
	@Override
	public BinaryFormula<S> clone(){
		BinaryFormula<S> clonedFormula = (BinaryFormula<S>) super.clone();
		clonedFormula.setLeftSide((Formula<S>) this.getLeftSide().clone());
		clonedFormula.setRightSide((Formula<S>) this.getRightSide().clone());
			
		return clonedFormula;
	}
	
}
