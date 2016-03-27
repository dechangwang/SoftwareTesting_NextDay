package cn.edu.wang;

public class NextDay {
	private int year;
	private int month;
	private int day;

	public NextDay(Date date) {
		year = date.getYear();
		month = date.getMonth();
		day = date.getDay();
	}

	private boolean isValidate() {
		if (month <= 0 || month > 12 || day <= 0 || day > 31) {
			return false;
		}
		return true;
	}

	/* 判断是否为闰年 */
	private boolean isLeepYear() {
		if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0)
			return true;
		else
			return false;
	}

	/* 返回下一天 */
	public Date getNextDay() {
		// 默认day+1作为下一天
		int yearNext = year, monthNext = month, dayNext = day + 1;
		if (!isValidate()) {
			System.out.println("your enter have error!!!");
			return null;
		}
		if (month == 2) {
			if (isLeepYear()) {
				if (day == 29) {
					monthNext = month + 1;
					dayNext = 1;
				}
			} else {
				if (day == 28) {
					monthNext = month + 1;
					dayNext = 1;
				}
			}
			return new Date(yearNext, monthNext, dayNext);
		}

		if (month == 12) {
			if (day == 31) {
				yearNext = year + 1;
				monthNext = 1;
				dayNext = 1;
			}
			return new Date(yearNext, monthNext, dayNext);
		}

		if (month % 2 != 0) {
			if (day == 31) {

				monthNext = month + 1;
				dayNext = 1;
			}
			return new Date(yearNext, monthNext, dayNext);
		}

		if (month % 2 == 0 && day == 30) {
			monthNext = month + 1;
			dayNext = 1;
		}
		return new Date(yearNext, monthNext, dayNext);
	}

	public static boolean isSameDay(Date d1, Date d2) {
		if (d1 == null && d2 == null) {
			return true;
		}
		// if(d1 == null && d2 != null || d1 != null && d2 == null){
		// return false;
		// }
		if (d1 != null && d2 != null)
			if (d1.getDay() == d2.getDay() && d1.getMonth() == d2.getMonth()
					&& d1.getYear() == d2.getYear()) {
				return true;
			}
		return false;
	}
}
