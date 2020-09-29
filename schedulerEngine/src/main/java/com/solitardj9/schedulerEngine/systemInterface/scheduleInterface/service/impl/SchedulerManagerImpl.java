package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.service.impl;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ScheduleObject;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ScheduleObjects;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.schedule.Schedule;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.EventStateTrigger;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.EventTimeTrigger;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.Trigger;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.service.SchedulerManager;


@Service("schedulerManager")
public class SchedulerManagerImpl implements SchedulerManager, Job {
	//
	private static final Logger logger = LoggerFactory.getLogger(SchedulerManagerImpl.class);
	
	private Map<String, ScheduleObject> scheduleObjects;
	
	@Autowired
	SchedulerService schedulerService;
	
	private ObjectMapper om = new ObjectMapper();
	
	@PostConstruct
	public void init() {
		//
		this.scheduleObjects = new HashMap<>();
	}
	
	@Override
	public Boolean registerSchedule(String strScheduleObject) {
		//
		ScheduleObject scheduleObject;
		try {
			scheduleObject = om.readValue(strScheduleObject, ScheduleObject.class);
			return registerSchedule(scheduleObject);
		} catch (JsonProcessingException e) {
			logger.info("[SchedulerManager].registerSchedule : error = " + e);
			return false;
		}
	}

	@Override
	public Boolean registerSchedule(ScheduleObject scheduleObject) {
		//
		String scheduleObjectId = scheduleObject.getId();
		if (!isExist(scheduleObjectId)) {
			scheduleObjects.put(scheduleObjectId, scheduleObject);
			
			// TODO : register Event Time Trigger or register Event State Trigger
			for (Schedule schedule : scheduleObject.getSchedules()) {
				//
				for (Trigger trigger : schedule.getEventTriggers()) {
					if (trigger instanceof EventTimeTrigger) {
						//
						registerEventTimeTrigger(scheduleObjectId, ((EventTimeTrigger)trigger).getCronId(), ((EventTimeTrigger)trigger).getCron()); 
					}
					else if (trigger instanceof EventStateTrigger) {
						// TODO : 
					}
					else {
						// nothing to do
					}
				}
			}
		}
		return false;
	}
	
	private Boolean isExist(String scheduleObjectId) {
		//
		return scheduleObjects.containsKey(scheduleObjectId);
	}

	@Override
	public Boolean unregisterSchedule(String scheduleObjectId) {
		//
		if (isExist(scheduleObjectId)) {
			ScheduleObject deletedScheduleObject = scheduleObjects.remove(scheduleObjectId);

			// TODO : unregister Event Time Trigger or register Event State Trigger
			for (Schedule schedule : deletedScheduleObject.getSchedules()) {
				//
				for (Trigger trigger : schedule.getEventTriggers()) {
					if (trigger instanceof EventTimeTrigger) {
						//
						unregisterEventTimeTrigger(((EventTimeTrigger)trigger).getCronId()); 
					}
					else if (trigger instanceof EventStateTrigger) {
						// TODO : 
					}
					else {
						// nothing to do
					}
				}
			}
			
			return true;
		}
		return false;
	}

	@Override
	public ScheduleObjects getSchedules() {
		//
		ScheduleObjects scheduleObjects = new ScheduleObjects(new ArrayList<ScheduleObject>(this.scheduleObjects.values()));
		return scheduleObjects;
	}
	
	private void registerEventTimeTrigger(String scheduleObjectId, String cronId, String cronExp) {
		//
		Scheduler scheduler = schedulerService.getScheduler();
		
		try {
			if(scheduler.isStarted()) {
				String schedJobName = scheduleObjectId;
				String schedJobGroup = "scheduler_manager_job_group";
				String schedTriggerName = cronId;
				String schedTriggerGroup = "scheduler_manager_event_time_trigger_group";
				
				JobDetail job = newJob(this.getClass())
						.withIdentity(schedJobName, schedJobGroup)
						.storeDurably(true)
						.build();
				
				JobDataMap jobDataMap = job.getJobDataMap();
				jobDataMap.put("schedulerManager", this);
				jobDataMap.put("scheduleObjectId", scheduleObjectId);
				
				CronTrigger trigger = newTrigger()
						.withIdentity(schedTriggerName, schedTriggerGroup)
						.withSchedule(cronSchedule(cronExp)) 
						.forJob(schedJobName, schedJobGroup)
						.build();
				
				scheduler.scheduleJob(job, trigger);
			}
			
			logger.info("[SchedulerManager].registerEventTimeTrigger : schedule Object ID = " + scheduleObjectId + "/ Cron ID = " + cronId + " / Cron Expression = " + cronExp);
		}
		catch (SchedulerException e) {
			logger.error("[SchedulerManager].registerEventTimeTrigger : error = " + e);
		}
	}
	
	private void unregisterEventTimeTrigger(String cronId) {
		//
		Scheduler scheduler = schedulerService.getScheduler();
		
		TriggerKey triggerKey = new TriggerKey(cronId);
		try {
			scheduler.unscheduleJob(triggerKey);
			logger.info("[SchedulerManager].unregisterEventTimeTrigger : Cron ID = " + cronId);
		} catch (SchedulerException e) {
			logger.error("[SchedulerManager].unregisterEventTimeTrigger : error = " + e);
		}
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
}