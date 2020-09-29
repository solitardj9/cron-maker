package cronMaker.month;


public class CronMonth {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronMonthEnum.EVERY_MONTH               : params --> don't care
     *      CronMonthEnum.EVERY_MONTH_START_WITH    : params[0] --> Start of Month, params[1] --> Period
     *      CronMonthEnum.SPECIFIC_MONTHS           : params[n] --> specific Months
     *      CronMonthEnum.EVERY_MONTH_BETWEEN       : params[0] --> Start of Month, params[1] --> End of Month
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static String makeCron(CronMonthEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}