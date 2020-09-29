package cronMaker.minute;

import java.util.HashSet;
import java.util.Set;

public enum CronMinutesEnum {
	EVERY_MIN {
		@Override
		public String makeCron(int[] params) {
			//
			return "*";
		}
	},
	EVERY_MIN_START_WITH {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfStartMinute = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return "*";
			
			int second = params[indexOfStartMinute];
			if (second < 0) {
				second = 0;
			}
			if (second > 59) {
				second = 59;
			}
			
			int period = params[indexOfPeriod];
			if (period < 1) {
				period = 1;
			}
			if (period > 60) {
				period = 60;
			}
			
			return String.valueOf(second) + "/" + String.valueOf(period);
		}
	},
	SPECIFIC_MINS {
		@Override
		public String makeCron(int[] params) {
			//
			Set<Integer> mins = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int min = params[i];
				if (min < 0) {
					min = 0;
				}
				if (min > 59) {
					min = 59;
				}
				
				mins.add(min);
			}
			
			String ret = "";
			for (Integer iter : mins) {
				ret += String.valueOf(iter) + ",";
			}
			return ret.substring(0, ret.length() - 1);
		}
	},
	EVERY_MIN_BETWEEN {
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
			if (from > 59) {
				from = 59;
			}
			
			int to = params[indexOfTo];
			if (to < 0) {
				to = 0;
			}
			if (to > 59) {
				to = 59;
			}
			
			return String.valueOf(from) + "-" + String.valueOf(to);
		}
	};
	
	private CronMinutesEnum() {
    }
	
	public abstract String makeCron(int[] params);
}