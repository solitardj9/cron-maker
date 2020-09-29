package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.service;

import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ScheduleObject;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ScheduleObjects;

public interface SchedulerManager {
	//
	public Boolean registerSchedule(String strScheduleObject);
	
	public Boolean registerSchedule(ScheduleObject scheduleObject);
	
	public Boolean unregisterSchedule(String scheduleObjectId);
	
	public ScheduleObjects getSchedules();
}