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
import evaluations.PropositionLast;
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
import java.util.*;

/**
 * Created by Riccardo De Masellis on 15/07/15.
 */
public class AutomatonUtils {

    public static Automaton ldlf2Automaton(LDLfFormula initialFormula, PropositionalSignature ps) {

        //Add last to the signature
        ps.add(new PropositionLast());

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
        // Add the initial state to the set of state to be analyzed
        toAnalyze.add(initialState);

        /*
        Analogously for the initial state, I initialize data structure for the final state
        which contains the empty set of quoted formulas (empty conjunction stands for true).
        */
        QuotedFormulaState finalState = (QuotedFormulaState) stateFactory.create(false, true, new HashSet<>());
        /*
        All transitions loop in the final state. Hence I get all possible models for the signature
        and then add a transition for each one of them.
         */
        Set<TransitionLabel> allLabels = new HashSet<>();
        Set<PossibleWorld> allModels = new Tautology().getModels(ps);

        // Translates PossibleWorlds in PossibleWorldsWrap
        for (PossibleWorld p : allModels) {
            // The magic of inheritance!!!
            allLabels.add(new PossibleWorldWrap(p));
        }

        /*
        Add the emptyTrace to the set of possible labels!
         */
        allLabels.add(new EmptyTrace());

        /*
        All transition loops in the final state AND in the false state
         */
        for (TransitionLabel w : allLabels) {
            Transition<TransitionLabel> t1 = new Transition(finalState, w, finalState);
            Transition<TransitionLabel> t2 = new Transition(falseState, w, falseState);
            try {
                automaton.addTransition(t1);
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
                            toAnalyze.addLast(destinationState);
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
        //return automaton;
        return eliminateLastTransitions(automaton);
    }


    private static Automaton eliminateLastTransitions(Automaton oldAut) {
        Set<State> oldStates = oldAut.states();
        Set<Transition<TransitionLabel>> oldTransitions = oldAut.delta();

        Automaton newAut = new Automaton();

        Map<State, State> oldToNew = new HashMap<>();

        //Add all states
        for (State oldSt : oldStates) {
            State newSt = newAut.addState(oldSt.isInitial(), oldSt.isTerminal());
            oldToNew.put(oldSt, newSt);
        }

        // Add the new "ended" state
        State ended = newAut.addState(false, true);

        //Add the *right* transitions according to the transformations
        for (Transition<TransitionLabel> oldTran : oldTransitions) {
            State oldStart = oldTran.start();
            State oldEnd = oldTran.end();
            TransitionLabel oldLabel = oldTran.label();
            TransitionLabel newLabel;
            Transition<TransitionLabel> newTran;

            if (oldLabel instanceof EmptyTrace) {
                newLabel = new EmptyTrace();
                newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));
                if(! newAut.delta().contains(newTran)) {
                    try {
                        newAut.addTransition(newTran);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                newLabel = new PossibleWorldWrap((PossibleWorldWrap) oldLabel);
                // Remove proposition last from the label!
                ((PossibleWorldWrap) newLabel).remove(new PropositionLast());


                //Check if the transition must lead to "ended" state
                if (((PossibleWorldWrap)oldLabel).contains(new PropositionLast()) && oldEnd.isTerminal())
                    newTran = new Transition<>(oldToNew.get(oldStart), newLabel, ended);
                else
                    newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));

                // Check if the transitions already exists in the new automaton
                if(! newAut.delta().contains(newTran)) {
                    try {
                        newAut.addTransition(newTran);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return newAut;
    }


    /*
    To be called AFTER eliminateLastTransition!!!
     */
    public static Automaton eliminateEmptyTrace(Automaton oldAut) {
        Set<State> oldStates = oldAut.states();
        Set<Transition<TransitionLabel>> oldTransitions = oldAut.delta();

        Automaton newAut = new Automaton();

        Map<State, State> oldToNew = new HashMap<>();

        //Add all states
        for (State oldSt : oldStates) {
            State newSt = newAut.addState(oldSt.isInitial(), oldSt.isTerminal());
            oldToNew.put(oldSt, newSt);
        }

        for (Transition<TransitionLabel> oldTran : oldTransitions) {
            State oldStart = oldTran.start();
            State oldEnd = oldTran.end();
            TransitionLabel oldLabel = oldTran.label();

            if (oldLabel instanceof EmptyTrace) {
                if (oldEnd.isTerminal())
                    oldToNew.get(oldStart).setTerminal(true);
            }

            else {
                Transition newTran = new Transition<>(oldToNew.get(oldStart), oldLabel, oldToNew.get(oldEnd));
                // Check if the transitions already exists in the new automaton
                if(! newAut.delta().contains(newTran)) {
                    try {
                        newAut.addTransition(newTran);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return newAut;
    }



    private static Automaton eliminateLastTransitionsDeclare(Automaton oldAut) {
        Set<State> oldStates = oldAut.states();
        Set<Transition<TransitionLabel>> oldTransitions = oldAut.delta();

        Automaton newAut = new Automaton();

        Map<State, State> oldToNew = new HashMap<>();

        //Add all states
        for (State oldSt : oldStates) {
            State newSt = newAut.addState(oldSt.isInitial(), oldSt.isTerminal());
            oldToNew.put(oldSt, newSt);
        }

        // Add the new "ended" state
        State ended = newAut.addState(false, true);

        //Add the *right* transitions according to the transformations
        for (Transition<TransitionLabel> oldTran : oldTransitions) {
            State oldStart = oldTran.start();
            State oldEnd = oldTran.end();
            TransitionLabel oldLabel = oldTran.label();
            TransitionLabel newLabel;
            Transition<TransitionLabel> newTran;

            if (oldLabel instanceof EmptyTrace) {
                newLabel = new EmptyTrace();
                newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));
                if(! newAut.delta().contains(newTran)) {
                    try {
                        newAut.addTransition(newTran);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                newLabel = new PossibleWorldWrap((PossibleWorldWrap) oldLabel);
                // Remove proposition last from the label!
                ((PossibleWorldWrap) newLabel).remove(new PropositionLast());


                // WARNING! For Declare only!
                if (!((PossibleWorldWrap) newLabel).isEmpty()) {
                    //Check if the transition must lead to "ended" state
                    if (((PossibleWorldWrap) oldLabel).contains(new PropositionLast()) && oldEnd.isTerminal())
                        newTran = new Transition<>(oldToNew.get(oldStart), newLabel, ended);
                    else
                        newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));

                    // Check if the transitions already exists in the new automaton
                    if (!newAut.delta().contains(newTran)) {
                        try {
                            newAut.addTransition(newTran);
                        } catch (NoSuchStateException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return newAut;
    }


    /**
     * Only to be used with ProM. Returns the automaton which transitions contain ONE event only.
     * @param oldAut
     * @return
     */
    public static Automaton declareAssumption(Automaton oldAut) {
        Set<State> oldStates = oldAut.states();
        Set<Transition<TransitionLabel>> oldTransitions = oldAut.delta();

        Automaton newAut = new Automaton();

        Map<State, State> oldToNew = new HashMap<>();

        //Add all states
        for (State oldSt : oldStates) {
            State newSt = newAut.addState(oldSt.isInitial(), oldSt.isTerminal());
            oldToNew.put(oldSt, newSt);
        }

        for (Transition<TransitionLabel> oldTran : oldTransitions) {
            State oldStart = oldTran.start();
            State oldEnd = oldTran.end();
            TransitionLabel oldLabel = oldTran.label();
            TransitionLabel newLabel;
            Transition<TransitionLabel> newTran;

            if (oldLabel instanceof EmptyTrace) {
                newLabel = new EmptyTrace();
                newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));
                if(! newAut.delta().contains(newTran)) {
                    try {
                        newAut.addTransition(newTran);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                //Check if the transitions contains an event only.
                if (((PossibleWorldWrap) oldLabel).size() == 1) {
                    newLabel = new PossibleWorldWrap((PossibleWorldWrap) oldLabel);
                    newTran = new Transition<>(oldToNew.get(oldStart), newLabel, oldToNew.get(oldEnd));

                    // Check if the transitions already exists in the new automaton
                    if(! newAut.delta().contains(newTran)) {
                        try {
                            newAut.addTransition(newTran);
                        } catch (NoSuchStateException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        return newAut;
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


    /*
    It builds the automaton considering only interpretation with a single variable true (declare assumption).
     */
    public static Automaton ldlf2AutomatonDeclare(LDLfFormula initialFormula, PropositionalSignature ps) {

        //Add last to the signature
        ps.add(new PropositionLast());

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
        // Add the initial state to the set of state to be analyzed
        toAnalyze.add(initialState);

        /*
        Analogously for the initial state, I initialize data structure for the final state
        which contains the empty set of quoted formulas (empty conjunction stands for true).
        */
        QuotedFormulaState finalState = (QuotedFormulaState) stateFactory.create(false, true, new HashSet<>());
        /*
        All transitions loop in the final state. Hence I get all possible models for the signature
        and then add a transition for each one of them.
         */


        Set<TransitionLabel> allLabels = new HashSet<>();

        /*
        Declare just needs interpretation with a single variable set to true.
         */
        for (Proposition prop : ps) {
            HashSet<Proposition> singlePropSet = new HashSet<>();
            HashSet<Proposition> singlePropSetLast = new HashSet<>();
            singlePropSet.add(prop);
            singlePropSetLast.add(prop);
            singlePropSetLast.add(new PropositionLast());
            PossibleWorld p = new PossibleWorld(singlePropSet);
            PossibleWorld pl = new PossibleWorld(singlePropSetLast);
            allLabels.add(new PossibleWorldWrap(p));
            allLabels.add(new PossibleWorldWrap(pl));
        }

        /*
        Add the emptyTrace to the set of possible labels!
         */
        allLabels.add(new EmptyTrace());

        /*
        All transition loops in the final state AND in the false state
         */
        for (TransitionLabel w : allLabels) {
            Transition<TransitionLabel> t1 = new Transition(finalState, w, finalState);
            Transition<TransitionLabel> t2 = new Transition(falseState, w, falseState);
            try {
                automaton.addTransition(t1);
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
                            toAnalyze.addLast(destinationState);
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
        //return automaton;
        return eliminateLastTransitionsDeclare(automaton);
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
