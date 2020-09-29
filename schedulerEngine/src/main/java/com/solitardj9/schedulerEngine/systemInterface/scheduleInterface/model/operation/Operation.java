package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.operation;


public class Operation {
	//
	private String thing;
	
	private String keyPath;
	
	private Object value;
	
	public Operation() {
		//
	}
	
	public Operation(String thing, String keyPath, Object value) {
		this.thing = thing;
		this.keyPath = keyPath;
		this.value = value;
	}

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getKeyPath() {
		return keyPath;
	}

	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Operation [thing=" + thing + ", keyPath=" + keyPath + ", value=" + value + "]";
	}
}