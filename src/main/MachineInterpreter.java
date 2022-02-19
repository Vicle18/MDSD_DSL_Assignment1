package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.transition.Condition;
import main.metamodel.transition.Operation;
import main.metamodel.transition.Transition;

public class MachineInterpreter {
	private Machine machine; // metamodel (i.e., state machine program) to execute
	private State currentState; // runtime state

	public void run(Machine machine) {
		this.machine = machine;
		currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String eventName) {
		for(Transition t: currentState.getTransitions()) {
			if(!(currentState.getTransitions().contains(t))){return;}
			if(t.getEvent().equals(eventName)) {
				if(t.getConditionType() == null && t.getOperationType() != null){
					executeOperation(t);
				}
				else if(t.getConditionType() != null && t.getOperationType() == null){
					executeCondition(t);
				}
				else if(t.getConditionType() != null && t.getOperationType() != null){
					executeConditionWithOperation(t);
				}
				else if(t.getConditionType() == null && t.getOperationType() == null){
					currentState = t.getTarget();
				}
			}
		}
		System.err.println("Unhandled event "+ eventName);
	}

	private void executeConditionWithOperation(Transition t) {
		if(t.getConditionType().equals(Condition.EQUAL)){
			if(machine.getIntegers().get(t.getConditionVariable()) == t.getConditionValue()){
				executeOperation(t);
			}
		}
		else if(t.getConditionType().equals(Condition.GREATER)){
			if(machine.getIntegers().get(t.getConditionVariable()) > t.getConditionValue()){
				executeOperation(t);
			}
		}
		else if(t.getConditionType().equals(Condition.LESSER)){
			if(machine.getIntegers().get(t.getConditionVariable()) < t.getConditionValue()){
				executeOperation(t);
			}
		}
	}

	private void executeCondition(Transition t) {
		if(t.getConditionType().equals(Condition.EQUAL)){
			if(machine.getIntegers().get(t.getConditionVariable()) == t.getConditionValue() && t.getOperationType() == null){
				currentState = t.getTarget();
			}

		}
		else if(t.getConditionType().equals(Condition.GREATER)){
			if(machine.getIntegers().get(t.getConditionVariable()) > t.getConditionValue() && t.getOperationType() == null){
				currentState = t.getTarget();
			}

		}
		else if(t.getConditionType().equals(Condition.LESSER)){
			if(machine.getIntegers().get(t.getConditionVariable()) < t.getConditionValue() && t.getOperationType() == null){
				currentState = t.getTarget();
			}
		}
	}

	private void executeOperation(Transition t) {
		if(t.getOperationType().equals(Operation.SET)){
			machine.getIntegers().put(t.getOperationVariable(), t.getOperationValue());
			currentState = t.getTarget();
		}
		if(t.getOperationType().equals(Operation.INCREMENT)){
			machine.getIntegers().put(t.getOperationVariable(), machine.getIntegers().get(t.getOperationVariable()) + t.getOperationValue());
			currentState = t.getTarget();
		}
		if(t.getOperationType().equals(Operation.DECREMENT)){
			machine.getIntegers().put(t.getOperationVariable(), machine.getIntegers().get(t.getOperationVariable()) - t.getOperationValue());
			currentState = t.getTarget();
		}
	}

	public int getInteger(String variable) {
		return machine.getIntegers().get(variable);
	}

}
