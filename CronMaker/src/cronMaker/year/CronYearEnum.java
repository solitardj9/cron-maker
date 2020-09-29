package cronMaker.year;

import java.util.HashSet;
import java.util.Set;

public enum CronYearEnum {
	EVERY_YEAR {
		@Override
		public String makeCron(int[] params) {
			//
			return "*";
		}
	},
	EVERY_YEAR_START_WITH {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfStartYear = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return "*";
			return String.valueOf(params[indexOfStartYear]) + "/" + String.valueOf(params[indexOfPeriod]);
		}
	},
	SPECIFIC_YEARS {
		@Override
		public String makeCron(int[] params) {
			//
			Set<Integer> years = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				years.add(params[i]);
			}
			
			String ret = "";
			for (Integer iter : years) {
				ret += String.valueOf(iter) + ",";
			}
			return ret.substring(0, ret.length() - 1);
		}
	},
	EVERY_YEAR_BETWEEN {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfFrom = 0;
			int indexOfTo = 1;

			if (params.length < 2)
				return "*";
			return String.valueOf(params[indexOfFrom]) + "-" + String.valueOf(params[indexOfTo]);
		}
	};
	
	private CronYearEnum() {
    }
	
	public abstract String makeCron(int[] params);
}