package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.transition.Transition;
import main.metamodel.transition.TransitionBuilder;

import java.util.*;

public class StateMachine {
	private Map<String,State> states = new HashMap<>();
	private Map<String,Integer> integers = new HashMap<>();
	private State currentState;
	private State initialState;
	private TransitionBuilder transitionBuilder = new TransitionBuilder();
	private Transition currentTransition;

	public Machine build() {
		return new Machine(states.values(), initialState, integers);
	}

	private State getState(String name) {
		if(!states.containsKey(name)) states.put(name, new State(name));
		return states.get(name);
	}

	public StateMachine state(String string) {
		currentState = getState(string);
		return this;
	}

	public StateMachine initial() {
		initialState = currentState;
		return this;
	}

	public StateMachine when(String string) {
		transitionBuilder.setEvent(string);
		return this;
	}

	public StateMachine to(String string) {
		transitionBuilder.setTransitionTarget(getState(string));
		currentTransition = transitionBuilder.build();
		currentState.addTransition(currentTransition);
		return this;
	}

	public StateMachine integer(String string) {
		integers.put(string, 0);
		return this;
	}

	private Transition getLatestTransition() {
		List<Transition> transitions = currentState.getTransitions();
		return transitions.get(transitions.size() - 1);
	}

	public StateMachine set(String operationVariable, int operationValue) {
		transitionBuilder.addSetOperation(operationVariable, operationValue, getLatestTransition());
		return this;
	}

	public StateMachine increment(String operationVariable) {
		transitionBuilder.addIncrementOperation(operationVariable, getLatestTransition());
		return this;
	}

	public StateMachine decrement(String operationVariable) {
		transitionBuilder.addDecrementOperation(operationVariable, getLatestTransition());
		return this;
	}

	public StateMachine ifEquals(String conditionVariable, int conditionValue) {
		transitionBuilder.addEqualCondition(conditionVariable, conditionValue, getLatestTransition());
		return this;
	}

	public StateMachine ifGreaterThan(String conditionVariable, int conditionValue) {
		transitionBuilder.addGreaterCondition(conditionVariable, conditionValue, getLatestTransition());
		return this;
	}

	public StateMachine ifLessThan(String conditionVariable, int conditionValue) {
		transitionBuilder.addLesserCondition(conditionVariable, conditionValue, getLatestTransition());
		return this;
	}

}
