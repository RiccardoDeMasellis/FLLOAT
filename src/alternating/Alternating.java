package alternating;

import alternating.FormulaStateFactory.FormulaState;
import evaluations.EpsilonEvaluation;
import evaluations.Evaluation;
import evaluations.TrueEvaluation;
import formula.*;
import formula.ldlf.EndedAtomicFormula;
import formula.operator.Operator;
import formula.propositional.FalsePropFormula;
import formula.propositional.TruePropFormula;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.Transition;
import rationals.transformations.Pruner;
import rationals.transformations.ToDFA;
import symbols.Alphabet;
import symbols.Symbol;

import java.util.HashSet;
import java.util.Set;


public class Alternating<S extends Symbol<?>> {

    //Since the "finalState" is unique I can make it "static"
    private FormulaState<S> finalState;
    //Since the "endedState" is unique I can make it "static"
    private FormulaState<S> endState;

    //The set that will contains all the states of the automaton
    private HashSet<FormulaState<S>> stateSet;

    //The set that will contains all the formulae not yet analyzed
    private HashSet<HashSet<Formula<S>>> pendingFormulae;

    private HashSet<Formula<S>> falseSet;

    private Automaton automaton;

    //The map exploited in order to built the transition of the automaton, since it requires a char
    //public HashMap<Character,HashSet<Symbol<S>>> symbolSetMap= new HashMap<Character, HashSet<Symbol<S>>>();


    public Alternating() {
        this.finalState = null;
        this.endState = null;
        this.stateSet = new HashSet<FormulaState<S>>();
        this.pendingFormulae = new HashSet<HashSet<Formula<S>>>();
        this.falseSet = new HashSet<Formula<S>>();
        FormulaStateFactory stateFactory = new FormulaStateFactory();
        this.automaton = new Automaton(stateFactory);
        stateFactory.setAutomaton(automaton);
    }


    /**
     * @param formula
     * @param alphabet    the alphabet of the formula obtained with method visitor.getAlphabet();
     * @param formulaType
     * @param symbolClass
     * @return
     */
    public Automaton nonDeterministicFromAlternating(Formula<S> formula, Alphabet<S> alphabet, FormulaType formulaType, Class<S> symbolClass) {

        formula = Operations.toNNF(formula, false);

        //I initialize the "fomulaSet" for the "initialState"
        HashSet<Formula<S>> formulaSet = new HashSet<Formula<S>>();
        formulaSet.add(formula);

        //I initialize the "initialState" with the NNF formula.
        /* Notice that automaton.addState calls the stateFactory, so I know that
		 * the returned state is a LabeledState. Then I have to manually add the formula
		 * to the new State.
		 */
        FormulaState<S> initialState = (FormulaState<S>) automaton.addState(true, false);
        initialState.setFormulaSet(formulaSet);

        //Add "initialState" to the set of states
        stateSet.add(initialState);

        //I add "initialState" formula to the pending formulae set
        pendingFormulae.add(formulaSet);

        //I initialize the "finalState" with the "trueFormula"
        finalState = (FormulaState<S>) automaton.addState(false, true);

        finalState.addFormula(new TruePropFormula<>());

        // Add a loop transition in the true state.
        TrueEvaluation trueEval = new TrueEvaluation();
        Transition t = new Transition(finalState, trueEval, finalState);
        try {
            automaton.addTransition(t);
        } catch (NoSuchStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //I add the final state to the set of the the states, but not to the pending formulae states,
        //since it can not have outgoing edges, except for the "true" loop edge.
        stateSet.add(finalState);


        //Initializing the "endedState"
        FormulaState<S> endState = (FormulaState<S>) automaton.addState(false, true);
        endState.addFormula(new EndedAtomicFormula<>());

        //I add the final state to the set of the state, but not to the pending formulae states,
        //since it can not have outgoing edges
        stateSet.add(endState);

        falseSet.add(new FalsePropFormula<>());

        //I initialize the variables for formulas to be analyzed, and for processed state
        HashSet<Formula<S>> formulaToAnalyze = null;
        FormulaState<S> stateUnderStudy = null;


//		initializeMap(symbolSetMap);

        // Building the set of evaluations given the formula alphabet.
        Set<Evaluation<S>> evaluations = utils.Utilities.evalPowerSet(alphabet.getAlphabet());


        //Per Marco Grasso, alphabet.words sono le possibili interpretazioni per i simboli nell'alfabeto.


        //The loop will be executed until the set of pending formulae is not empty
        while (!pendingFormulae.isEmpty()) {

            //I take an element of "pendingFormulae" and set "formulaToAnalyze" to this value
            CycleForFormula:
            for (HashSet<Formula<S>> firstElement : pendingFormulae) {
                formulaToAnalyze = firstElement;
                break CycleForFormula;
            }


            //I take the state associated to "formulaToAnalyze" and set "stateUnderStudy" to this value
            CycleForState:
            for (FormulaState<S> currentState : stateSet) {
                if (formulaToAnalyze.equals(currentState.getFormulaSet())) {
                    stateUnderStudy = currentState;
                    break CycleForState;
                }
            }


            //I instantiate the formula "toAnalyze" and an array in order to convert the "formulaToAnalyze" set into an array
            Formula<S> toAnalyze = null;
            Formula<S>[] arrayFormula;

            //If the size of "formulaToAnalyze" is greater than "1" then I assign to "toAnalyze" the "and" of all the formulae of the set,
            //else, "toAnalyze" is the only formula inside "formulaToAnalyze".
            if (formulaToAnalyze.size() > 1) {
                arrayFormula = (Formula<S>[]) formulaToAnalyze.toArray(new Formula[formulaToAnalyze.size()]);

                Formula<S> left;
                Formula<S> right;

                for (int i = arrayFormula.length - 1; i >= 1; i--) {
                    if (i == arrayFormula.length - 1) {
                        left = arrayFormula[i - 1];
                        right = arrayFormula[i];
                    } else {
                        left = arrayFormula[i - 1];
                        right = toAnalyze;
                    }
                    toAnalyze = FormulaFactory.createBinaryFormula(Operator.andOperator, left, right);
                }
            } else {
                for (Formula<S> f : formulaToAnalyze) {
                    toAnalyze = f;
                }
            }


            //For each evaluation eval, check if the formula is satisfied by e (both as if it is the last symbol and if it is not the last symbol)
            for (Evaluation<S> eval : evaluations) {

                Formula<S> firstCase = null;

                //Example
                //a is the last symbol
                //If "ltlf" is "true", then call "alternatingTransition" of "LTLfTransitionFunction",
                //else, call "alternatingTransition" of "LDLfTransitionFunction"

                switch (formulaType) {
                    case LTLF:
                        firstCase = LTLfTransitionFunction.alternatingTransition(toAnalyze, eval, true);
                        break;

                    case LDLF:
                        firstCase = LDLfTransitionFunction.alternatingTransition(toAnalyze, eval, true);
                        break;
                }

                EpsilonEvaluation epsilonEval = new EpsilonEvaluation();

                //Since the "Symbol" must be the last one, then, If the resulting formula is the "trueFormula",
                //I call "fromFormulaeToAutomata" that will create the transition between "stateUnderStudy" and the endState,
                //otherwise I do nothing
                if (firstCase.equals(new TruePropFormula<>())) {
                    fromFormulaeToAutomata(stateUnderStudy, endState.getFormulaSet(), eval);
                }

                if (!eval.equals(epsilonEval)) {
                    Formula<S> secondCase = null;
                    //Example
                    //a is not the last symbol
                    //If "ltlf" is "true", then call "alternatingTransition" of "LTLfTransitionFunction",
                    //else, call "alternatingTransition" of "LDLfTransitionFunction"
                    switch (formulaType) {
                        case LTLF:
                            secondCase = LTLfTransitionFunction.alternatingTransition(toAnalyze, eval, false);
                            break;

                        case LDLF:
                            secondCase = LDLfTransitionFunction.alternatingTransition(toAnalyze, eval, false);
                            break;
                    }

                    //If "secondCase" is equal "trueFormula", then I call "fromFormulaeToAutomata", that will create the transition between the "stateUnderStudy" and
                    //the "finalState",
                    //else, if "secondCase" is equal "falseFormula", then I call "fromFormulaeToAutomata", that will do nothing,
                    //else, calling "findInterpretation" I find all the model that satisfy the "secondCase" formula and for each of these, I call "fromFormulaeToAutomata",
                    //that will create the transition between "stateUnderStudy" and the state with associated the corresponding model "element"
                    if (secondCase.equals(new TruePropFormula<>())) {
                        fromFormulaeToAutomata(stateUnderStudy, finalState.getFormulaSet(), eval);
                    } else {
                        if (secondCase.equals(new FalsePropFormula<>())) {
                            fromFormulaeToAutomata(stateUnderStudy, falseSet, eval);
                        } else {
                            //The set of interpretation of second case
                            HashSet<HashSet<Formula<S>>> interpretationSet = Operations.findMinimalInterpretation(secondCase);

                            for (HashSet<Formula<S>> element : interpretationSet) {
                                //I call "fromFormulaeToAutomata" for each model that satisfy the "secondCase" formula
                                fromFormulaeToAutomata(stateUnderStudy, element, eval);
                            }
                        }
                    }
                }
            }

            //Once I arrive here, I can remove the formula from pendingFormulae, since I have just evaluated it
            pendingFormulae.remove(formulaToAnalyze);

        }
		
		/* Warning here! After using any transformation methods of jautomata, a new automaton built with the
		DefaultStateFactory is returned! */
        Pruner p = new Pruner();
        automaton = p.transform(automaton);

        ToDFA todfa = new ToDFA();
        automaton = todfa.transform(automaton);

        return automaton;
    }


    //Must take a set of Formulae
    private void fromFormulaeToAutomata(FormulaState<S> stateUnderStudy, HashSet<Formula<S>> destinationStateFormula, Evaluation<S> eval) {

        //Boolean flag, that is "true" if the state corresponding to the "destinationStateFormula" is already been created
        boolean exist = false;

        //The "destinationState" of the transition
        FormulaState<S> destinationState = null;

        //If "stateSet" contains a state with the formula equal to "destinationStateFormula", then "destinationState" is set to
        //the state taken by "stateSet" and "exist" is set to "true"
        CycleForDestinationState:
        for (FormulaState<S> currentState : stateSet) {
            if (currentState.getFormulaSet().equals(destinationStateFormula)) {
                destinationState = currentState;
                exist = true;
                break CycleForDestinationState;
            }
        }

        //If "destinationStateFormula" is equal to the "falseFormula" I do nothing
        if (!destinationStateFormula.equals(falseSet)) {

            //If "destinationStateFormula" is equal to the "trueFormula", then I create a new transition labeled by "TransitionLabel"
            //with destination "finalState" and add this transition to the "stateUnderStudy"
            if (destinationStateFormula.equals(finalState.getFormulaSet())) {

                Transition transition = new Transition(stateUnderStudy, eval, finalState);
                try {
                    automaton.addTransition(transition);
                } catch (NoSuchStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            //If "destinationStateFormula" is different from "trueFormula", then
            //if "exist=true", then I create a new transition labeled by "TransitionLabel" with destination "destinationState" and add this transition to "stateUnderStudy"
            //if "exist!=true", then I create a new state with associated "destinationStateFormula", create a transition with destination "destinationState",
            //add this transition to "stateUnderStudy", and add "destinationState" to "stateSet" and "destinationStateFormula" to "pendingFormulae"
            else {

                if (exist == true) {

                    Transition transition = new Transition(stateUnderStudy, eval, destinationState);
                    try {
                        automaton.addTransition(transition);
                    } catch (NoSuchStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else {
                    destinationState = (FormulaState<S>) automaton.addState(false, false);
                    destinationState.setFormulaSet(destinationStateFormula);

                    Transition transition = new Transition(stateUnderStudy, eval, destinationState);
                    try {
                        automaton.addTransition(transition);
                    } catch (NoSuchStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    stateSet.add(destinationState);

                    pendingFormulae.add(destinationStateFormula);
                }
            }
        }
    }


//	//Instantiate an HashMap in order to associate at each subset of element of an alphabet a Character
//	private static void initializeMap(HashMap<Character,HashSet<Symbol>> map){
//		
//		for(int ch=33;ch<=64;++ch){
//			map.put(new Character((char) ch), new HashSet<Symbol>());
//		}
//		for(int ch=91;ch<=126;++ch){
//			map.put(new Character((char) ch), new HashSet<Symbol>());
//		}
//		for(int ch=161;ch<=255;++ch){
//			map.put(new Character((char) ch), new HashSet<Symbol>());
//		}
//	}
//	
//	//Return the key of the map, given a set of Symbols	
//	public static Character getKeyByValue(HashMap<Character, HashSet<Symbol>> map, HashSet<Symbol> set) {
//	    for (Entry<Character, HashSet<Symbol>> entry : map.entrySet()) {
//	        if (set.equals(entry.getValue())) {
//	            return entry.getKey();
//	        }
//	    }
//	    return null;
//	}
//		
//	//Return the Character corresponding to the "formula", if it is assigned yet, otherwise assigns a Character to the formula and return it 
//	private static char mapSetOfSymbolToChar(HashSet<Symbol> symbolSet){
//			
//		char symbol;
//		
//		if(symbolSetMap.containsValue(symbolSet)){
//			symbol=getKeyByValue(symbolSetMap,symbolSet).charValue();
//		}
//		else{
//			symbol=getKeyByValue(symbolSetMap,new HashSet<Symbol>());
//			symbolSetMap.put(symbol, symbolSet);
//		}
//			
//		return symbol;
//	}	


}
