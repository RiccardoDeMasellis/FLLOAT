package formula;

import java.util.HashMap;

import symbols.Symbol;

public class UnaryFormula<S extends Symbol<?>> extends Formula<S> {

	static final long serialVersionUID = 100001;
	
	private Formula<S> unaryFormula;
	private String op;
	
	public UnaryFormula(Formula<S> formula){
		setUnaryFormula(formula);
		op=null;
	}

	//Return the formula inside the unary formula 
	public Formula<S> getUnaryFormula() {
		return unaryFormula;
	}

	//Set the formula inside the unary formula
	public void setUnaryFormula(Formula<S> unaryFormula) {
		this.unaryFormula = unaryFormula;
	}

	//Return the operator of the unary formula
	public String getOperator() {
		return op;
	}

	//Set the operator of the unary formula
	protected void setOperator(String op) {
		this.op = op;
	}
	
	@Override
	public String toString(){
		return this.getOperator()+"("+this.getUnaryFormula()+")";
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return this.getOperator()+"("+this.getUnaryFormula().rewriteFromCharToString(map)+")";
//	}
	
	@Override
	public int hashCode(){
		return unaryFormula.hashCode();
	}
	
	@Override
	public UnaryFormula<S> clone(){
		UnaryFormula<S> clonedFormula = (UnaryFormula<S>) super.clone();
		clonedFormula.setUnaryFormula((Formula<S>) this.getUnaryFormula().clone());
			
		return clonedFormula;
	}
}
