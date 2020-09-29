package cronMaker.day;

import java.util.HashSet;
import java.util.Set;

public enum CronDayEnum {
	EVERY_DAY {
		@Override
		public Days makeCron(int[] params) {
			//
			return new Days("?", "*");
		}
	},
	EVERY_DAY_OF_WEEK_START_WITH {
		@Override
		public Days makeCron(int[] params) {
			//
			// Sunday : 1 ~ saturday : 7
			int indexOfStartDay = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return new Days("?", "*");
			
			int day = params[indexOfStartDay];
			if (day < 1) {
				day = 1;
			}
			if (day > 7) {
				day = 7;
			}
			
			int period = params[indexOfPeriod];
			if (period < 1) {
				period = 1;
			}
			if (period > 7) {
				period = 7;
			}
			
			String ret = String.valueOf(day) + "/" + String.valueOf(period);
			return new Days("?",ret);
		}
	},
	EVERY_DAY_OF_MONTH_START_WITH {
		@Override
		public Days makeCron(int[] params) {
			//
			// 1st day : 1 ~ 31th day : 31
			int indexOfStartDay = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return new Days("?", "*");
			
			int day = params[indexOfStartDay];
			if (day < 1) {
				day = 1;
			}
			if (day > 31) {
				day = 31;
			}
			
			int period = params[indexOfPeriod];
			if (period < 1) {
				period = 1;
			}
			if (period > 31) {
				period = 31;
			}
			
			String ret = String.valueOf(day) + "/" + String.valueOf(period);
			return new Days(ret, "?");
		}
	},
	SPECIFIC_DAYS_OF_WEEK {
		@Override
		public Days makeCron(int[] params) {
			//
			// Sunday : 1 ~ saturday : 7
			Set<Integer> days = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int day = params[i];
				if (day < 1) {
					day = 1;
				}
				if (day > 7) {
					day = 7;
				}
				
				days.add(day);
			}
			
			String ret = "";
			for (Integer iter : days) {
				ret += String.valueOf(iter) + ",";
			}
			ret = ret.substring(0, ret.length() - 1);
			
			return new Days("?", ret);
		}
	},
	SPECIFIC_DAYS_OF_MONTH {
		@Override
		public Days makeCron(int[] params) {
			//
			// 1st day : 1 ~ 31th day : 31
			Set<Integer> days = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int day = params[i];
				if (day < 1) {
					day = 1;
				}
				if (day > 31) {
					day = 31;
				}
				
				days.add(day);
			}
			
			String ret = "";
			for (Integer iter : days) {
				ret += String.valueOf(iter) + ",";
			}
			ret = ret.substring(0, ret.length() - 1);
			
			return new Days(ret, "?");
		}
	},
	EVERY_DAY_OF_WEEK_BETWEEN {
		@Override
		public Days makeCron(int[] params) {
			//
			int indexOfFrom = 0;
			int indexOfTo = 1;

			if (params.length < 2)
				return new Days("?", "*");
			
			int from = params[indexOfFrom];
			if (from < 1) {
				from = 1;
			}
			if (from > 31) {
				from = 31;
			}
			
			int to = params[indexOfTo];
			if (to < 1) {
				to = 1;
			}
			if (to > 31) {
				to = 31;
			}
			
			String ret = "";
			ret = String.valueOf(from) + "-" + String.valueOf(to);
			
			return new Days("?", ret);
		}
	},
	EVERY_DAY_OF_MONTH_BETWEEN {
		@Override
		public Days makeCron(int[] params) {
			//
			int indexOfFrom = 0;
			int indexOfTo = 1;

			if (params.length < 2)
				return new Days("?", "*");
			
			int from = params[indexOfFrom];
			if (from < 1) {
				from = 1;
			}
			if (from > 31) {
				from = 31;
			}
			
			int to = params[indexOfTo];
			if (to < 1) {
				to = 1;
			}
			if (to > 31) {
				to = 31;
			}
			
			String ret = "";
			ret = String.valueOf(from) + "-" + String.valueOf(to);
			
			return new Days(ret, "?");
		}
	};
	
	private CronDayEnum() {
    }
	
	public abstract Days makeCron(int[] params);
}