package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model;

import java.util.List;

import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.schedule.Schedule;

public class ScheduleObject {
	//
	private String id;
	
	private List<Schedule> schedules;
	
	public ScheduleObject() {
		//
	}

	public ScheduleObject(String id, List<Schedule> schedules) {
		this.id = id;
		this.schedules = schedules;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "ScheduleObject [id=" + id + ", schedules=" + schedules + "]";
	}
}