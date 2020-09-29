package com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ConditionOperator;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.ScheduleObject;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.TriggerType;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.operation.Operation;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.schedule.Schedule;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.DataTrigger;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.EventTimeTrigger;
import com.solitardj9.schedulerEngine.systemInterface.scheduleInterface.model.trigger.Trigger;

import cronMaker.CronMaker;
import cronMaker.day.CronDayEnum;
import cronMaker.hour.CronHoursEnum;
import cronMaker.minute.CronMinutesEnum;
import cronMaker.month.CronMonthEnum;
import cronMaker.second.CronSecondsEnum;
import cronMaker.year.CronYearEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SchedulerManagerTest {
	//
	@Autowired
	SchedulerManager schedulerManager;
	
	private ObjectMapper om = new ObjectMapper();
	
	@Test
	public void test() throws Exception {
		//
		CronSecondsEnum cronSecondsEnum = CronSecondsEnum.EVERY_SEC_START_WITH;
		int[] cronSecondsParams = {0/*start*/, 12/*evey*/};
		
		CronMinutesEnum cronMinuteEnum = CronMinutesEnum.EVERY_MIN_START_WITH;
		int[] cronMinuteParams = {0/*start*/, 15/*evey*/};
		
		CronHoursEnum cronHoursEnum = CronHoursEnum.EVERY_HOUR_START_WITH;
		int[] cronHoursParams = {3/*start*/, 2/*evey*/};
		
		CronDayEnum cronDayEnum = CronDayEnum.EVERY_DAY_OF_MONTH_START_WITH;
		int[] cronDayParams = {1/*start*/, 2/*evey*/};
		
		CronMonthEnum cronMonthEnum = CronMonthEnum.EVERY_MONTH_START_WITH;
		int[] cronMonthParams = {2/*start*/, 3/*evey*/};
		
		CronYearEnum cronYearEnum = CronYearEnum.EVERY_YEAR_START_WITH;
		int[] cronYearParams = {2018/*start*/, 2/*evey*/};
		
		String cronExp = CronMaker.makeCronExp(cronSecondsEnum,
				cronSecondsParams,
				cronMinuteEnum,
				cronMinuteParams,
				cronHoursEnum,
				cronHoursParams,
				cronDayEnum,
				cronDayParams,
				cronMonthEnum,
				cronMonthParams,
				cronYearEnum,
				cronYearParams);

		String thingName = "a/c";
		String keyPathOperMode = "state.onOff";
		String keyPathSetTemp = "state.roomTemp";
		
		Trigger eventTimeTrigger = new EventTimeTrigger(TriggerType.TIME.getType(), cronExp);
		Trigger dataTrigger = new DataTrigger(TriggerType.DATA.getType(), thingName, keyPathSetTemp, 30, ConditionOperator.GTE.getOperator());
		Operation operation = new Operation(thingName, keyPathOperMode, "on");
		
		List<Trigger> eventTriggers = new ArrayList<>();
		eventTriggers.add(eventTimeTrigger);
		
		List<Trigger> dataTriggers = new ArrayList<>();
		dataTriggers.add(dataTrigger);
		
		List<Operation> operations = new ArrayList<>();
		operations.add(operation);
		
		Schedule schedule = new Schedule(eventTriggers, dataTriggers, operations);
		
		List<Schedule> schedules = new ArrayList<>();
		schedules.add(schedule);
		
		String scheduleId = "testSchedule_1";
		
		ScheduleObject scheduleObject = new ScheduleObject(scheduleId, schedules);
		
//		schedulerManager.registerSchedule(scheduleObject);
		schedulerManager.registerSchedule(om.writeValueAsString(scheduleObject));
		
		System.out.println(schedulerManager.getSchedules());
		System.out.println(om.writeValueAsString(schedulerManager.getSchedules()));
		
		schedulerManager.unregisterSchedule(scheduleId);
		
		System.out.println(schedulerManager.getSchedules());
		System.out.println(om.writeValueAsString(schedulerManager.getSchedules()));
    }
}