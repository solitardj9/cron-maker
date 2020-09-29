package cronMaker.minute;


public class CronMinutes {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronMinutesEnum.EVERY_MIN               : params --> don't care
     *      CronMinutesEnum.EVERY_MIN_START_WITH    : params[0] --> Start of Minitue, params[1] --> Period
     *      CronMinutesEnum.SPECIFIC_MINS           : params[n] --> specific Minitues
     *      CronMinutesEnum.EVERY_MIN_BETWEEN       : params[0] --> Start of Minitue, params[1] --> End of Minitue
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static String makeCron(CronMinutesEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}