package main.metamodel;

import main.metamodel.transition.Transition;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String name;
	private List<Transition> trans = new ArrayList<>();

	public State(String name) {
		super();
		this.name = name;
	}
	public Object getName() {
		return name;
	}

	public void addTransition(Transition t) {
		this.trans.add(t);
	}

	public List<Transition> getTransitions() {
		return trans;
	}

	public Transition getTransitionByEvent(String string) {
		for (int i = 0; i < trans.size(); i++) {
			if(trans.get(i).getEvent().equals(string))
				return trans.get(i);
		}
		return null;
	}

}
