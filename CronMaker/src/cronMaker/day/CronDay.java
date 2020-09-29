package cronMaker.day;


public class CronDay {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronDayEnum.EVERY_DAY                       : params --> don't care
     *      CronDayEnum.EVERY_DAY_OF_WEEK_START_WITH    : params[0] --> Start of Day in Week, params[1] --> Period
     *      CronDayEnum.EVERY_DAY_OF_MONTH_START_WITH   : params[0] --> Start of Day in Month, params[1] --> Period
     *      CronDayEnum.SPECIFIC_DAYS_OF_WEEK           : params[n] --> specific Days in Week
     *      CronDayEnum.SPECIFIC_DAYS_OF_MONTH          : params[n] --> specific Days in Month
     *      CronDayEnum.EVERY_DAY_OF_WEEK_BETWEEN       : params[0] --> Start of Day in Week, params[1] --> End of Day in Week
     *      CronDayEnum.EVERY_DAY_OF_MONTH_BETWEEN      : params[0] --> Start of Day in Month, params[1] --> End of Day in Month
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static Days makeCron(CronDayEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}