/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package RuntimeVerification;

import automaton.EmptyTrace;
import automaton.PossibleWorldWrap;
import automaton.TransitionLabel;
import net.sf.tweety.logics.pl.syntax.Proposition;
import rationals.Automaton;
import rationals.State;
import rationals.Transition;
import rationals.transformations.ToDFA;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Riccardo De Masellis on 05/10/15.
 */

/**
 * This class is for runtime verification purposes. It simply contains the reference to the current
 * state of the automaton.
 * ASSUMPTIONS:
 * 1) The automaton is deterministic (it is always possible to determinize it);
 *
 * 2) It has one initial state only (notice that, due to our algorithm, the
 * initial state is always unique.)
 *
 * 3) Each state has one outgoing transition for each element of the powerset of the set of symbols, i.e.,
 * for each propositional interpretation to the set of symbols. The automaton has hence to be constructed
 * with the complete set of symbols that it is possible to receive (even though they do not appear in the
 * formula).
 *
 * This class essentially provides an interface for ProM.
 */
public class ExecutableAutomaton {

    private Automaton automaton;
    private State currentState;


    public ExecutableAutomaton(Automaton automaton) {
        if(automaton.initials().size() > 1)
            throw new RuntimeException("The input automaton has more than one initial state!");

        // Reduction and determinization of the automaton.
        this.automaton = new ToDFA<>().transform(automaton);
        Set<State> initials = this.automaton.initials();
        Iterator it = initials.iterator();
        this.currentState = (State) it.next();
    }


    public State step(String eventName) {
        TransitionLabel label;
        if (eventName.equals("EmptyTrace")) {
            label = new EmptyTrace();
        }
        else {
            Proposition event = new Proposition(eventName);
            Set<Proposition> eventSet = new HashSet<>();
            eventSet.add(event);
            label = new PossibleWorldWrap(eventSet);
        }
        return step(label);
    }


    public State step(TransitionLabel label) {
        Set<State> startingState = this.automaton.getStateFactory().stateSet();
        startingState.add(currentState);
        Set<State> arrivalStates = this.automaton.step(startingState, label);

        if (arrivalStates.size() != 1)
            throw new RuntimeException("Something went wrong in performing the transition: either no arrival state or more than one (i.e., nondeterministic automaton)");

        Iterator it = arrivalStates.iterator();
        State arrival = (State) it.next();

        //Update current state, i.e., perform the transition
        setCurrentState(arrival);

        return arrival;
    }


    private void setCurrentState(State currentState) {
        this.currentState = currentState;
    }


    /**
     * Given a state, returns the RV truth value of that state performing the usual reachability analysis of final states
     * from that one.
     * @param state
     * @return
     */
    public RVTruthValue stateRVTruthValue(State state) {
        Set<State> accessibleStates = this.automaton.accessibleStates(state);

        boolean allAccessibleAreTerminal = true;

        for (State s : accessibleStates) {
            if(!s.isTerminal())
                allAccessibleAreTerminal = false;
        }

        boolean allAccessibleAreNotTerminal = true;
        for (State s : accessibleStates) {
            if(s.isTerminal())
                allAccessibleAreNotTerminal = false;
        }

        if(state.isTerminal()) {
            if(allAccessibleAreTerminal)
                return new RVTrue();
            else
                return new RVTempTrue();
        }

        else {
            if(allAccessibleAreNotTerminal)
                return new RVFalse();
            else
                return new RVTempFalse();
        }
    }

    public RVTruthValue currentRVTruthValue() {
        return stateRVTruthValue(this.currentState);
    }


    /**
     * Given a state, returns the set of outgoing transitions that DOES NOT lead to a RVFalse state.
     * @param state
     * @return
     */
    public Set<Transition<TransitionLabel>> notFailingOutgoingTransitions(State state) {
        Set<Transition<TransitionLabel>> outgoing = this.automaton.delta(state);
        Set<Transition<TransitionLabel>> result = new HashSet<>();

        for (Transition<TransitionLabel> t : outgoing) {
            State destState = t.end();
            if (! this.stateRVTruthValue(destState).equals(new RVFalse()))
                result.add(t);
        }
        return result;
    }


    /**
     * Only to be used for ProM. It returns the set of SINGLE EVENT transitions (as Strings) that DOES NOT lead to a
     * RVFalse state from the current state.
     * @return
     */
    public Set<String> notFailingEvents() {
        Set<String> result = new HashSet<>();
        Set<Transition<TransitionLabel>> goodTransitions = this.notFailingOutgoingTransitions(currentState);

        for (Transition<TransitionLabel> t : goodTransitions) {
            TransitionLabel label = t.label();
            if (label instanceof PossibleWorldWrap) {
                Proposition[] events = (Proposition[]) ((PossibleWorldWrap)label).toArray();
                if(events.length==1)
                    result.add(events[0].toString());
            }
        }
        return result;
    }

    public State getCurrentState() {
        return currentState;
    }
}
