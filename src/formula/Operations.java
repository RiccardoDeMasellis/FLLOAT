package formula;

import java.util.HashSet;

import evaluations.Evaluation;
import operator.Operator;
import regularExpression.Atom;
import regularExpression.RegularExpression;
import regularExpression.Star;
import regularExpression.Test;
import symbols.Symbol;

public class Operations {
	
//	//The map exploited in order to obtain all the models that satisfy the formula in disjunctive normal form. Not exploited for finding the minimal set of interpretation 
//	private static <S extends Symbol> HashMap<Character,Formula> formulaMap= new HashMap<Character, Formula>();
	
	//Return the formula in negation normal form
	//The boolean flag "pushNegation" is useful in order to understand if I must negate the formula,
	//or only navigate inside it to check if there are negations that must be pushed inside
	public static <S extends Symbol<?>> Formula<S> toNNF(Formula<S> f, boolean pushNegation){
		
		Formula<S> result=null;
		
		//If the formula is a "DoubleImplicationFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method 
		//"toNNF()" of the class "DoubleImplicationFormula"
		//else I rewrite the double implication in term of two "ImplicationFormula" and an "AndFormula"
		//"result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the rewritten "DoubleImplicationFormula"
		if(f instanceof DoubleImplicationFormula<?>){
			if(pushNegation){
				result=((DoubleImplicationFormula<S>) f).toNNF();
			}
			else{
				BinaryFormula<S> leftSide=(BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.implicationOperator,((DoubleImplicationFormula<S>) f).getLeftSide(),((DoubleImplicationFormula<S>) f).getRightSide());
				BinaryFormula<S> rightSide=(BinaryFormula<S>)FormulaFactory.createBinaryFormula(Operator.implicationOperator,((DoubleImplicationFormula<S>) f).getRightSide(),((DoubleImplicationFormula<S>) f).getLeftSide());
				result=FormulaFactory.createBinaryFormula(Operator.andOperator,Operations.toNNF(leftSide, pushNegation),Operations.toNNF(rightSide,pushNegation));
			}
		}
		
		//If the formula is an "ImplicationFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method 
		//"toNNF()" of the class "ImplicationFormula"
		//else I rewrite the implication in term of a "NotFormula" and an "OrFormula"
		//"result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the rewritten "ImplicationFormula"
		if(f instanceof ImplicationFormula<?>){
			if(pushNegation){
				result=((ImplicationFormula<S>) f).toNNF();
			}
			else{
				UnaryFormula<S> leftSide=(UnaryFormula<S>)FormulaFactory.createUnaryFormula(Operator.notOperator, ((ImplicationFormula<S>) f).getLeftSide());
				result=FormulaFactory.createBinaryFormula(Operator.orOperator,Operations.toNNF(leftSide, pushNegation),Operations.toNNF(((ImplicationFormula<S>) f).getRightSide(),pushNegation));
			}
		}
		
		//If the formula is an "AndFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "AndFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the "AndFormula"
		if(f instanceof AndFormula<?>){
			if(pushNegation){
				result=((AndFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createBinaryFormula(Operator.andOperator,Operations.toNNF(((AndFormula<S>) f).getLeftSide(), pushNegation),Operations.toNNF(((AndFormula<S>) f).getRightSide(),pushNegation));
			}
		}
		
		//If the formula is an "OrFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "OrFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the "OrFormula"
		if(f instanceof OrFormula<?>){
			if(pushNegation){
				result=((OrFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createBinaryFormula(Operator.orOperator,Operations.toNNF(((OrFormula<S>) f).getLeftSide(), pushNegation),Operations.toNNF(((OrFormula<S>) f).getRightSide(),pushNegation));
			}
		}
		
		//If the formula is an "ReleaseFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "ReleaseFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the "ReleaseFormula"
		if(f instanceof ReleaseFormula<?>){
			if(pushNegation){
				result=((ReleaseFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createBinaryFormula(Operator.releaseOperator,Operations.toNNF(((ReleaseFormula<S>) f).getLeftSide(), pushNegation),Operations.toNNF(((ReleaseFormula<S>) f).getRightSide(),pushNegation));
			}
		}
		
		//If the formula is an "UntilFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "UntilFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the "UntilFormula"
		if(f instanceof UntilFormula<?>){
			if(pushNegation){
				result=((UntilFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createBinaryFormula(Operator.untilOperator,Operations.toNNF(((UntilFormula<S>) f).getLeftSide(), pushNegation),Operations.toNNF(((UntilFormula<S>) f).getRightSide(),pushNegation));
			}
		}
		
		//If the formula is an "WeakUntilFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method 
		//"toNNF()" of the class "WeakUntilFormula"
		//else I rewrite the implication in term of an "UntilFormula", a "GloballyFormula", and an "OrFormula"
		//"result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formulae that assemble the rewritten "WeakUntilFormula"
		if(f instanceof WeakUntilFormula<?>){
			if(pushNegation){
				result=((WeakUntilFormula<S>) f).toNNF();
			}
			else{
				BinaryFormula<S> leftSide=FormulaFactory.createBinaryFormula(Operator.untilOperator,Operations.toNNF(((WeakUntilFormula<S>) f).getLeftSide(), pushNegation),Operations.toNNF(((WeakUntilFormula<S>) f).getRightSide(), pushNegation));
				UnaryFormula<S> rightSide=FormulaFactory.createUnaryFormula(Operator.globallyOperator, ((WeakUntilFormula<S>) f).getLeftSide());
				result=FormulaFactory.createBinaryFormula(Operator.orOperator,leftSide,Operations.toNNF(rightSide,pushNegation));
			}
		}
		
		//If the formula is an "NextFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "NextFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "NextFormula"
		if(f instanceof NextFormula<?>){
			if(pushNegation){
				result=((NextFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createUnaryFormula(Operator.nextOperator,Operations.toNNF(((NextFormula<S>) f).getUnaryFormula(), pushNegation));
			}
		}
		
		//If the formula is an "WeakNextFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "WeakNextFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "WeakNextFormula"
		if(f instanceof WeakNextFormula<?>){
			if(pushNegation){
				result=((WeakNextFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createUnaryFormula(Operator.weakNextOperator,Operations.toNNF(((WeakNextFormula<S>) f).getUnaryFormula(), pushNegation));
			}
		}
		
		//If the formula is an "GloballyFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "GloballyFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "GloballyFormula"
		if(f instanceof GloballyFormula){
			if(pushNegation){
				result=((GloballyFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createUnaryFormula(Operator.globallyOperator,Operations.toNNF(((GloballyFormula<S>) f).getUnaryFormula(), pushNegation));
			}
		}
		
		//If the formula is an "FinallyFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "FinallyFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "FinallyFormula"
		if(f instanceof EventuallyFormula<?>){
			if(pushNegation){
				result=((EventuallyFormula<S>) f).toNNF();
			}
			else{
				result=FormulaFactory.createUnaryFormula(Operator.eventuallyOperator,Operations.toNNF(((EventuallyFormula<S>) f).getUnaryFormula(), pushNegation));
			}
		}

		//If the formula is an "NotFormula"
		//If "pushNegation" is equal "true",
		//then "result" is equal to call of the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "NotFormula"
		//else
		//if the sub-formula of the "NotFormula" is not an "AtomicFormula",
		//then "result" is equal to call of the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "NotFormula"
		//else
		//(I have an "AtomicFormula") "result" is the "NotFormula" that has the "AtomicFormula" as sub-formula
		if(f instanceof NotFormula<?>){
			if(pushNegation){
				pushNegation=false;
				result=Operations.toNNF(((NotFormula<S>) f).getUnaryFormula(),pushNegation);
			}
			else{
				pushNegation=true;
				
				if(!(((NotFormula<S>) f).getUnaryFormula() instanceof AtomicFormula)){
					result=Operations.toNNF(((NotFormula<S>) f).getUnaryFormula(),pushNegation);
				}
				else{
					if(((NotFormula<S>) f).getUnaryFormula().equals(AtomicFormula.trueFormula())){
						result= AtomicFormula.falseFormula();
					}
					else{
						if(((NotFormula<S>) f).getUnaryFormula().equals(AtomicFormula.falseFormula())){
							result=AtomicFormula.trueFormula();
						}
						else{
							if(((NotFormula<S>) f).getUnaryFormula().equals(AtomicFormula.ttFormula())){
								result=AtomicFormula.ffFormula();
							}
							else{
								if(((NotFormula<S>) f).getUnaryFormula().equals(AtomicFormula.ffFormula())){
									result=AtomicFormula.ttFormula();
								}
								else{
									result=FormulaFactory.createUnaryFormula(Operator.notOperator,((NotFormula<S>) f).getUnaryFormula());
								}
							}
						}
					}					
				}
			}		
		}
		
		//If the formula is an "AtomicFormula"
		//If "pushNegation" is equal "true",
		//If the "AtomicFormula" is equal to "trueFormula", then "result" is the "falseFormula"
		//If the "AtomicFormula" is equal to "falseFormula", then "result" is the "trueFormula"
		//else "result" is the "NotFormula" that has the "AtomicFormula" as sub-formula
		//else ("pushNegation" is equal "false") "result" is equal to the original "AtomicFormula"
		if(f instanceof AtomicFormula<?>){
			if(pushNegation){
				if(f.equals(AtomicFormula.trueFormula())){
					result=AtomicFormula.falseFormula();
				}
				else{
					if(f.equals(AtomicFormula.falseFormula())){
						result=AtomicFormula.trueFormula();
					}
					else{
						if(f.equals(AtomicFormula.ttFormula())){
							result=AtomicFormula.ffFormula();
						}
						else{
							if(f.equals(AtomicFormula.ffFormula())){
								result=AtomicFormula.ttFormula();
							}
							else{
								result=FormulaFactory.createUnaryFormula(Operator.notOperator, f);
							}		
						}	
					}
				}				
			}
			else{
				return f;
			}
		}
		
		//If the formula is a "ldlfNextFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "ldlfNextFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "ldlfNextFormula"
		if(f instanceof LdlfDiamondFormula<?>){
			if(pushNegation){
				result=((LdlfDiamondFormula<S>) f).toNNF();
			}
			else{
				result=new LdlfDiamondFormula<S>(Operations.toNNF(((LdlfDiamondFormula<S>) f).getUnaryFormula(), pushNegation),((LdlfDiamondFormula<S>) f).getExpression());
			}
		}
		
		//If the formula is a "ldlfWeakNextFormula"
		//If I must negate it, then "result" is equal to the result of the call of the method
		//"toNNF()" of the class "ldlfWeakNextFormula"
		//else "result" is equal to the recursive call of the method "toNNF(f,pushNegation)" on the
		//sub-formula that assembles the "ldlfWeakNextFormula"
		if(f instanceof LdlfBoxFormula<?>){
			if(pushNegation){
				result=((LdlfBoxFormula<S>) f).toNNF();
			}
			else{
				result=new LdlfBoxFormula<S>(Operations.toNNF(((LdlfBoxFormula<S>) f).getUnaryFormula(), pushNegation),((LdlfBoxFormula<S>) f).getExpression());
			}
		}	
		
		return result;
	}		
	
	
	//Return the Conjunctive Normal Form of the formula
	public static <S extends Symbol<?>> Formula<S> toCNF(Formula<S> formula){
		
		if(formula instanceof OrFormula<?>){
			
			if(((OrFormula<S>) formula).getLeftSide() instanceof AndFormula<?>){
				AndFormula<S> andSide=(AndFormula<S>)((OrFormula<S>) formula).getLeftSide();
				
				BinaryFormula<S> newLeftSide=FormulaFactory.createBinaryFormula(Operator.orOperator,andSide.getLeftSide(),toCNF(((OrFormula<S>) formula).getRightSide()));
				BinaryFormula<S> newRightSide=FormulaFactory.createBinaryFormula(Operator.orOperator,andSide.getRightSide(),toCNF(((OrFormula<S>) formula).getRightSide()));
				
				return FormulaFactory.createBinaryFormula(Operator.andOperator, toCNF(newLeftSide), toCNF(newRightSide));
			}
			else{
				if(((OrFormula<S>) formula).getRightSide() instanceof AndFormula<?>){
					AndFormula<S> andSide=(AndFormula<S>)((OrFormula<S>) formula).getRightSide();
					
					BinaryFormula<S> newLeftSide=FormulaFactory.createBinaryFormula(Operator.orOperator, toCNF(((OrFormula<S>) formula).getLeftSide()),andSide.getLeftSide());
					BinaryFormula<S> newRightSide=FormulaFactory.createBinaryFormula(Operator.orOperator, toCNF(((OrFormula<S>) formula).getLeftSide()),andSide.getRightSide());
					
					return FormulaFactory.createBinaryFormula(Operator.andOperator, toCNF(newLeftSide), toCNF(newRightSide));
				}
			}
			
		}

		return formula;
	}
	
	//Return the Disjunctive Normal Form
	public static <S extends Symbol<?>> Formula<S> toDNF(Formula<S> formula){
			
		if(formula instanceof AndFormula<?>){
			
			if(((AndFormula<S>) formula).getLeftSide() instanceof OrFormula){
				OrFormula<S> orSide=(OrFormula<S>)((AndFormula<S>) formula).getLeftSide();
				
				BinaryFormula<S> newLeftSide=FormulaFactory.createBinaryFormula(Operator.andOperator,orSide.getLeftSide(),toDNF(((AndFormula<S>) formula).getRightSide()));
				BinaryFormula<S> newRightSide=FormulaFactory.createBinaryFormula(Operator.andOperator,orSide.getRightSide(),toDNF(((AndFormula<S>) formula).getRightSide()));
				
				return FormulaFactory.createBinaryFormula(Operator.orOperator, toDNF(newLeftSide), toDNF(newRightSide));
			}
			else{
				if(((AndFormula<S>) formula).getRightSide() instanceof OrFormula<?>){
					OrFormula<S> orSide=(OrFormula<S>)((AndFormula<S>) formula).getRightSide();
					
					BinaryFormula<S> newLeftSide=FormulaFactory.createBinaryFormula(Operator.andOperator, toDNF(((AndFormula<S>) formula).getLeftSide()),orSide.getLeftSide());
					BinaryFormula<S> newRightSide=FormulaFactory.createBinaryFormula(Operator.andOperator, toDNF(((AndFormula<S>) formula).getLeftSide()),orSide.getRightSide());
					
					return FormulaFactory.createBinaryFormula(Operator.orOperator, toDNF(newLeftSide), toDNF(newRightSide));
				}
			}
			
		}
			
		return formula;
	}
	
	
	
	//Return all the interpretations
	private static <S extends Symbol<?>> HashSet<HashSet<Formula<S>>> findInterpretation(Formula<S> formula){
		//The set of set of formulae, that will be return. The set of interpretation
		HashSet<HashSet<Formula<S>>> interpretation = new HashSet<HashSet<Formula<S>>>(); 
		//Transform the formula in Disjunctive Normal Form
		formula=toDNF(formula);
			
		//If I have an "OrFormula"
		if(formula instanceof OrFormula){
			HashSet<Formula<S>> orInterpretation=new HashSet<Formula<S>>();
			
			//I add to the set "orInterpretation" the "maximalOrInterpretation", the set composed by all the elements that are in "or"
			orInterpretation.addAll((maximalOrInterpretation(formula)));
			
			//For each element of the "orIntrepretation" set I evaluate the "andInterpretation" and add the this set the set "interpretation"
			for(Formula<S> interpretationElement: orInterpretation){
				
				HashSet<Formula<S>> partialInterpretation=new HashSet<Formula<S>>();	
				partialInterpretation.addAll(andInterpretation(interpretationElement));		
				interpretation.add(partialInterpretation);
			}
			
		}
		else{
			//If I have an "AndFormula", then add to "interpretation" the set composed by all sub-formulas that are in and calling the "andInterpretation" function  
			if(formula instanceof AndFormula<?>){
				HashSet<Formula<S>> andInterpretation=new HashSet<Formula<S>>();
				andInterpretation.addAll(andInterpretation(formula));
				interpretation.add(andInterpretation);		
			}
			//If I have a formula different from both "OrFormula" and "AndFormula", then add to "interpretation" the set composed by the formula itself
			else{
				HashSet<Formula<S>> formulaSet=new HashSet<Formula<S>>();
				formulaSet.add(formula);
				interpretation.add(formulaSet);
			}
		}	
		
		return interpretation;
	}
	
	//Return the minimal interpretation
	public static <S extends Symbol<?>> HashSet<HashSet<Formula<S>>> findMinimalInterpretation(Formula<S> formula){
		HashSet<HashSet<Formula<S>>> interpretation=new HashSet<HashSet<Formula<S>>>();
		
		//I find all the interpretation
		interpretation=findInterpretation(formula);
		//I remove all the interpretation useless in order to have the minimal set of interpretation
		interpretation=removeInterpretation(interpretation);
		
		return interpretation;
	}
	
	
	//Remove all the useless interpretation in order to achieve the minimal one
	public static <S extends Symbol<?>> HashSet<HashSet<Formula<S>>> removeInterpretation(HashSet<HashSet<Formula<S>>> interpretation){
		
		//I clone the "interpretation" set passed as parameter in order to not have side effect
		@SuppressWarnings("unchecked")
		HashSet<HashSet<Formula<S>>> clonedInterpretation = (HashSet<HashSet<Formula<S>>>) interpretation.clone();
			
		//For each set of "clonedInterpretation"
		for(HashSet<Formula<S>> toAnalyzeSetElement : clonedInterpretation){
			//For each set of "clonedIntepretation"
			for(HashSet<Formula<S>> toCompareSetElement: clonedInterpretation){
				//I skip the element chosen by the first "for cycle"
				if(!toAnalyzeSetElement.equals(toCompareSetElement)){	
					//If the set contains all the elements of the set that I'm comparing, than I can remove the first element
					if(toAnalyzeSetElement.containsAll(toCompareSetElement)){
						clonedInterpretation.remove(toAnalyzeSetElement);
						return removeInterpretation(clonedInterpretation);
					}
				}
			}
		}
	
	return interpretation;
		
	}
	
	
	//Return all interpretations
	public static <S extends Symbol<?>> HashSet<HashSet<Formula<S>>> findAllInterpretation(Formula<S> formula){
		//The set of set of formulae, that will be return. The set of interpretation
		HashSet<HashSet<Formula<S>>> interpretation=new HashSet<HashSet<Formula<S>>>(); 
		//Transform the formula in Disjunctive Normal Form
		formula=toDNF(formula);
//		//Initialize the map exploited in order to obtain all the models that satisfy the formula
//		formulaMap=initializeMap(formulaMap);
		
		//If I have an "OrFormula"
		if(formula instanceof OrFormula){
			HashSet<Formula<S>> orInterpretation=new HashSet<Formula<S>>();
//			//I map all the sub-formula that are in "or" to a Character in order to obtain the right "interpretation" set
//			formula=mapOrFormulaToChar(formula);
			
			//I add to the set "orInterpretation" the "maximalOrInterpretation", the set composed by all the elements that are in "or"
			orInterpretation.addAll((maximalOrInterpretation(formula)));
			//I construct the power set calling "powersetFormula" in order to obtain all the interpretations that model the "formula" in disjunctive normal form
			interpretation.addAll(powersetFormula(orInterpretation));
			//I remove the empty set, since I don't need it
			interpretation.remove(new HashSet<Formula<S>>());
			
			//I cloned "interpretation" in order to built the real "interpretation" set by replacing each character with the right formula
			@SuppressWarnings("unchecked")
			HashSet<HashSet<Formula<S>>> clonedInterpretation=(HashSet<HashSet<Formula<S>>>) interpretation.clone();		
			interpretation.clear();
			
			//For each set inside "interpretation"
			for(HashSet<Formula<S>> interpretationElement: clonedInterpretation){
				
				HashSet<Formula<S>> partialInterpretation=new HashSet<Formula<S>>();
				
				//For each character inside the above set, I replace it with the interpretation obtained calling "andInterpretation" (since it is surely not an "OrFormula").
				//I use "partialInterpretation" to store and then add the interpretation obtained like i said above to the "interpretation" set
				for(Formula<S> formulaElement: interpretationElement){
					
					AtomicFormula<S> newFormula=(AtomicFormula<S>) formulaElement.clone();	
					partialInterpretation.addAll(andInterpretation(newFormula));
				}
				
				interpretation.add(partialInterpretation);
			}
			
		}
		else{
			//If I have an "AndFormula", then add to "interpretation" the set composed by all sub-formulas that are in and calling the "andInterpretation" function  
			if(formula instanceof AndFormula<?>){
				HashSet<Formula<S>> andInterpretation=new HashSet<Formula<S>>();
				andInterpretation.addAll(andInterpretation(formula));
				interpretation.add(andInterpretation);		
			}
			//If i have a formula different from both "OrFormula" and "AndFormula", then add to "interpretation" the set composed by the formula itself
			else{
				HashSet<Formula<S>> formulaSet=new HashSet<Formula<S>>();
				formulaSet.add(formula);
				interpretation.add(formulaSet);
			}
		}	
		
		return interpretation;
	}
	
	
	
	
	//Return the set composed by the only interpretation available for an "AndFormula"
	private static <S extends Symbol<?>> HashSet<Formula<S>> andInterpretation(Formula<S> formula){
		HashSet<Formula<S>> andInterpretation=new HashSet<Formula<S>>();
		
		if(formula instanceof AndFormula<?>){
			andInterpretation.addAll(andInterpretation(((AndFormula<S>) formula).getLeftSide()));
			andInterpretation.addAll(andInterpretation(((AndFormula<S>) formula).getRightSide()));
			return andInterpretation;
		}
		else{
			andInterpretation.add(formula);
			return andInterpretation;
		}
	}
	
	
	
	
	//Return the set composed by the maximal interpretation available for an "OrFormula"(all the sub-formulae that are in "or")
	private static <S extends Symbol<?>> HashSet<Formula<S>> maximalOrInterpretation(Formula<S> formula){
		HashSet<Formula<S>> orInterpretation=new HashSet<Formula<S>>();
		
		if(formula instanceof OrFormula<?>){
			orInterpretation.addAll(maximalOrInterpretation(((OrFormula<S>) formula).getLeftSide()));
			orInterpretation.addAll(maximalOrInterpretation(((OrFormula<S>) formula).getRightSide()));
			return orInterpretation;
		}
		else{
			orInterpretation.add(formula);
			return orInterpretation;
		}
	}
	
	
	
	
	//Return the power set of a given set of formulae
	public static <S extends Symbol<?>> HashSet<HashSet<Formula<S>>> powersetFormula(HashSet<Formula<S>> list) {
		HashSet<HashSet<Formula<S>>> ps = new HashSet<HashSet<Formula<S>>>();
		ps.add(new HashSet<Formula<S>>());   // add the empty set
			 
		// for every item in the original list
		for (Formula<S> item : list) {
			HashSet<HashSet<Formula<S>>> newPs = new HashSet<HashSet<Formula<S>>>();
			 
			for (HashSet<Formula<S>> subset : ps) {
				// copy all of the current powerset's subsets
				newPs.add(subset);
		 
				// plus the subsets appended with the current item
				HashSet<Formula<S>> newSubset = new HashSet<Formula<S>>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}
			 
			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			ps = newPs;
		}
		return ps;
	}


	
//	//Built the "OrFormulae" with the "AndFormulae" and "UnaryFormulae" replaced by an "AtomicFormula". The Character of this "AtomicFomula" is one of the key for "formulaMap", 
//	//so I can revert this transformation
//	private static Formula mapOrFormulaToChar(Formula formula){
//		
//		if(formula instanceof OrFormula){
//			return FormulaFactory.createBinaryFormula(Operator.orOperator,mapOrFormulaToChar(((OrFormula) formula).getLeftSide()), mapOrFormulaToChar(((OrFormula) formula).getRightSide()));
//		}
//		else{
//			return FormulaFactory.createAtomicFormula(mapPropositionToChar(formula));
//		}
//	}
	

	//	//Return the Character corresponding to the "formula", if it is assigned yet, otherwise assigns a Character to the formula and return it 
//	private static char mapPropositionToChar(Formula formula){
//		
//		char symbol;
//		
//		if(formulaMap.containsValue(formula)){
//			symbol=getKeyByValue(formulaMap,formula).charValue();
//		}
//		else{
//			symbol=getKeyByValue(formulaMap,AtomicFormula.falseFormula());
//			formulaMap.put(symbol, formula);
//		}
//		
//		return symbol;
//	}
	
	
	
	//Given a propositional formula and an evaluation, returns "true" if the symbols model the formula, "false" otherwise
	public static <S extends Symbol<?>> boolean modelPropositionalFormula(Formula<S> formula, Evaluation<S> eval){
		
		boolean result = false;
		
		if(formula instanceof AndFormula){
			result= modelPropositionalFormula(((AndFormula<S>) formula).getLeftSide(),eval) && modelPropositionalFormula(((AndFormula<S>) formula).getRightSide(),eval);
		}
		
		if(formula instanceof OrFormula){
			result= modelPropositionalFormula(((OrFormula<S>) formula).getLeftSide(),eval) || modelPropositionalFormula(((OrFormula<S>) formula).getRightSide(),eval);
		}
		
		if(formula instanceof NotFormula){
			result= !modelPropositionalFormula(((NotFormula<S>) formula).getUnaryFormula(),eval);
		}
		
		if(formula instanceof AtomicFormula){
			
			if(((AtomicFormula<S>) formula).equals(AtomicFormula.trueFormula())){
				result=true;
			}
			else{
				if(((AtomicFormula<S>) formula).equals(AtomicFormula.falseFormula())){
					result=false;
				}
				else{
					if(eval.getEval().contains(((AtomicFormula<S>) formula).getSymbol())){
						result=true;
					}
					else{
						result=false;
					}
				}
				
			}
		}
		
		return result;
	}
	
	
	
	//Given an LTLf formula, returns the corresponding LDLf formula
	public static <S extends Symbol<?>> Formula<S> fromLTLfFormulaToLDLfFormula(Formula<S> formula){
		Formula<S> result = null;
		Formula<S> LTLfLast= FormulaFactory.createUnaryFormula(Operator.weakNextOperator, AtomicFormula.falseFormula());
		
		formula=toNNF(formula,false);
		
		if(formula.equals(LTLfLast)){
			return new LdlfDiamondFormula<S>(new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Test<S>(new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula())))),new Atom<S>(AtomicFormula.trueFormula())); 
		}
		
		if(formula instanceof AtomicFormula<?>){
			if(formula.equals(AtomicFormula.trueFormula())){
				AtomicFormula.trueFormula();
			}
			else{
				if(formula.equals(AtomicFormula.falseFormula())){
					AtomicFormula.falseFormula();
				}
				else{
					result=new AtomicFormula<S>((S)(((AtomicFormula<S>) formula).getSymbol().getSymbol()));
				}
			}
		}
		
		if(formula instanceof NotFormula<?>){
			result=new NotFormula<S>(fromLTLfFormulaToLDLfFormula(((NotFormula<S>) formula).getUnaryFormula()));
		}
		
		if(formula instanceof AndFormula<?>){
			Formula<S> newLeftSide = fromLTLfFormulaToLDLfFormula(((AndFormula<S>) formula).getLeftSide());
			Formula<S> newRightSide = fromLTLfFormulaToLDLfFormula(((AndFormula<S>) formula).getRightSide());
			
			result=FormulaFactory.createBinaryFormula(Operator.andOperator, newLeftSide, newRightSide);
		}
		
		if(formula instanceof OrFormula<?>){
			Formula<S> newLeftSide = fromLTLfFormulaToLDLfFormula(((OrFormula<S>) formula).getLeftSide());
			Formula<S> newRightSide = fromLTLfFormulaToLDLfFormula(((OrFormula<S>) formula).getRightSide());
			
			result=FormulaFactory.createBinaryFormula(Operator.orOperator, newLeftSide, newRightSide);
		}
		
		if(formula instanceof NextFormula<?>){
			Formula<S> insideNextFormula=fromLTLfFormulaToLDLfFormula(((NextFormula<S>) formula).getUnaryFormula());
			RegularExpression<S> e = new Atom<S>(AtomicFormula.trueFormula());
		
			result=new LdlfDiamondFormula<S>(insideNextFormula,e);		
		}
		
		if(formula instanceof WeakNextFormula<?>){
			Formula<S> insideWeakNextFormula=fromLTLfFormulaToLDLfFormula(((WeakNextFormula<S>) formula).getUnaryFormula());
			RegularExpression<S> e = new Atom<S>(AtomicFormula.trueFormula());
			
			result=new LdlfBoxFormula<S>(insideWeakNextFormula,e);
		
		}
		
		if(formula instanceof UntilFormula<?>){
			Formula<S> newLeftSide = fromLTLfFormulaToLDLfFormula(((UntilFormula<S>) formula).getLeftSide());
			Formula<S> newRightSide = fromLTLfFormulaToLDLfFormula(((UntilFormula<S>) formula).getRightSide());
			
			result= new LdlfDiamondFormula<S>(newRightSide,new Star<S>(new Atom<S>(newLeftSide)));
			
		}
		
		if(formula instanceof ReleaseFormula<?>){
			Formula<S> notLeftSide= new NotFormula<S>(((ReleaseFormula<S>) formula).getLeftSide());
			notLeftSide=toNNF(notLeftSide,false);
			Formula<S> notRightSide= new NotFormula<S>(((ReleaseFormula<S>) formula).getRightSide());
			notRightSide=toNNF(notRightSide,false);
			
			Formula<S> newLeftSide = fromLTLfFormulaToLDLfFormula(notLeftSide);
			Formula<S> newRightSide = fromLTLfFormulaToLDLfFormula(notRightSide);
			
			Formula<S> partialResult= new NotFormula<S>(new LdlfDiamondFormula<S>(newRightSide,new Star<S>(new Atom<S>(newLeftSide))));
			
			partialResult=toNNF(partialResult,false);
			
			result=partialResult;
		}
		
		if(formula instanceof EventuallyFormula<?>){
			Formula<S> insideEventuallyFormula=fromLTLfFormulaToLDLfFormula(((EventuallyFormula<S>) formula).getUnaryFormula());
			RegularExpression<S> e = new Star<S>(new Atom<S>(AtomicFormula.trueFormula()));
			
			result=new LdlfDiamondFormula<S>(insideEventuallyFormula,e);
			
		}
		
		if(formula instanceof GloballyFormula<?>){
			Formula<S> insideGloballyFormula=fromLTLfFormulaToLDLfFormula(((GloballyFormula<S>) formula).getUnaryFormula());
			RegularExpression<S> e = new Star<S>(new Atom<S>(AtomicFormula.trueFormula()));
			
			result=new LdlfBoxFormula<S>(insideGloballyFormula,e);
			
		}
		
		if((formula instanceof LdlfBoxFormula<?>)||(formula instanceof LdlfDiamondFormula<?>)){
			result=formula;
		}
		
		return result;
	}
	
	
	public static <S extends Symbol<?>> Formula<S> addTestToDiamondOrBox(Formula<S> formula, String type){
		Formula<S> endFormula=new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Test<S>(new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula()))));
		Formula<S> lastFormula=new LdlfDiamondFormula<S>(new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Test<S>(new LdlfDiamondFormula<S>(AtomicFormula.ttFormula(), new Atom<S>(AtomicFormula.trueFormula())))),new Atom<S>(AtomicFormula.trueFormula())); 
		
		RegularExpression<S> trueTest=new Test<S>(AtomicFormula.trueFormula());
		
		if(formula instanceof BinaryFormula<?>){
			Formula<S> leftResult=addTestToDiamondOrBox(((BinaryFormula<S>) formula).getLeftSide(),type);
			Formula<S> rightResult=addTestToDiamondOrBox(((BinaryFormula<S>) formula).getRightSide(),type);
			
			if ((leftResult instanceof LdlfDiamondFormula<?>)&&(leftResult instanceof LdlfDiamondFormula<?>)&&
					(((LdlfDiamondFormula<S>)leftResult).getExpression().equals(trueTest))&&(((LdlfDiamondFormula<S>)leftResult).getExpression().equals(trueTest))){
				return FormulaFactory.createBinaryFormula(((BinaryFormula<S>) formula).getOperator(), ((LdlfDiamondFormula<S>)leftResult).getUnaryFormula(), ((LdlfDiamondFormula<S>)rightResult).getUnaryFormula());
			}
			else{
				return FormulaFactory.createBinaryFormula(((BinaryFormula<S>) formula).getOperator(), leftResult, rightResult);
			}
		}
		
		if((formula instanceof LdlfBoxFormula<?>)||(formula instanceof LdlfDiamondFormula<?>)){
			
			if(formula.equals(endFormula)){
				return formula;
			}
			else{
				if(formula.equals(lastFormula)){
					return formula;
				}
				else{
					if(type.equals("box")){
						return new LdlfBoxFormula<S>(formula,new Test<S>(AtomicFormula.trueFormula()));
					}
					else{
						if(type.equals("diamond")){
							return new LdlfDiamondFormula<S>(formula,new Test<S>(AtomicFormula.trueFormula()));
						}
					}
				}
			}	
		}
		
		if(((formula instanceof AtomicFormula<?>)||(formula instanceof NotFormula<?>))&&
				!formula.equals(AtomicFormula.ffFormula())&&
				!formula.equals(AtomicFormula.ttFormula())&&
				!formula.equals(AtomicFormula.falseFormula())){
		
			if(type.equals("box")){
				Formula<S> not = new NotFormula<S>(formula);
				not=Operations.toNNF(not, false);
				
				return new LdlfBoxFormula<S>(AtomicFormula.ffFormula(),new Atom<S>(not));
			}
			else{
				if(type.equals("diamond")){
					return formula;
				}
			}
		}
		else{
			return formula;
		}
		
		return null;
	}
	
	//
	//I exploit the following two methods in order to have a cleaner string representation of the formula  
	//
	
	//Remove the useless parenthesis that contain either only either "UnaryFormula" or "AtomicFormula" 
	public static String cleanParenthesis(String stringFormula){
			
		for(int i=0;i<stringFormula.length();i++){
			if(stringFormula.substring(i, i+Operator.openSeparator.length()).equals(Operator.openSeparator)){
				int j=getPosLastPar(i,stringFormula);
				//If the coupled parenthesis do not contain "BinaryFormula", then i can delete them
				if((!stringFormula.substring(i, j+Operator.openSeparator.length()).contains(Operator.andOperator))&&
					(!stringFormula.substring(i, j+Operator.openSeparator.length()).contains(Operator.orOperator))&&
					(!stringFormula.substring(i, j+Operator.openSeparator.length()).contains(Operator.untilOperator))&&
					(!stringFormula.substring(i, j+Operator.openSeparator.length()).contains(Operator.releaseOperator))){
					
					stringFormula=stringFormula.substring(0,i)+stringFormula.substring(i+Operator.openSeparator.length(),j)+stringFormula.substring(j+Operator.closeSeparator.length());
					i=i-Operator.closeSeparator.length();
				}
			}
		}
		
		return stringFormula;
	}
	
	//Return the position of the last useful parenthesis from left to right
	private static int getPosLastPar(int startIndex,String formula){
		int position=0;
		int count=0;
				
		for(int i=startIndex;i<formula.length();i++){
			if(formula.substring(i, i+Operator.openSeparator.length()).equals(Operator.openSeparator)){
				count++;
			}
			if(formula.substring(i, i+Operator.closeSeparator.length()).equals(Operator.closeSeparator)){
				count--;
				if(count==0){
					position=i;
					break;
				}
			}
		}
			
		return position;
	}
}
