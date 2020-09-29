package cronMaker.month;

import java.util.HashSet;
import java.util.Set;

public enum CronMonthEnum {
	EVERY_MONTH {
		@Override
		public String makeCron(int[] params) {
			//
			return "*";
		}
	},
	EVERY_MONTH_START_WITH {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfStartMonth = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return "*";
			
			int month = params[indexOfStartMonth];
			if (month < 1) {
				month = 1;
			}
			if (month > 12) {
				month = 12;
			}
			
			int period = params[indexOfPeriod];
			if (period < 1) {
				period = 1;
			}
			if (period > 12) {
				period = 12;
			}
			
			return String.valueOf(month) + "/" + String.valueOf(period);
		}
	},
	SPECIFIC_MONTHS {
		@Override
		public String makeCron(int[] params) {
			//
			Set<Integer> months = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int month = params[i];
				if (month < 1) {
					month = 1;
				}
				if (month > 12) {
					month = 12;
				}
				months.add(month);
			}
			
			String ret = "";
			for (Integer iter : months) {
				ret += String.valueOf(iter) + ",";
			}
			return ret.substring(0, ret.length() - 1);
		}
	},
	EVERY_MONTH_BETWEEN {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfFrom = 0;
			int indexOfTo = 1;

			if (params.length < 2)
				return "*";
			
			int from = params[indexOfFrom];
			if (from < 1) {
				from = 1;
			}
			if (from > 12) {
				from = 12;
			}
			
			int to = params[indexOfTo];
			if (to < 1) {
				to = 1;
			}
			if (to > 12) {
				to = 12;
			}
			
			return String.valueOf(from) + "-" + String.valueOf(to);
		}
	};
	
	private CronMonthEnum() {
    }
	
	public abstract String makeCron(int[] params);
}