package cronMaker;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

/*
 * .m2/repository/com/cronutils/cron-utils/9.0.2/cron-utils-9.0.2.jar
 * .m2/repository/org/springframework/spring-context/5.2.9.RELEASE/spring-context-5.2.9.RELEASE.jar
 * .m2/repository/org/springframework/spring-core/5.2.9.RELEASE/spring-core-5.2.9.RELEASE.jar
 */
import org.springframework.scheduling.support.CronSequenceGenerator;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;

import cronMaker.day.CronDayEnum;
import cronMaker.hour.CronHoursEnum;
import cronMaker.minute.CronMinutesEnum;
import cronMaker.month.CronMonthEnum;
import cronMaker.second.CronSecondsEnum;
import cronMaker.year.CronYearEnum;

public class Test {
	
	public static void main(String[] args) {
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

		System.out.println("cron expression  = " + cronExp);
		
		Locale myLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
		System.out.println("description for cron expression = " + CronDescriptor.instance(myLocale).describe(new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)).parse(cronExp)));

		// delete year parameter for using CronSequenceGenerator.
		String cronExpForNextTime = cronExp.substring(0, cronExp.lastIndexOf(" "));
		System.out.println(cronExpForNextTime);
		System.out.println("next schedule for cron expression = " + new Timestamp(getNextScheduleOfCronExp(new Timestamp(System.currentTimeMillis()), cronExpForNextTime)));
	}
	
	private static Long getNextScheduleOfCronExp(Timestamp criteriaTime, String cronExp) {
		//
		CronSequenceGenerator generator = new CronSequenceGenerator(cronExp);
		Date next = generator.next(makeDateFromTimestamp(criteriaTime));
		return next.getTime();
	}
	
	private static Date makeDateFromTimestamp(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
}