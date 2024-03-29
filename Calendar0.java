/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		isLeapYearTest(year);
		nDaysInMonthTest(year,month);
	}



	// Tests the isLeapYear function.

	private static void isLeapYearTest(int year) {
		String commonOrLeap = isLeapYear(year) ? "Leap" : "common";
		System.out.println(year + " is a " + commonOrLeap + " year");
	}

	// Tests the nDaysInMonth function.
	private static void nDaysInMonthTest(int year, int month) {
		int daysInMonth = nDaysInMonth(year,month);
		if (daysInMonth == -1)
		{
			System.out.println("invalid month " + month);
		}
		else {
			System.out.println("there is " + daysInMonth + " in " + month);
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		   if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
			   return true;
		   }
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int year, int month) {
			switch (month) {
				case 4, 6, 9, 11:
					return 30;
				case 2 :
					return isLeapYear(year) ? 29 : 28;
				case 1,3,5,7,8,10,12 :
					return 31;
				default :
					return -1;
		}

	}
}
