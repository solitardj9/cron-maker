package cronMaker.hour;


public class CronHours {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronHoursEnum.EVERY_HOUR               : params --> don't care
     *      CronHoursEnum.EVERY_HOUR_START_WITH    : params[0] --> Start of Hour, params[1] --> Period
     *      CronHoursEnum.SPECIFIC_HOURS           : params[n] --> specific Hours
     *      CronHoursEnum.EVERY_HOUR_BETWEEN       : params[0] --> Start of Hour, params[1] --> End of Hour
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static String makeCron(CronHoursEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}