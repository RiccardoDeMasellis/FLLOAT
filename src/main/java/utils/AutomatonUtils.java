/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package utils;

import automaton.QuotedFormulaStateFactory;
import automaton.QuotedFormulaStateFactory.QuotedFormulaState;
import evaluations.PropositionLast;
import formula.ldlf.LDLfFormula;
import formula.quotedFormula.QuotedFormula;
import formula.quotedFormula.QuotedVar;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import net.sf.tweety.logics.pl.syntax.Tautology;
import rationals.Automaton;
import rationals.DefaultStateFactory.DefaultState;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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


        // Initialize the data structure for the initial state;
        initialFormula = (LDLfFormula) initialFormula.nnf();
        Set<QuotedVar> initialStateFormulas = new HashSet<>();
        initialStateFormulas.add(new QuotedVar(initialFormula));
        /*
        Creation of the initial state. Notice that method automaton.addState(true, false) calls the
        QuotedFormulaStateFactory for state creation. But it takes two parameters only, so I then have
        to add explicitly the set of formulas belonging to it.
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
        Set<PossibleWorld> allModels = new Tautology().getModels(ps);
        for (PossibleWorld w : allModels) {
            Transition<PossibleWorld> t = new Transition(finalState, w, finalState);
            try {
                automaton.addTransition(t);
            } catch (NoSuchStateException e) {
                e.printStackTrace();
            }
        }

        // Cycle on states yet to be analyzed
        while (!toAnalyze.isEmpty()) {
            QuotedFormulaState currentState = toAnalyze.getFirst();
            // Conjunction of the QuotedVar belonging to the current state
            QuotedFormula currentFormula = currentState.getQuotedConjunction();

            // For each propositional interpretation, call the delta function on currentFormula
            for (PossibleWorld world : allModels) {
                QuotedFormula deltaResult = currentFormula.delta(world);
                // Compute the minimal interpretations satisfying deltaResult, that is, all the q'
                Set<Set<QuotedVar>> newStateSetFormulas = deltaResult.getMinimalModels();

                for (Set<QuotedVar> newStateFormulas : newStateSetFormulas) {
                    //Add the new state if new, or give me the already existing one with the same Set<QuotedVar>
                    QuotedFormulaState destinationState = getStateIfExists(automaton, newStateFormulas);
                    if (destinationState == null) {
                        destinationState = (QuotedFormulaState) stateFactory.create(false, false, newStateFormulas);
                        toAnalyze.addLast(destinationState);
                    }
                    // Add the transition (currentState, world, destinationState)
                    Transition<PossibleWorld> t = new Transition<>(currentState, world, destinationState);
                    try {
                        automaton.addTransition(t);
                    } catch (NoSuchStateException e) {
                        e.printStackTrace();
                    }
                }
            }
            toAnalyze.remove(currentState);
        }
        return automaton;
    }


    private static QuotedFormulaState getStateIfExists(Automaton a, Set<QuotedVar> sqv) {
        QuotedFormulaState result = null;
        Set<QuotedFormulaState> states = a.states();
        for (QuotedFormulaState s : states) {
            if (s.getFormulaSet().equals(sqv))
                return s;
        }
        return result;
    }


    // Version for DefaultStateFactory
    /**
     * Returns <a href="http://www.research.att.com/sw/tools/graphviz/" target="_top">Graphviz Dot</a>
     * representation of this automaton.
     */
    /*
    Warning here! After using any transformation methods of jautomata, a new automaton with the
	DefaultStateFactory is returned! So this method
	*/
//    public static String quotedFormulaAutomaton2Dot(Automaton a) {
//        StringBuilder b = new StringBuilder("digraph Automaton {\n");
//        b.append("  rankdir = LR;\n");
//        Set<QuotedFormulaState> states = a.states();
//        for (QuotedFormulaState s : states) {
//
//            String stateFormulas = s.getFormulaSet().toString();
//            b.append("  ").append(stateFormulas);
//            if (s.isTerminal())
//                b.append(" [shape=doublecircle,label=\""+stateFormulas+"\"];\n");
//            else
//                b.append(" [shape=circle,label=\""+stateFormulas+"\"];\n");
//            if (s.isInitial()) {
//                b.append("  initial [shape=plaintext,label=\""+stateFormulas+"\"];\n");
//                b.append("  initial -> ").append(stateFormulas).append("\n");
//            }
//            Set<Transition> trans = a.delta(s);
//            for (Transition t : trans) {
//                appendDotTransition(b, t);
//            }
//        }
//        return b.append("}\n").toString();
//    }
//
//
//    private static void appendDotTransition(StringBuilder b, Transition t) {
//        b.append("  ").append(((QuotedFormulaState) t.start()).getFormulaSet());
//
//        QuotedFormulaState arrivalState = (QuotedFormulaState)t.end();
//
//        b.append(" -> ").append(arrivalState.getFormulaSet()).append(" [label=\"");
//
//        b.append(t.label().toString());
//
//        b.append("\"]\n");
//    }


    // Version for DefaultStateFactory

    /**
     * Returns <a href="http://www.research.att.com/sw/tools/graphviz/" target="_top">Graphviz Dot</a>
     * representation of this automaton.
     */
    public static String toDot(Automaton a) {
        StringBuilder b = new StringBuilder("digraph Automaton {\n");
        b.append("  rankdir = LR;\n");
        Set<State> states = a.states();
        for (State s : states) {

			/* Warning here! After using any transformation methods of jautomata, a new automaton with the
            DefaultStateFactory is returned! */
            DefaultState fs = (DefaultState) s;

            String stateNumber = fs.getObject().toString();
            b.append("  ").append(stateNumber);
            if (fs.isTerminal())
                b.append(" [shape=doublecircle,label=\"" + stateNumber + "\"];\n");
            else
                b.append(" [shape=circle,label=\"" + stateNumber + "\"];\n");
            if (fs.isInitial()) {
                b.append("  initial [shape=plaintext,label=\"" + stateNumber + "\"];\n");
                b.append("  initial -> ").append(stateNumber).append("\n");
            }
            Set<Transition> trans = a.delta(fs);
            for (Transition t : trans) {
                appendDotTransition(b, t);
            }
        }
        return b.append("}\n").toString();
    }


    private static void appendDotTransition(StringBuilder b, Transition t) {
        b.append("  ").append(((DefaultState) t.start()).getObject());

        DefaultState arrivalState = (DefaultState) t.end();

        b.append(" -> ").append(arrivalState.getObject()).append(" [label=\"");

        b.append(t.label().toString());

        b.append("\"]\n");
    }

}
