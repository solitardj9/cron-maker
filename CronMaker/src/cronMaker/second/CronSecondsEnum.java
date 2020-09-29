package cronMaker.second;

import java.util.HashSet;
import java.util.Set;

public enum CronSecondsEnum {
	EVERY_SEC {
		@Override
		public String makeCron(int[] params) {
			//
			return "*";
		}
	},
	EVERY_SEC_START_WITH {
		@Override
		public String makeCron(int[] params) {
			//
			int indexOfStartSecond = 0;
			int indexOfPeriod = 1;
			
			if (params.length < 2)
				return "*";
			
			int second = params[indexOfStartSecond];
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
	SPECIFIC_SECS {
		@Override
		public String makeCron(int[] params) {
			//
			Set<Integer> secs = new HashSet<>();
			
			for (int i = 0 ; i < params.length ; i++) {
				
				int sec = params[i];
				if (sec < 0) {
					sec = 0;
				}
				if (sec > 59) {
					sec = 59;
				}
				
				secs.add(sec);
			}
			
			String ret = "";
			for (Integer iter : secs) {
				ret += String.valueOf(iter) + ",";
			}
			return ret.substring(0, ret.length() - 1);
		}
	},
	EVERY_SEC_BETWEEN {
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
	
	private CronSecondsEnum() {
    }
	
	public abstract String makeCron(int[] params);
}