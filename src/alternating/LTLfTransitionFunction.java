package alternating;

import java.util.HashSet;

import operator.*;
import evaluations.EpsilonEvaluation;
import evaluations.Evaluation;
import formula.*;
import symbols.*;

public class LTLfTransitionFunction {

	//If the formula is a "BinaryFormula" then return the result of the call of "expandBinaryOperator(formula,symbol,last)"
	//else
	//If the formula is a "GloballyFormula" or a "FinallyFormula" then return the result of the call of "expandUnaryOperator(formula,symbol,last)"
	//else 
	//return the result of the call of "evaluate(formula,symbol,last)"
	public static <S extends Symbol<?>> Formula<S> alternatingTransition(Formula<S> formula, Evaluation<S> eval, boolean last){
		
		if(formula instanceof BinaryFormula){
			return expandBinaryOperator(formula, eval, last);
		}
		else{
			if((formula instanceof GloballyFormula) || (formula instanceof EventuallyFormula)){
				return expandUnaryOperator(formula, eval, last);
			}
			else{
				return evaluate(formula, eval, last);
			}
		}	
	}
	
	
	
	//Analyzing the type of the "Formula" return the result of the call of the right method
	private static <S extends Symbol<?>> Formula<S> expandBinaryOperator(Formula<S> formula, Evaluation<S> eval, boolean last) {
		
		Formula<S> result=null;
		
		if(formula instanceof AndFormula){return and((AndFormula<S>)formula, eval, last);}
		if(formula instanceof OrFormula){return or((OrFormula<S>)formula, eval, last);}
		if(formula instanceof UntilFormula){return until((UntilFormula<S>)formula, eval, last);}
		if(formula instanceof ReleaseFormula){return release((ReleaseFormula<S>)formula, eval, last);}
		
		return result;
	}
	
	
	
	
	//Analyzing the type of the "Formula" return the result of the call of the right method
	private static <S extends Symbol<?>> Formula<S> expandUnaryOperator(Formula<S> formula, Evaluation<S> eval, boolean last){
		
		Formula<S> result = null;
		
		if(formula instanceof GloballyFormula){return always((GloballyFormula<S>)formula, eval, last);}
		if(formula instanceof EventuallyFormula){return eventually((EventuallyFormula<S>) formula, eval, last);}
		
		return result;
	}
	
	
	
	
	//Analyzing the type of the "Formula" return the result of the call of the right method
	private static <S extends Symbol<?>> Formula<S> evaluate(Formula<S> formula, Evaluation<S> eval, boolean last){
		
		Formula<S> result = null;
		
		if(formula instanceof NextFormula){return next((NextFormula<S>) formula, eval, last);}
		
		if(formula instanceof WeakNextFormula){return weakNext((WeakNextFormula<S>)formula, eval, last);}
		
		if(formula instanceof NotFormula){return notFormula((NotFormula<S>)formula, eval);}
		
		if(formula instanceof AtomicFormula){return atomicFormula((AtomicFormula<S>)formula, eval);}
		
		return result;
	}
	
	
	//If I have the "trueFormula", then return the "trueFormula"
	//else, if I have the "falseFormula", then return the "falseFormula"
	//else, if the "Symbol" associated to the "AtomicFormula" is equal to the "symbol" that I am analyzing, then return the "trueFormula",
	//otherwise return the "falseFormula"
	private static <S extends Symbol<?>> Formula<S> atomicFormula(AtomicFormula<S> formula, Evaluation<S> eval){
		
		//In case of "epsilonSymbol" return always "falseFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.falseFormula();
		}
		else{
			if(formula.equals(AtomicFormula.trueFormula())){
				return AtomicFormula.trueFormula();
			}
			else{
				if(formula.equals(AtomicFormula.falseFormula())){
					return AtomicFormula.falseFormula();
				}

				else{
					if(eval.getEval().contains(formula.getSymbol())){
						return AtomicFormula.trueFormula();
					}
					else{
						return AtomicFormula.falseFormula();
					}
				}	 
			}
		}
	}
	
	
	//If the "Symbol" associated to the "AtomicFormula" is equal to the "symbol" that I am analyzing, then return the "false",
	//otherwise return the "trueFormula"
	private static <S extends Symbol<?>> Formula<S> notFormula(NotFormula<S> formula, Evaluation<S> eval){
		
		//In case of "epsilonSymbol" return always "trueFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.trueFormula();	
		}
		else{
			if(eval.getEval().contains(((AtomicFormula<S>)formula.getUnaryFormula()).getSymbol())){
				return AtomicFormula.falseFormula();
			}
			else{
				return AtomicFormula.trueFormula();
			} 
		}
	}
	
	
	
	
	//It analyzes the "AndFormula" 
	private static <S extends Symbol<?>> Formula<S> and(AndFormula<S> formula, Evaluation<S> eval, boolean last){
		Formula<S> result = null;
		Formula<S> leftResult = null;
		Formula<S> rightResult = null;
		
		leftResult = alternatingTransition(formula.getLeftSide(), eval, last);
		
		//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "leftSide" of the formula is an "AtomicFormula"
		if(leftResult instanceof AtomicFormula){
			
			leftResult=(AtomicFormula<S>) leftResult;
			
			//if the "leftResult" is equal to "falseFormula", then stop the computation and return "falseFormula", else evaluate the "rigthSide" of the "AndFormula"
			if(leftResult.equals(AtomicFormula.falseFormula())){
				result = AtomicFormula.falseFormula();
			}
			else{
				rightResult = alternatingTransition(formula.getRightSide(), eval, last);
				
				//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
				if(rightResult instanceof AtomicFormula){
					
					rightResult = (AtomicFormula<S>)rightResult;
					
					//if the "rightResult" is equal to "falseFormula", then stop the computation and return "falseFormula"
					if(rightResult.equals(AtomicFormula.falseFormula())){
						result = AtomicFormula.falseFormula();
					}
					else{
						
						//If both "rightResult" and "leftResult" are equal to "trueFormula", then return "trueFormula"
						if((leftResult.equals(AtomicFormula.trueFormula())) &&
							(rightResult.equals(AtomicFormula.trueFormula()))){
							result=AtomicFormula.trueFormula();
						}
						
						//If both "leftResult" and "rightResult" are different from "trueFormula"
						if(!(leftResult.equals(AtomicFormula.trueFormula()))&&
								!(rightResult.equals(AtomicFormula.trueFormula()))){
							//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
							if (leftResult.equals(rightResult)){
								result=leftResult;
							}
							else{
								result=FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);		
							}
						}
						
						//If "leftResult" is different from "trueFormula", and "rightResult" is equal to "trueFormula", then return the "leftResult"
						if(!(leftResult.equals(AtomicFormula.trueFormula()))&&
								(rightResult.equals(AtomicFormula.trueFormula()))){
							result=leftResult;
						}
						
						//If "rightResult" is different from "trueFormula", and "leftResult" is equal to "trueFormula", then return the "rightResult"
						if((leftResult.equals(AtomicFormula.trueFormula()))&&
								!(rightResult.equals(AtomicFormula.trueFormula()))){
							result=rightResult;
						}
					}	
				}
				
				else{
					//leftResult is an "AtomicFormula" different from "falseFormula"
					//rightResult is not an "AtomicFormula"
					//If leftResult is equal "trueFormula" return "rightResult"
					if(leftResult.equals(AtomicFormula.trueFormula())){
						result=rightResult;
					}
					//else "leftResult" is an "AtomicFormula" different from "trueFormula" and "rightResult" is not an "AtomicFormula", 
					//then result is equal to the call of "checkIsPartOf"
					else{
						result=FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
					}
				}
			}
		}
		else{
			//leftResult is not an "AtomicFormula" (surely is different from "falseFormula")
			rightResult = alternatingTransition(formula.getRightSide(), eval, last);
			
			//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
			if(rightResult instanceof AtomicFormula){
				
				rightResult=(AtomicFormula<S>)rightResult;
				
				//if the "rightResult" is equal to "falseFormula", then stop the computation and return false
				if(rightResult.equals(AtomicFormula.falseFormula())){
					result=AtomicFormula.falseFormula();
				}
				else{
					
					//if the "rightResult" is equal to "trueFormula", then return "leftResult"
					if(rightResult.equals(AtomicFormula.trueFormula())){
						result=leftResult;
					}
					else{
						//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
						if (leftResult.equals(rightResult)){
							result=leftResult;
						}
						else{
							result=FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
						}
					}
				}
			}
			//Both leftResult and rightResult are not Atomic
			else{
				//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
				if (leftResult.equals(rightResult)){
					result=leftResult;
				}
				else{
					result=FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
				}
			}		
		}
		return result;
	}
	
	
	
	
	//It analyzes the "OrFormula" 
	private static <S extends Symbol<?>> Formula<S> or(OrFormula<S> formula, Evaluation<S> eval, boolean last){
		Formula<S> result = null;
		Formula<S> leftResult = null;
		Formula<S> rightResult = null;
		
		leftResult = alternatingTransition(formula.getLeftSide(), eval, last);
		
		//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "leftSide" of the formula is an "AtomicFormula"
		if(leftResult instanceof AtomicFormula){
			
			leftResult=(AtomicFormula<S>)leftResult;
			
			//if the "leftResult" is equal to "trueFormula", then stop the computation and return "trueFormula", else evaluate the "rigthSide" of the "OrFormula"
			if(leftResult.equals(AtomicFormula.trueFormula())){
				result = AtomicFormula.trueFormula();
			}
			else{
				rightResult = alternatingTransition(formula.getRightSide(), eval, last);
	
				//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
				if(rightResult instanceof AtomicFormula){
					
					rightResult=(AtomicFormula<S>)rightResult;
					
					//if the "rightResult" is equal to "trueFormula", then stop the computation and return "trueFormula"
					if(rightResult.equals(AtomicFormula.trueFormula())){
						result=AtomicFormula.trueFormula();
					}
					else{
						
						//If both "rightResult" and "leftResult" are equal to "falseFormula", then return "falseFormula"
						if((leftResult.equals(AtomicFormula.falseFormula()))&&
								(rightResult.equals(AtomicFormula.falseFormula()))){
								result=AtomicFormula.falseFormula();
						}
						
						//If both "leftResult" and "rightResult" are different from "falseFormula"
						if(!(leftResult.equals(AtomicFormula.falseFormula()))&&
								!(rightResult.equals(AtomicFormula.falseFormula()))){
							//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
							if (leftResult.equals(rightResult)){
								result=leftResult;
							}
							else{
								result=FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
							}
						}
						
						//If "leftResult" is different from "falseFormula", and "rightResult" is equal to "falseFormula", then return the "leftResult"
						if(!(leftResult.equals(AtomicFormula.falseFormula()))&&
								(rightResult.equals(AtomicFormula.falseFormula()))){
							result=leftResult;
						}
						
						//If "rightResult" is different from "falseFormula", and "leftResult" is equal to "falseFormula", then return the "rightResult"
						if((leftResult.equals(AtomicFormula.falseFormula()))&&
								!(rightResult.equals(AtomicFormula.falseFormula()))){
							result=rightResult;
						}
					}	
				}
				else{
					//leftResult is an "AtomicFormula" different from "trueFormula"
					//rightResult is not an "AtomicFormula"
					//If leftResult is equal "falseFormula" return "rightResult"
					if(leftResult.equals(AtomicFormula.falseFormula())){
						result=rightResult;
					}
					//else "leftResult" is an "AtomicFormula" different from "falseFormula" and "rightResult" is not an "AtomicFormula", 
					//then result is equal to the call of "checkIsPartOf"
					else{
						result=FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
					}
				}
			}
		}
		else{
			//leftResult is not an "AtomicFormula" (surely is different from "trueFormula")
			rightResult = alternatingTransition(formula.getRightSide(),eval,last);
			
			//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
			if(rightResult instanceof AtomicFormula){
				
				rightResult=(AtomicFormula<S>)rightResult;
				
				//if the "rightResult" is equal to "trueFormula", then stop the computation and return "trueFormula"
				if(rightResult.equals(AtomicFormula.trueFormula())){
					result=AtomicFormula.trueFormula();
				}
				else{
					
					//if the "rightResult" is equal to "falseFormula", then return "leftResult"
					if(rightResult.equals(AtomicFormula.falseFormula())){
						result=leftResult;
					}
					else{
						//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
						if (leftResult.equals(rightResult)){
							result=leftResult;
						}
						else{
							result=FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
						}
					}
				}
			}
			//Both leftResult and rightResult are not Atomic
			else{
				//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
				if (leftResult.equals(rightResult)){
					result=leftResult;
				}
				else{
					result=FormulaFactory.createBinaryFormula(Operator.orOperator, leftResult, rightResult);
				}
			}
				
		}
		return result;
	}
	
	
	//It analyzes "NextFormula"
	private static <S extends Symbol<?>> Formula<S> next(NextFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "falseFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.falseFormula();
		}
		else{
			//If last is "true", then return "falseFormula", else return the "UnaryFormula" associated with the "NextFormula"
			if(last)
			{
				return AtomicFormula.falseFormula();
			}
			else{
				return formula.getUnaryFormula();
			}
		}
	}
	
	
	//It analyzes "WeakNextFormula"
	private static <S extends Symbol<?>> Formula<S> weakNext(WeakNextFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "trueFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.trueFormula();
		}
		else{
			//If last is "true", then return "trueFormula", else return the "UnaryFormula" associated with the "WeakNextFormula"
			if(last)
			{
				return AtomicFormula.trueFormula();	
			}
			else{
				return formula.getUnaryFormula();
			}
		}
	}
	
	
	
	//It analyzes "EventuallyFormula"
	private static <S extends Symbol<?>> Formula<S> eventually(EventuallyFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "falseFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.falseFormula();
		}
		else{
			//Apply "expandBinaryOperator" to the "OrFormula" composed by the "UnaryFormula" associated to the "FinallyFormula" and by the "NextFormula" that has like "UnaryFormula" the original "FinallyFormula" 
			return expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, formula.getUnaryFormula(), FormulaFactory.createUnaryFormula(Operator.nextOperator, formula)), eval, last);
		}
	}
	
	
	
	
	
	//It analyzes the "AlwaysFormula"
	private static <S extends Symbol<?>> Formula<S> always(GloballyFormula<S> formula, Evaluation<S> eval, boolean last){
		
		
		//In case of "epsilonSymbol" return always "trueFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.trueFormula();
		}
		else{
			//Apply "expandBinaryOperator" to the "AndFormula" composed by the "UnaryFormula" associated to the "GloballyFormula" and by the "WeakNextFormula" that has like "UnaryFormula" the original "GloballyFormula" 
			return expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, formula.getUnaryFormula(), FormulaFactory.createUnaryFormula(Operator.weakNextOperator, formula)), eval, last);
		}
	}
	
	
	
	
	//It analyzes the "UntilFormula"
	//aUb
	private static <S extends Symbol<?>> Formula<S> until(UntilFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "falseFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.falseFormula();
		}
		else{
			//Apply "expandBinaryOperator" to the following formula b|(a&X(aUb))
			return expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, formula.getRightSide(), FormulaFactory.createBinaryFormula(Operator.andOperator, formula.getLeftSide(), FormulaFactory.createUnaryFormula(Operator.nextOperator, formula))), eval, last);
		}
	}
	
	
	
	
	
	
	//It analyzes the "ReleaseFormula"
	//aRb
	private static <S extends Symbol<?>> Formula<S> release(ReleaseFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "trueFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.trueFormula();
		}
		else{
			//Apply "expandBinaryOperator" to the following formula b&(a|WX(aRb))
			return expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, formula.getRightSide(), FormulaFactory.createBinaryFormula(Operator.orOperator, formula.getLeftSide(), FormulaFactory.createUnaryFormula(Operator.weakNextOperator, formula))), eval, last);
		}
	}
}
