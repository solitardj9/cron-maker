package cronMaker.hour;

import java.util.HashSet;
import java.util.Set;

public enum CronHoursEnum {
	EVERY_HOUR {
		@Override
		public String makeCron(int[] params) {
			//
			return "*";
		}
	},
	EVERY_HOUR_START_WITH {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfStartHour = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return "*";
			
			int second = params[indexOfStartHour];
			if (second < 0) {
				second = 0;
			}
			if (second > 23) {
				second = 23;
			}
			
			int period = params[indexOfPeriod];
			if (period < 1) {
				period = 1;
			}
			if (period > 24) {
				period = 24;
			}
			
			return String.valueOf(second) + "/" + String.valueOf(period);
		}
	},
	SPECIFIC_HOURS {
		@Override
		public String makeCron(int[] params) {
			//
			Set<Integer> hours = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int hour = params[i];
				if (hour < 0) {
					hour = 0;
				}
				if (hour > 23) {
					hour = 23;
				}
				
				hours.add(hour);
			}
			
			String ret = "";
			for (Integer iter : hours) {
				ret += String.valueOf(iter) + ",";
			}
			return ret.substring(0, ret.length() - 1);
		}
	},
	EVERY_HOUR_BETWEEN {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfFrom = 0;
			int indexOfTo = 1;

			if (params.length < 2)
				return "*";
			
			int from = params[indexOfFrom];
			if (from < 0) {
				from = 0;
			}
			if (from > 23) {
				from = 23;
			}
			
			int to = params[indexOfTo];
			if (to < 0) {
				to = 0;
			}
			if (to > 23) {
				to = 23;
			}
			
			return String.valueOf(from) + "-" + String.valueOf(to);
		}
	};
	
	private CronHoursEnum() {
    }
	
	public abstract String makeCron(int[] params);
}