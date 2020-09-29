package cronMaker.day;


/**
 * @Project : evppPlatForm
 * @Package : org.evpp.platformManager.dataProcessMngtSet.scheduleMngt.service.impl.util.cronMaker
 * @FileName : Days.java
 * @CreateDt : 2020. 7. 31.
 * @CreateUs : bk.cha@lge.com
 * @Progm Desc : Day 관련 Cron Expression 결과 Class
 */
public class Days {
	//
	private String dayOfMonth;
	
	private String dayOfWeek;
	
	public Days() {
	}
	
	public Days(String dayOfMonth, String dayOfWeek) {
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek;
	}

	public String getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}