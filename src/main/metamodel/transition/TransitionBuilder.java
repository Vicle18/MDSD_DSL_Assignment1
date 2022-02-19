package main.metamodel.transition;

import main.metamodel.State;

public class TransitionBuilder {
    private String event;
    private State transitionTarget;

    public void setEvent(String event) {
        this.event = event;
    }

    public void setTransitionTarget(State transitionTarget) {
        this.transitionTarget = transitionTarget;
    }

    public void addSetOperation(String operationVariable, int operationValue, Transition latestTransition) {
        latestTransition.setOperation(operationVariable, operationValue, Operation.SET);
    }

    public void addIncrementOperation(String operationVariable, Transition latestTransition) {
        latestTransition.incrementOperation(operationVariable, 1, Operation.INCREMENT);
    }

    public void addDecrementOperation(String operationVariable, Transition latestTransition) {
        latestTransition.decrementOperation(operationVariable, 1, Operation.DECREMENT);
    }

    public void addEqualCondition(String conditionVariable, int conditionValue, Transition latestTransition) {
        latestTransition.setCondition(conditionVariable,conditionValue, Condition.EQUAL);
    }

    public void addGreaterCondition(String conditionVariable, int conditionValue, Transition latestTransition) {
        latestTransition.setCondition(conditionVariable,conditionValue, Condition.GREATER);
    }

    public void addLesserCondition(String conditionVariable, int conditionValue, Transition latestTransition) {
        latestTransition.setCondition(conditionVariable,conditionValue, Condition.LESSER);
    }

    public Transition build (){
        return new Transition(event, transitionTarget);
    }

}
