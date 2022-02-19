package main.metamodel;

import java.util.*;

public class Machine {
	private List<State> states = new ArrayList<State>();
	private Map<String, Integer> integers = new HashMap<>();
	private State initialState;

	public Machine(Collection<State> states, State initialState, Map<String, Integer> integers) {
		super();
		this.states.addAll(states);
		this.initialState = initialState;
		this.integers = integers;
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String stateName) {
		for (int i = 0; i < states.size(); i++) {
			if(states.get(i).getName().equals(stateName)){
				return states.get(i);
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String variable) {
		return integers.containsKey(variable);
	}

	public Map<String, Integer> getIntegers() {
		return integers;
	}
}
