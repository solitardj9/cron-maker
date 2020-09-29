package cronMaker.second;

public class CronSeconds {
	//
    /**
     * <p><b>Method Name:</b> makeCron
     * <p><b>Method Desc:</b> 
     * <pre>
     *      CronSecondsEnum.EVERY_SEC               : params --> don't care
     *      CronSecondsEnum.EVERY_SEC_START_WITH    : params[0] --> Start of Second, params[1] --> Period
     *      CronSecondsEnum.SPECIFIC_SECS           : params[n] --> specific Seconds
     *      CronSecondsEnum.EVERY_SEC_BETWEEN       : params[0] --> Start of Second, params[1] --> End of Second
     * </pre>
     * @param cronEnum
     * @param params
     * @return
     * @see <a href="https://www.freeformatter.com/cron-expression-generator-quartz.html">https://www.freeformatter.com/cron-expression-generator-quartz.html</a>
     */
	public static String makeCron(CronSecondsEnum cronEnum, int[] params) {
		//
		return cronEnum.makeCron(params);
	}
}