/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package utils;

import automaton.EmptyTrace;
import automaton.PossibleWorldWrap;
import automaton.QuotedFormulaStateFactory;
import automaton.QuotedFormulaStateFactory.QuotedFormulaState;
import automaton.TransitionLabel;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import net.sf.tweety.logics.pl.syntax.Tautology;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Riccardo De Masellis on 15/07/15.
 */
public class AutomatonUtils {


    public static Automaton ldlf2Automaton(boolean declare, LDLfFormula initialFormula, PropositionalSignature ps) {

        // Automaton initialization: empty automaton
        QuotedFormulaStateFactory stateFactory = new QuotedFormulaStateFactory();
        Automaton automaton = new Automaton(stateFactory);
        stateFactory.setAutomaton(automaton);

        /*
        Algorithm data structures
         */
        LinkedList<QuotedFormulaState> toAnalyze = new LinkedList<>();

        /*
        Initialize the data structure for the "false" state.
         */
        QuotedFormulaState falseState = (QuotedFormulaState) stateFactory.create(false, false, null);


        // Initialize the data structure for the initial state;
        initialFormula = (LDLfFormula) initialFormula.nnf();
        Set<QuotedVar> initialStateFormulas = new HashSet<>();
        initialStateFormulas.add(new QuotedVar(initialFormula));

        /*
        Creation of the initial state.
         */
        QuotedFormulaState initialState = (QuotedFormulaState) stateFactory.create(true, false, initialStateFormulas);
        // Check if initialState is final by calling delta(emptyTrace) on its initialStateFormulas!
        initialState.setTerminal(checkIfFinal(initialState));
        // Add the initial state to the set of state to be analyzed
        toAnalyze.add(initialState);

        /*
        Get all possible models for the signature and depending on the declare assumption.
         */
        Set<TransitionLabel> allLabels = buildAllLables(declare, ps);

        /*
        All transition loops in the false state
         */
        for (TransitionLabel w : allLabels) {
            Transition<TransitionLabel> t2 = new Transition(falseState, w, falseState);
            try {
                automaton.addTransition(t2);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        // Cycle on states yet to be analyzed
        while (!toAnalyze.isEmpty()) {
            QuotedFormulaState currentState = toAnalyze.getFirst();
            // Conjunction of the QuotedVar belonging to the current state
            QuotedFormula currentFormula = currentState.getQuotedConjunction();

            // For each possible label, call the delta function on currentFormula
            for (TransitionLabel label : allLabels) {
                QuotedFormula deltaResult = currentFormula.delta(label);
                // Compute the minimal interpretations satisfying deltaResult, that is, all the q'
                Set<Set<QuotedVar>> newStateSetFormulas = deltaResult.getMinimalModels();

                // newStateFormulas empty means that the current interpretation lead to the "false" state.
                if (newStateSetFormulas.isEmpty()) {
                    // Add the transition (currentState, world, falseState)
                    Transition<TransitionLabel> t = new Transition<>(currentState, label, falseState);
                    try {
                        automaton.addTransition(t);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }

                // Otherwise the transition DOES NOT lead to the false state.
                else {
                    for (Set<QuotedVar> newStateFormulas : newStateSetFormulas) {
                        //Add the new state if new, or give me the already existing one with the same Set<QuotedVar>
                        QuotedFormulaState destinationState = getStateIfExists(automaton, newStateFormulas);
                        if (destinationState == null) {
                            destinationState = (QuotedFormulaState) stateFactory.create(false, false, newStateFormulas);
                            // Check if destinationState is final by calling delta(emptyTrace) on its newStateFormulas!
                            if (newStateFormulas.isEmpty()) {
                                destinationState.setTerminal(true);
                            /*
                            If is the final state where state formulas are empty, then add all looping transition.
                             */
                                for (TransitionLabel tl: allLabels) {
                                    Transition<TransitionLabel> tr = new Transition(destinationState, tl, destinationState);
                                    try {
                                        automaton.addTransition(tr);
                                    } catch (NoSuchStateException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            else {
                                destinationState.setTerminal(checkIfFinal(destinationState));
                                toAnalyze.addLast(destinationState);
                            }
                        }

                        // Add the transition (currentState, world, destinationState)
                        Transition<TransitionLabel> t = new Transition<>(currentState, label, destinationState);
                        try {
                            automaton.addTransition(t);
                        } catch (NoSuchStateException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
            toAnalyze.remove(currentState);
        }
        return automaton;
    }


    private static Set<TransitionLabel> buildAllLables(boolean declare, PropositionalSignature ps) {
        Set<TransitionLabel> allLabels = new HashSet<>();

        if(declare) {
            for (Proposition prop : ps) {
                HashSet<Proposition> singlePropSet = new HashSet<>();
                singlePropSet.add(prop);
                PossibleWorld p = new PossibleWorld(singlePropSet);
                allLabels.add(new PossibleWorldWrap(p));
            }
        }
        else {
            Set<PossibleWorld> allModels = new Tautology().getModels(ps);

            // Translates PossibleWorlds in PossibleWorldsWrap
            for (PossibleWorld p : allModels) {
                // The magic of inheritance!!!
                allLabels.add(new PossibleWorldWrap(p));
            }
        }
        return allLabels;
    }



    private static boolean checkIfFinal(QuotedFormulaState destinationState) {
        if (destinationState.getFormulaSet().isEmpty())
            return true;

        /*
        Create the emptyTrace special label!
         */
        TransitionLabel emptyTrace = new EmptyTrace();
        QuotedFormula currentFormula = destinationState.getQuotedConjunction();
        QuotedFormula deltaResult = currentFormula.delta(emptyTrace);

        Set<Set<QuotedVar>> allMinimalModels = deltaResult.getMinimalModels();

        if (allMinimalModels.isEmpty())
            return false;

        else {
            for (Set<QuotedVar> model : allMinimalModels) {
                if (model.isEmpty())
                    return true;
            }
        }

        return false;
    }



    private static QuotedFormulaState getStateIfExists(Automaton a, Set<QuotedVar> sqv) {
        QuotedFormulaState result = null;
        Set<QuotedFormulaState> states = a.states();
        for (QuotedFormulaState s : states) {
            if (s.getFormulaSet() != null && s.getFormulaSet().equals(sqv))
                return s;
        }
        return result;
    }




    /**
     * Returns <a href="http://www.research.att.com/sw/tools/graphviz/" target="_top">Graphviz Dot</a>
     * representation of this automaton.
     */
    public static String toDot(Automaton a) {
        StringBuilder b = new StringBuilder("digraph Automaton {\n");
        b.append("  rankdir = LR;\n");
        Set<State> states = a.states();
        for (State s : states) {

            String stateString = s.toString();
            b.append("  ").append(stateString);
            if (s.isTerminal())
                b.append(" [shape=doublecircle,label=\"" + stateString + "\"];\n");
            else
                b.append(" [shape=circle,label=\"" + stateString + "\"];\n");
            if (s.isInitial()) {
                b.append("  initial [shape=plaintext,label=\"" + stateString + "\"];\n");
                b.append("  initial -> ").append(stateString).append("\n");
            }
            Set<Transition> trans = a.delta(s);
            for (Transition t : trans) {
                appendDotTransition(b, t);
            }
        }
        return b.append("}\n").toString();
    }



    private static void appendDotTransition(StringBuilder b, Transition t) {
        b.append("  ").append((t.start()).toString());

        State arrivalState = t.end();

        b.append(" -> ").append(arrivalState.toString()).append(" [label=\"");

        b.append(t.label().toString());

        b.append("\"]\n");
    }


    public static Automaton removeUnreachableStates(Automaton original){
        Automaton res = new Automaton();

        Set<State> initials = original.initials();
        HashMap<State, State> oldToNewStates = new HashMap<>();

        for (State i : initials){
            State newI = res.addState(i.isInitial(), i.isTerminal());
            oldToNewStates.put(i, newI);
        }

        Set<State> toBeVisited = new HashSet<>();
        toBeVisited.addAll(initials);

        while (!toBeVisited.isEmpty()){
            State oldStart = toBeVisited.iterator().next();
            toBeVisited.remove(oldStart);

            HashSet<State> newTBV = new HashSet<>();

            Set<Transition> oldTransitions = original.delta(oldStart);

            for (Transition oldT : oldTransitions){
                State oldEnd = oldT.end();
                State newEnd = oldToNewStates.get(oldEnd);

                if (newEnd == null){
                    newEnd = res.addState(oldEnd.isInitial(), oldEnd.isTerminal());
                    oldToNewStates.put(oldEnd, newEnd);
                    newTBV.add(oldEnd);
                }

                Transition newT = new Transition(oldToNewStates.get(oldStart), oldT.label(), newEnd);

                try {
                    res.addTransition(newT);
                } catch (NoSuchStateException e) {
                    e.printStackTrace();
                }
            }

            toBeVisited.addAll(newTBV);
        }

        return res;
    }

    public static void printAutomaton(Automaton automaton, String fileName) {
        /*
        Printing to .gv (graphviz) file
         */
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrintStream ps = new PrintStream(fos);
        ps.println(utils.AutomatonUtils.toDot(automaton));
        ps.flush();
        ps.close();
    }

}
