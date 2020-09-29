package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model;

public enum ConditionOperator {
	//
	GT(">"),
	GTE(">="),
	LT("<"),
	LTE("<="),
	EQ("=="),
	NEQ("!=")
	;
	
	private String operator;
	
	private ConditionOperator(String operator) {
		this.operator = operator;
    }
    
	public String getOperator() { 
        return operator;
    }
    
    @Override
    public String toString() {
        return operator;
    }
}