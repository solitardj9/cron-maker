package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.service.impl;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;


@Service(value= "schedulerService")
public class SchedulerService {
	//
	private Scheduler scheduler = null;
		
	public SchedulerService() {
		//
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            System.out.println("QuartzScheduler is Loaded");
		} catch (SchedulerException se) {
			System.out.println("QuartzScheduler Loading Error : " + se.toString());
        }
	}

	public Scheduler getScheduler() {
		return scheduler;
	}
}