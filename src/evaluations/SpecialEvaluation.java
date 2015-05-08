package evaluations;

public abstract class SpecialEvaluation extends Evaluation {

	public SpecialEvaluation() {
		this.eval = null;
	}
	
	
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass());
	}

}
