package evaluations;

public class EpsilonEvaluation extends SpecialEvaluation {

    public EpsilonEvaluation() {
        super();
    }

    @Override
    public int hashCode() {
        return "epsilonEval".hashCode();
    }

    @Override
    public EpsilonEvaluation clone() {
        return new EpsilonEvaluation();
    }


    @Override
    public String toString() {
        return "eps";
    }

}
