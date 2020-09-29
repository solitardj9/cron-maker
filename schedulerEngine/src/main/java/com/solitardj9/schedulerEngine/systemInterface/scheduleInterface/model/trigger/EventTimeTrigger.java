package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("time")
public class EventTimeTrigger extends Trigger {
	//
	private String cron;
	
	private String cronId;
	
	public EventTimeTrigger() {
		//
	}
	
	public EventTimeTrigger(String type, String cron) {
		setType(type);
		this.cron = cron;
		this.cronId = UUID.randomUUID().toString();
	}

	public EventTimeTrigger(String type, String cron, String cronId) {
		setType(type);
		this.cron = cron;
		this.cronId = cronId;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
	
	public String getCronId() {
		return cronId;
	}

	@Override
	public String toString() {
		return "EventTimeTrigger [cron=" + cron + ", toString()=" + super.toString() + "]";
	}
}