package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.schedule;

import java.util.List;

import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.operation.Operation;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.Trigger;


public class Schedule {
	//
	private List<Trigger> eventTriggers;
	
	private List<Trigger> dataTriggers;
	
	private List<Operation> operations;
	
	public Schedule() {
		//
	}

	public Schedule(List<Trigger> eventTriggers, List<Trigger> dataTriggers, List<Operation> operations) {
		this.eventTriggers = eventTriggers;
		this.dataTriggers = dataTriggers;
		this.operations = operations;
	}

	public List<Trigger> getEventTriggers() {
		return eventTriggers;
	}

	public void setEventTriggers(List<Trigger> eventTriggers) {
		this.eventTriggers = eventTriggers;
	}

	public List<Trigger> getDataTriggers() {
		return dataTriggers;
	}

	public void setDataTriggers(List<Trigger> dataTriggers) {
		this.dataTriggers = dataTriggers;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Schedule [eventTriggers=" + eventTriggers + ", dataTriggers=" + dataTriggers + ", operations="
				+ operations + "]";
	}
}