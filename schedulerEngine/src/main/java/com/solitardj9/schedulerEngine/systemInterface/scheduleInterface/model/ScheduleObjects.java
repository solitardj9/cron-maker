package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model;

import java.util.List;

public class ScheduleObjects {
	//
	private List<ScheduleObject> scheduleObjects;
	
	public ScheduleObjects() {
		//
	}

	public ScheduleObjects(List<ScheduleObject> scheduleObjects) {
		this.scheduleObjects = scheduleObjects;
	}

	public List<ScheduleObject> getScheduleObjects() {
		return scheduleObjects;
	}

	public void setScheduleObjects(List<ScheduleObject> scheduleObjects) {
		this.scheduleObjects = scheduleObjects;
	}

	@Override
	public String toString() {
		return "ScheduleObjects [scheduleObjects=" + scheduleObjects + "]";
	}
}