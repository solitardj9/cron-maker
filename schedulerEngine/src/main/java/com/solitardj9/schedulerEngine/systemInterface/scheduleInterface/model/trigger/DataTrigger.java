package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("data")
public class DataTrigger extends Trigger {
	//
	private String thing;
	
	private String keyPath;
	
	private Object value;
	
	private String condition;
	
	public DataTrigger() {
		//
	}

	public DataTrigger(String type, String thing, String keyPath, Object value, String condition) {
		setType(type);
		this.thing = thing;
		this.keyPath = keyPath;
		this.value = value;
		this.condition = condition;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "DataTrigger [thing=" + thing + ", keyPath=" + keyPath + ", value=" + value + ", condition=" + condition
				+ ", toString()=" + super.toString() + "]";
	}
}