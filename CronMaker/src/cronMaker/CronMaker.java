package cronMaker;

import cronMaker.day.CronDay;
import cronMaker.day.CronDayEnum;
import cronMaker.day.Days;
import cronMaker.hour.CronHours;
import cronMaker.hour.CronHoursEnum;
import cronMaker.minute.CronMinutes;
import cronMaker.minute.CronMinutesEnum;
import cronMaker.month.CronMonth;
import cronMaker.month.CronMonthEnum;
import cronMaker.second.CronSeconds;
import cronMaker.second.CronSecondsEnum;
import cronMaker.year.CronYear;
import cronMaker.year.CronYearEnum;

public class CronMaker {

    /**
     * Method Name : makeCronExp
     * Method Desc : Cron String 생성
     * @param cronSecondsEnum
     * @param cronSecondsParams
     * @param cronMinutesEnum
     * @param cronMinutesParams
     * @param cronHoursEnum
     * @param cronHoursParams
     * @param cronDayEnum
     * @param cronDayParams
     * @param cronMonthEnum
     * @param cronMonthParams
     * @param cronYearEnum
     * @param cronYearParams
     * @return
     */
	public static String makeCronExp(CronSecondsEnum cronSecondsEnum,
			 							  int[] cronSecondsParams,
			 							  CronMinutesEnum cronMinutesEnum,
			 							  int[] cronMinutesParams,
			 							  CronHoursEnum cronHoursEnum,
			 							  int[] cronHoursParams,
			 							  CronDayEnum cronDayEnum,
			 							  int[] cronDayParams,
			 							  CronMonthEnum cronMonthEnum,
			 							  int[] cronMonthParams,
			 							  CronYearEnum cronYearEnum,
			 							  int[] cronYearParams) {
		//
		String ret = "";
		
		Days days = CronDay.makeCron(cronDayEnum, cronDayParams);
		
		ret += (CronSeconds.makeCron(cronSecondsEnum, cronSecondsParams));
		ret += (" " + CronMinutes.makeCron(cronMinutesEnum, cronMinutesParams));
		ret += (" " + CronHours.makeCron(cronHoursEnum, cronHoursParams));
		ret += (" " + days.getDayOfMonth());
		ret += (" " + CronMonth.makeCron(cronMonthEnum, cronMonthParams));
		ret += (" " + days.getDayOfWeek());
		ret += (" " + CronYear.makeCron(cronYearEnum, cronYearParams));
		
		return ret;
	}
}