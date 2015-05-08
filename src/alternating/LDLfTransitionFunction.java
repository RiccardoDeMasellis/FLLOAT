package alternating;

import java.util.HashSet;

import operator.Operator;
import regularExpression.*;
import symbols.Symbol;
import evaluations.EpsilonEvaluation;
import evaluations.Evaluation;
import formula.*;

public class LDLfTransitionFunction {
	
	//If the formula is a "BinaryFormula" then return the result of the call of "expandBinaryOperator(formula,symbol,last)"
	//else
	//return the result of the call of "evaluate(formula,symbol,last)"
	public static <S extends Symbol<?>> Formula<S> alternatingTransition(Formula<S> formula, Evaluation<S> eval, boolean last){
			
		formula = Operations.toNNF(formula, false);
		
		if(formula instanceof BinaryFormula){
			return expandBinaryOperator(formula, eval, last);
		}
		else{
			return evaluate(formula, eval, last);
		}	
	}
		
	
	
	
	//Analyzing the type of the "Formula" return the result of the call of the right method
	private static <S extends Symbol<?>> Formula<S> expandBinaryOperator(Formula<S> formula, Evaluation<S> eval, boolean last){
			
		Formula<S> result=null;
			
		if(formula instanceof AndFormula){return and((AndFormula<S>) formula, eval, last);}
		if(formula instanceof OrFormula){return or((OrFormula<S>) formula, eval, last);}
			
		return result;
	}
		
	
	
	
	
	//Analyzing the type of the "Formula" return the result of the call of the right method
	private static <S extends Symbol<?>> Formula<S> evaluate(Formula<S> formula, Evaluation<S> eval, boolean last){
			
		Formula<S> result=null;
			
		if(formula instanceof LdlfDiamondFormula){return ldlfDiamond((LdlfDiamondFormula<S>) formula, eval, last);}
			
		if(formula instanceof LdlfBoxFormula){return ldlfBox((LdlfBoxFormula<S>) formula, eval, last);}
			
		if(formula instanceof NotFormula){return notFormula((NotFormula<S>) formula, eval, last);}
			
		if(formula instanceof AtomicFormula){return atomicFormula((AtomicFormula<S>) formula, eval, last);}
			
		return result;
	}
		
	
	
	//If I have the "ttFormula", then return the "trueFormula"
	//else, if I have the "ffFormula", then return the "falseFormula"
	//else, if the "symbol" model the atomic formula, then return "trueFormula", else return the "falseFormula"
	private static <S extends Symbol<?>> Formula<S> atomicFormula(AtomicFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return "trueFormula" if formula is equal to "ttFormula",
		//return false, if formula is equal to "ffFormula"
		//return false, for every other cases
		if(eval instanceof EpsilonEvaluation){
			if(formula.equals(AtomicFormula.ttFormula())){
				return AtomicFormula.trueFormula();
			}
			else{
				if(formula.equals(AtomicFormula.ffFormula())){
					return AtomicFormula.falseFormula();
				}
				else{
					return AtomicFormula.falseFormula();
				}
			}
		}
		else{
			if(formula.equals(AtomicFormula.ttFormula())){
				return AtomicFormula.trueFormula();
			}
			else{
				if(formula.equals(AtomicFormula.ffFormula())){
					return AtomicFormula.falseFormula();
				}
				else{
					if(Operations.modelPropositionalFormula(formula, eval)){
						return AtomicFormula.trueFormula();
					}
					else{
						return AtomicFormula.falseFormula();
					}
				}
			}
		}
	}
		
	
	
	
	//If the symbol model the "NotFormula" return the "trueFormula", else return the "falseFormula"
	private static <S extends Symbol<?>> Formula<S> notFormula(NotFormula<S> formula, Evaluation<S> eval, boolean last){
		
		//In case of "epsilonSymbol" return always "trueFormula"
		if(eval instanceof EpsilonEvaluation){
			return AtomicFormula.trueFormula();		
		}
		else{
			if(formula.equals(AtomicFormula.ttFormula())){
				return AtomicFormula.trueFormula();
			}
			else{
				if(formula.equals(AtomicFormula.ffFormula())){
					return AtomicFormula.falseFormula();
				}
				else{
					if(Operations.modelPropositionalFormula(formula, eval)){
						return AtomicFormula.trueFormula();
					}
					else{
						return AtomicFormula.falseFormula();
					}
				}
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
			
			leftResult = (AtomicFormula<S>) leftResult;
			
			//if the "leftResult" is equal to "falseFormula", then stop the computation and return "falseFormula", else evaluate the "rigthSide" of the "AndFormula"
			if(leftResult.equals(AtomicFormula.falseFormula())){
				result = AtomicFormula.falseFormula();
			}
			else{
				rightResult = alternatingTransition(formula.getRightSide(), eval, last);
					
				//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
				if(rightResult instanceof AtomicFormula){
					
					rightResult = (AtomicFormula<S>) rightResult;
						
					//if the "rightResult" is equal to "falseFormula", then stop the computation and return "falseFormula"
					if(rightResult.equals(AtomicFormula.falseFormula())){
						result = AtomicFormula.falseFormula();
					}
					
					else{				
						//If both "rightResult" and "leftResult" are equal to "trueFormula", then return "trueFormula"
						if((leftResult.equals(AtomicFormula.trueFormula()))&&
							(rightResult.equals(AtomicFormula.trueFormula()))){
							result = AtomicFormula.trueFormula();
						}
							
						//If both "leftResult" and "rightResult" are different from "trueFormula"
						if(!(leftResult.equals(AtomicFormula.trueFormula()))&&
								!(rightResult.equals(AtomicFormula.trueFormula()))){
							//If leftElement and rightElement are equal, then return only one of them, else result is equal to the call of "checkIsPartOf"
							if (leftResult.equals(rightResult)){
								result = leftResult;
							}
							else{
								result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);		
							}
						}
							
						//If "leftResult" is different from "trueFormula", and "rightResult" is equal to "trueFormula", then return the "leftResult"
						if(!(leftResult.equals(AtomicFormula.trueFormula()))&&
								(rightResult.equals(AtomicFormula.trueFormula()))){
							result = leftResult;
						}
						
						//If "rightResult" is different from "trueFormula", and "leftResult" is equal to "trueFormula", then return the "rightResult"
						if((leftResult.equals(AtomicFormula.trueFormula()))&&
								!(rightResult.equals(AtomicFormula.trueFormula()))){
							result = rightResult;
						}
					}	
				}
				else{
					//leftResult is an "AtomicFormula" different from "falseFormula"
					//rightResult is not an "AtomicFormula"
					//If leftResult is equal "trueFormula" return "rightResult"
					if(leftResult.equals(AtomicFormula.trueFormula())){
						result = rightResult;
					}
					//else "leftResult" is an "AtomicFormula" different from "trueFormula" and "rightResult" is not an "AtomicFormula", 
					//then result is equal to the call of "checkIsPartOf"
					else{
						result = FormulaFactory.createBinaryFormula(Operator.andOperator, leftResult, rightResult);
					}
				}
			}
		}
		else{
			//leftResult is not an "AtomicFormula" (surely is different from "falseFormula")
			rightResult = alternatingTransition(formula.getRightSide(),eval,last);
			
			//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
			if(rightResult instanceof AtomicFormula){
				
				rightResult = (AtomicFormula<S>) rightResult;
				
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
			
		leftResult = alternatingTransition(formula.getLeftSide(),eval,last);
		
		//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "leftSide" of the formula is an "AtomicFormula"
		if(leftResult instanceof AtomicFormula){
				
			leftResult=(AtomicFormula<S>) leftResult;
				
			//if the "leftResult" is equal to "trueFormula", then stop the computation and return "trueFormula", else evaluate the "rigthSide" of the "OrFormula"
			if(leftResult.equals(AtomicFormula.trueFormula())){
				result=AtomicFormula.trueFormula();
			}
			else{
				rightResult = alternatingTransition(formula.getRightSide(),eval,last);
	
				//If the result of the "alternatingTransition(formula,symbol,last)" applied to the "rigthSide" of the formula is an "AtomicFormula"
				if(rightResult instanceof AtomicFormula){
					
					rightResult=(AtomicFormula<S>) rightResult;
					
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
				
				rightResult=(AtomicFormula<S>) rightResult;
				
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
	
	
	
	//It analyzes "ldlfDiamondFormula" for all the possible cases
	private static <S extends Symbol<?>> Formula<S> ldlfDiamond(LdlfDiamondFormula<S> formula, Evaluation<S> eval, boolean last){
		
		Formula<S> result=null;
		//In case of "epsilonTransition"
		if(eval instanceof EpsilonEvaluation){
			
			//If the expression inside the "LDLfDiamondFormula" is a "Test", then return the evaluation of the and between the formula
			//inside the "Test" Operator and the formula outside the diamond
			if(formula.getExpression() instanceof Test){
				
				Formula<S> newFormula = Operations.toNNF(((Test<S>) formula.getExpression()).getFormula(), false);
				result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newFormula, formula.getUnaryFormula()), eval, last);
			}
			else{
				//If the expression inside the "LDLfDiamondFormula" is an "Or", then return the evaluation of the or between the two "LDLfDiamondFormula" obtained
				//by separation of the two expression
				if(formula.getExpression() instanceof Or){
					
					LdlfDiamondFormula<S> newLeftSide= new LdlfDiamondFormula<S>(formula.getUnaryFormula(), ((Or<S>) formula.getExpression()).getLeftSide());
					LdlfDiamondFormula<S> newRightSide= new LdlfDiamondFormula<S>(formula.getUnaryFormula(), ((Or<S>) formula.getExpression()).getRightSide());
					
					result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, newLeftSide, newRightSide), eval, last);
				}
				else{
					//If the expression inside the "LDLfDiamondFormula" is a "Concatenation", then return the evaluation of the "LDLfDiamondFormula" that have as expression
					//the first expression of the concatenation and as formula outside the diamond the "LDLfDiamondFormula" with as expression the second expression
					//of the concatenation and as formula outside the diamond the original formula outside the diamond
					if(formula.getExpression() instanceof Concatenation){
						
						RegularExpression<S> firstExpression= ((Concatenation<S>) formula.getExpression()).getLeftSide();
						RegularExpression<S> secondExpression=((Concatenation<S>) formula.getExpression()).getRightSide();
						LdlfDiamondFormula<S> f=new LdlfDiamondFormula<S>(formula.getUnaryFormula(),secondExpression);
						
						result = alternatingTransition(new LdlfDiamondFormula<S>(f, firstExpression), eval, last);
					}
					else{
						//If the expression inside the "LDLfDiamondFormula" is a Star, then return the formula outside the diamond
						if(formula.getExpression() instanceof Star){
							result=alternatingTransition(formula.getUnaryFormula(), eval, last);
						}
						else{
							//In any other case, return the "falseFormula"
							result=AtomicFormula.falseFormula();		
						}
					}
				}
			}		
		}
		else{
			//If the expression inside the "LDLfDiamondFormula" is a "Test", then return the evaluation of the and between the formula
			//inside the "Test" Operator and the formula outside the diamond
			if(formula.getExpression() instanceof Test){
				
				Formula<S> newFormula=Operations.toNNF(((Test<S>) formula.getExpression()).getFormula(), false);
				
				result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newFormula, formula.getUnaryFormula()), eval, last);
			}
			else{
				//If the expression inside the "LDLfDiamondFormula" is an "Or", then return the evaluation of the or between the two "LDLfDiamondFormula" obtained
				//by separation of the two expression
				if(formula.getExpression() instanceof Or){
					
					LdlfDiamondFormula<S> newLeftSide= new LdlfDiamondFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getLeftSide());
					LdlfDiamondFormula<S> newRightSide= new LdlfDiamondFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getRightSide());
					
					result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, newLeftSide, newRightSide), eval, last);
				}
				else{
					//If the expression inside the "LDLfDiamondFormula" is a "Concatenation", then return the evaluation of the "LDLfDiamondFormula" that have as expression
					//the first expression of the concatenation and as formula outside the diamond the "LDLfDiamondFormula" with as expression the second expression
					//of the concatenation and as formula outside the diamond the original formula outside the diamond
					if(formula.getExpression() instanceof Concatenation){
						
						RegularExpression<S> firstExpression= ((Concatenation<S>) formula.getExpression()).getLeftSide();
						RegularExpression<S> secondExpression=((Concatenation<S>) formula.getExpression()).getRightSide();
						LdlfDiamondFormula<S> f = new LdlfDiamondFormula<S>(formula.getUnaryFormula(), secondExpression);
						
						result = alternatingTransition(new LdlfDiamondFormula<S>(f, firstExpression), eval, last);
					}
					else{
						//If the expression inside the "LDLfDiamondFormula" is a Star and the expression inside the LDLfDiamondFormula 
						//is a "Test only", then return the formula outside the diamond
						//else return the evaluation of the "or" between the formula outside the diamond and the "LDLfDiamondFormula" that has as expression, the
						//original expression without the star operator, and as formula the original formula
						if(formula.getExpression() instanceof Star){
							if(RegExpOperations.isTestOnly((((Star<S>) formula.getExpression()).getExpression()))){
								result = alternatingTransition(formula.getUnaryFormula(), eval, last);
							}
							else{
		
								RegularExpression<S> insideStar= ((Star<S>) formula.getExpression()).getExpression();
								
								result = expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator, formula.getUnaryFormula(), new LdlfDiamondFormula<S>(formula,insideStar)), eval, last);
							}
						}
						else{
							//In case of "Atom" as expression
							if(formula.getExpression() instanceof Atom){
								//If "last" is "true" and the "symbol" model the formula associated to the "Atom", then return the result of the evaluation
								//for the "espilonSymbol"
								//else if "last" is "false" and the "symbol" model the formula associated to the "Atom", then return the formula associated to the "Atom"
								//else return the "falseFormula"
								if((last==true)&&(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(), eval)==true)){
									
									result = alternatingTransition(formula.getUnaryFormula(), new EpsilonEvaluation(), last);
								}
								else{
									if((last==false)&&(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(), eval)==true)){
										if(formula.getUnaryFormula().equals(AtomicFormula.ttFormula())){
											result= AtomicFormula.trueFormula();
										}
										else{
											if(formula.getUnaryFormula().equals(AtomicFormula.ffFormula())){
												result= AtomicFormula.falseFormula();
											}
											else{
												result= formula.getUnaryFormula();
											}
										}
									}
									else{
										if(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(), eval)==false){
											result=AtomicFormula.falseFormula();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
		
	
	
	
	
	//It analyzes "LdlfBoxFormula" for all the possible cases
	private static <S extends Symbol<?>> Formula<S> ldlfBox(LdlfBoxFormula<S> formula, Evaluation<S> eval, boolean last){
		
		Formula<S> result=null;
		//In case of "epsilonTransition"
		if(eval instanceof EpsilonEvaluation){
			
			//If the expression inside the "LdlfBoxFormula" is a "Test", then return the evaluation of the and between the negation of the formula
			//inside the "Test" Operator and the formula outside the box
			if(formula.getExpression() instanceof Test){
				
				NotFormula<S> notFormula=new NotFormula<S>(((Test<S>) formula.getExpression()).getFormula());
				Formula<S> leftFormula=Operations.toNNF(notFormula, false);

				result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator,leftFormula,formula.getUnaryFormula()),eval,last);
			}
			else{
				//If the expression inside the "LdlfBoxFormula" is an "Or", then return the evaluation of the or between the two "LdlfBoxFormula" obtained
				//by separation of the two expression
				if(formula.getExpression() instanceof Or){
					
					LdlfBoxFormula<S> newLeftSide= new LdlfBoxFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getLeftSide());
					LdlfBoxFormula<S> newRightSide= new LdlfBoxFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getRightSide());
					
					result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newLeftSide, newRightSide),eval,last);
				}
				else{
					//If the expression inside the "LdlfBoxFormula" is a "Concatenation", then return the evaluation of the "LdlfBoxFormula" that have as expression
					//the first expression of the concatenation and as formula outside the box the "LdlfBoxFormula" with as expression the second expression
					//of the concatenation and as formula outside the box the original formula outside the box
					if(formula.getExpression() instanceof Concatenation){
						
						RegularExpression<S> firstExpression= ((Concatenation) formula.getExpression()).getLeftSide();
						RegularExpression<S> secondExpression=((Concatenation) formula.getExpression()).getRightSide();
						LdlfBoxFormula<S> f=new LdlfBoxFormula<S>(formula.getUnaryFormula(),secondExpression);
						
						result= alternatingTransition(new LdlfBoxFormula<S>(f,firstExpression),eval,last);
					}
					else{
						//If the expression inside the "LdlfBoxFormula" is a Star, then return the formula outside the box
						if(formula.getExpression() instanceof Star){
							result=alternatingTransition(formula.getUnaryFormula(),eval,last);
						}
						else{
							//In any other case, return the "trueFormula"
							result=AtomicFormula.trueFormula();
						}
					}
				}
			}
		}
		else{
			//If the expression inside the "LdlfBoxFormula" is a "Test", then return the evaluation of the and between the negation of the formula
			//inside the "Test" Operator and the formula outside the box
			if(formula.getExpression() instanceof Test){
				
				NotFormula<S> notFormula=new NotFormula<S>(((Test<S>) formula.getExpression()).getFormula());
				Formula<S> leftFormula=Operations.toNNF(notFormula, false);
				
				result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.orOperator,leftFormula,formula.getUnaryFormula()),eval,last);
			}
			else{
				//If the expression inside the "LdlfBoxFormula" is an "Or", then return the evaluation of the or between the two "LdlfBoxFormula" obtained
				//by separation of the two expression
				if(formula.getExpression() instanceof Or){
					
					LdlfBoxFormula<S> newLeftSide= new LdlfBoxFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getLeftSide());
					LdlfBoxFormula<S> newRightSide= new LdlfBoxFormula<S>(formula.getUnaryFormula(),((Or<S>) formula.getExpression()).getRightSide());
					
					result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, newLeftSide, newRightSide),eval,last);
				}
				else{
					//If the expression inside the "LdlfBoxFormula" is a "Concatenation", then return the evaluation of the "LdlfBoxFormula" that have as expression
					//the first expression of the concatenation and as formula outside the box the "LdlfBoxFormula" with as expression the second expression
					//of the concatenation and as formula outside the box the original formula outside the box
					if(formula.getExpression() instanceof Concatenation){
						
						RegularExpression<S> firstExpression= ((Concatenation<S>) formula.getExpression()).getLeftSide();
						RegularExpression<S> secondExpression=((Concatenation<S>) formula.getExpression()).getRightSide();
						LdlfBoxFormula<S> f=new LdlfBoxFormula<S>(formula.getUnaryFormula(),secondExpression);
						
						result= alternatingTransition(new LdlfBoxFormula<S>(f,firstExpression),eval,last);
					}
					else{
						//If the expression inside the "LdlfBoxFormula" is a Star and the expression inside the LdlfBoxFormula 
						//is a "Test only", then return the formula outside the box
						//else return the evaluation of the "and" between the formula outside the box and the "LdlfBoxFormula" that has as expression, the
						//original expression without the star operator, and as formula the original formula
						if(formula.getExpression() instanceof Star){
							if(RegExpOperations.isTestOnly((((Star<S>) formula.getExpression()).getExpression()))){
								result= alternatingTransition(formula.getUnaryFormula(),eval,last);
							}
							else{
								RegularExpression<S> insideStar= ((Star<S>) formula.getExpression()).getExpression();
								
								result= expandBinaryOperator(FormulaFactory.createBinaryFormula(Operator.andOperator, formula.getUnaryFormula(), new LdlfBoxFormula<S>(formula,insideStar)),eval,last);
							}
						}
						else{
							//In case of "Atom" as expression
							if(formula.getExpression() instanceof Atom){
								//If "last" is "true" and the "symbol" model the formula associated to the "Atom", then return the result of the evaluation
								//for the "espilonSymbol"
								//else if "last" is "false" and the "symbol" model the formula associated to the "Atom", then return the formula associated to the "Atom"
								//else return the "trueFormula"
								if((last==true)&&(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(),eval)==true)){
									
									result= alternatingTransition(formula.getUnaryFormula(), new EpsilonEvaluation(), last);
								}
								else{
									if((last==false)&&(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(),eval)==true)){
										if(formula.getUnaryFormula().equals(AtomicFormula.ttFormula())){
											result= AtomicFormula.trueFormula();
										}
										else{
											if(formula.getUnaryFormula().equals(AtomicFormula.ffFormula())){
												result= AtomicFormula.falseFormula();
											}
											else{
												result= formula.getUnaryFormula();
											}
										}
									}
									else{
										if(Operations.modelPropositionalFormula(((Atom<S>)formula.getExpression()).getFormula(),eval)==false){
											result=AtomicFormula.trueFormula();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}		
}
