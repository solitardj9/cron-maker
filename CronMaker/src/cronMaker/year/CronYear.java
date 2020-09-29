package cronMaker.year;


public class CronYear {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronYearEnum.EVERY_YEAR               : params --> don't care
     *      CronYearEnum.EVERY_YEAR_START_WITH    : params[0] --> Start of Year, params[1] --> Period
     *      CronYearEnum.SPECIFIC_YEARS           : params[n] --> specific Years
     *      CronYearEnum.EVERY_YEAR_BETWEEN       : params[0] --> Start of Year, params[1] --> End of Year
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static String makeCron(CronYearEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}