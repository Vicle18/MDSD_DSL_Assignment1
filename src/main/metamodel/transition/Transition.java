package main.metamodel.transition;

import main.metamodel.State;

public class Transition {

	private String event;
	private State to;
	private String operationVariable;
	private int operationValue;
	private Operation operationType;
	private String conditionVariable;
	private int conditionValue;
	private Condition conditionType;

	public Transition(String event, State to) {
		super();
		this.event = event;
		this.to = to;
	}

	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return to;
	}

	public boolean hasSetOperation() {
		if(this.operationType != null && this.operationType == Operation.SET){
			return true;
		}

		return false;
	}

	public boolean hasIncrementOperation() {
		if(operationType != null && operationType == Operation.INCREMENT){
			return true;
		}
		return false;
	}

	public boolean hasDecrementOperation() {
		if(operationType != null && operationType == Operation.DECREMENT){
			return true;
		}
		return false;
	}

	public Object getOperationVariableName() {
		return operationVariable;
	}

	public boolean hasOperation() {
		if(this.operationType != null){
			return true;
		}
		return false;
	}

	public boolean isConditional() {
		if(this.conditionType != null){
			return true;
		}
		return false;
	}

	public Object getConditionVariableName() {
		return conditionVariable;
	}

	public Integer getConditionComparedValue() {
		return conditionValue;
	}

	public boolean isConditionEqual() {
		if(conditionType != null && conditionType == Condition.EQUAL){
			return true;
		}
		return false;
	}

	public boolean isConditionGreaterThan() {
		if(conditionType != null && conditionType == Condition.GREATER){
			return true;
		}
		return false;
	}

	public boolean isConditionLessThan() {
		if(conditionType != null && conditionType == Condition.LESSER){
			return true;
		}
		return false;
	}

	public String getConditionVariable() {
		return conditionVariable;
	}

	public int getConditionValue() {
		return conditionValue;
	}

	public Condition getConditionType() {
		return conditionType;
	}

	public void setCondition(String conditionVariable, int conditionValue, Condition conditionType){
		this.conditionVariable = conditionVariable;
		this.conditionValue = conditionValue;
		this.conditionType = conditionType;
	}

	public void setOperation(String operationVariable, int operationValue, Operation operationType) {
		this.operationVariable = operationVariable;
		this.operationValue = operationValue;
		this.operationType = operationType;
	}

	public void incrementOperation(String operationVariable, int operationValue, Operation operationType) {
		this.operationVariable = operationVariable;
		this.operationValue = operationValue;
		this.operationType = operationType;
	}

	public void decrementOperation(String operationVariable, int operationValue, Operation operationType) {
		this.operationVariable = operationVariable;
		this.operationValue = operationValue;
		this.operationType = operationType;
	}

	public String getOperationVariable() {
		return operationVariable;
	}

	public int getOperationValue() {
		return operationValue;
	}

	public Operation getOperationType() {
		return operationType;
	}

}
