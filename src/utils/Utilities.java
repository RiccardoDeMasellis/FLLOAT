package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import evaluations.EpsilonEvaluation;
import evaluations.Evaluation;
import rationals.Automaton;
import rationals.DefaultStateFactory.DefaultState;
import rationals.Transition;
import rationals.State;
import symbols.Symbol;
import alternating.FormulaStateFactory.*;

public class Utilities {


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
			DefaultState fs = (DefaultState)s;
			
			String stateNumber = fs.getObject().toString();
			b.append("  ").append(stateNumber);
			if (fs.isTerminal())
				b.append(" [shape=doublecircle,label=\""+stateNumber+"\"];\n");
			else
				b.append(" [shape=circle,label=\""+stateNumber+"\"];\n");
			if (fs.isInitial()) {
				b.append("  initial [shape=plaintext,label=\""+stateNumber+"\"];\n");
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
		b.append("  ").append(((DefaultState)t.start()).getObject());

		DefaultState arrivalState = (DefaultState)t.end();
		
		b.append(" -> ").append(arrivalState.getObject()).append(" [label=\"");

		b.append(t.label().toString());

		b.append("\"]\n");
	}


	private static <S extends Symbol<?>> Set<Set<S>> powerSet(Set<S> originalSet) {
		Set<Set<S>> sets = new HashSet<>();
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<>());
			return sets;
		}
		List<S> list = new ArrayList<>(originalSet);
		S head = list.get(0);
		Set<S> rest = new HashSet<>(list.subList(1, list.size()));
		for (Set<S> set : powerSet(rest)) {
			Set<S> newSet = new HashSet<>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}		
		return sets;
	}


	// It also adds the EpsilonEvaluation!
	public static <S extends Symbol<?>> Set<Evaluation<S>> evalPowerSet(Set<S> originalSet) {
		Set<Set<S>> setsetS = powerSet(originalSet);
		Set<Evaluation<S>> result = new HashSet<>();

		for (Set<S> setEval : setsetS) {
			Evaluation<S> eval = new Evaluation<>(setEval);
			result.add(eval);
		}

		result.add(new EpsilonEvaluation());
		return result;
	}









}
