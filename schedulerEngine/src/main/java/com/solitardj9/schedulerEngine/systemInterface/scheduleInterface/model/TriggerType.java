package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model;

public enum TriggerType {
	//
	TIME("time"),
	STATE("state"),
	DATA("data")
	;
	
	private String type;
	
	private TriggerType(String type) {
		this.type = type;
    }
    
	public String getType() { 
        return type;
    }
    
    @Override
    public String toString() {
        return type;
    }
}