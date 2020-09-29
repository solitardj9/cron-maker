package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("state")
public class EventStateTrigger extends Trigger {
	//
	private String thing;
	
	private String keyPath;
	
	public EventStateTrigger() {
		//
	}

	public EventStateTrigger(String type, String thing, String keyPath) {
		setType(type);
		this.thing = thing;
		this.keyPath = keyPath;
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

	@Override
	public String toString() {
		return "EventStateTrigger [thing=" + thing + ", keyPath=" + keyPath + ", toString()=" + super.toString() + "]";
	}
}