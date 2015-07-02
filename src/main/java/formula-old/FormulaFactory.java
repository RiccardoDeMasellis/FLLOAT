package formula;

import operator.*;
import symbols.Symbol;

public class FormulaFactory {

	//Return the binary formula created from an operator, a left formula and a right formula
	public static <S extends Symbol<?>> BinaryFormula<S> createBinaryFormula(String op, Formula<S> leftSide, Formula<S> rightSide) {
		if(op.equals(Operator.andOperator))
			return new AndFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.orOperator))
			return new OrFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.doubleImplicationOperator))
			return new DoubleImplicationFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.implicationOperator))
			return new ImplicationFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.untilOperator))
			return new UntilFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.weakUntilOperator))
			return new WeakUntilFormula<S>(leftSide, rightSide);
		if(op.equals(Operator.releaseOperator))
			return new ReleaseFormula<S>(leftSide, rightSide);
		return null;
	}

	//Return an unary formula from an operator and a formula
	public static <S extends Symbol<?>> UnaryFormula<S> createUnaryFormula(String op, Formula<S> formula) {
		if(op.equals(Operator.eventuallyOperator))
			return new EventuallyFormula<S>(formula);
		if(op.equals(Operator.globallyOperator))
			return new GloballyFormula<S>(formula);
		if(op.equals(Operator.nextOperator))
			return new NextFormula<S>(formula);
		if(op.equals(Operator.weakNextOperator))
			return new WeakNextFormula<S>(formula);
		if(op.equals(Operator.notOperator))
			return new NotFormula<S>(formula);
		return null;
	}
	
	//Return an atomic formula from a character
	public static <S extends Symbol<?>> AtomicFormula<S> createAtomicFormula(S symbol){
		return new AtomicFormula<S>(symbol);
	}
	
}
