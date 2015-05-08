package evaluations;

public class TrueEvaluation extends SpecialEvaluation {

	public TrueEvaluation() {
		super();
	}
	
	@Override
	public int hashCode() {
		return "trueEval".hashCode();
	}
	
	@Override
	public TrueEvaluation clone() {
		return new TrueEvaluation();	
	}
	

	@Override
	public String toString(){
		return "trueEval";
	}
	
}
