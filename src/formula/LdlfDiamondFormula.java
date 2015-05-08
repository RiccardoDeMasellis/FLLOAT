package formula;

import java.util.HashMap;

import regularExpression.RegularExpression;
import symbols.Symbol;

public class LdlfDiamondFormula<S extends Symbol<?>> extends UnaryFormula<S> {

	static final long serialVersionUID = 100001;
	
	private RegularExpression<S> expression;
	
	public LdlfDiamondFormula(Formula<S> formula, RegularExpression<S> e) {
		super(formula);
		this.expression=e;
	}
	
	public RegularExpression<S> getExpression() {
		return expression;
	}

	public void setExpression(RegularExpression<S> expression) {
		this.expression = expression;
	}
	
	@Override
	public int hashCode(){
		return this.getUnaryFormula().hashCode()+expression.hashCode();
	}
	
	@Override
	public LdlfDiamondFormula<S> clone(){
		LdlfDiamondFormula<S> clonedFormula = (LdlfDiamondFormula<S>) super.clone();
		clonedFormula.setExpression((RegularExpression<S>) this.getExpression().clone());
			
		return clonedFormula;
	}

	@Override
	public String toString(){
		if(!(this.getUnaryFormula() instanceof AtomicFormula)){
			return "<"+ expression +">"+"("+this.getUnaryFormula()+")";
		}
		else{
			return "<"+ expression +">"+this.getUnaryFormula();
		}
	}
	
//	public String rewriteFromCharToString(HashMap<Character,String>map){
//		return "<" +expression.rewriteFromCharToString(map)+">"+"("+this.getUnaryFormula().rewriteFromCharToString(map)+")";
//	}
	
	@Override
	public boolean equals(Object otherObject){
		
		//Check if the objects are the same
		if(this==otherObject) return true;
				
		//Check if the argument object is null 
		if(otherObject==null) return false;
				
		//Check if both objects are of the same type
		if(getClass()!=otherObject.getClass()) return false;
				
		//Cast otherObject to a nextFormula
		LdlfDiamondFormula<S> other=(LdlfDiamondFormula<S>) otherObject;
				
		return this.getUnaryFormula().equals(other.getUnaryFormula())&&this.getExpression().equals(other.getExpression());
	}
	
	//Return the negated formula
	public UnaryFormula<S> toNNF(){	
		return new LdlfBoxFormula<S>((Formula<S>)Operations.toNNF(this.getUnaryFormula(),true),this.expression);
	}

}
