
import javax.swing.*;

/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this
     * period.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
        // inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
        // prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days
        // were advanced so far.
        int debugDaysCounter = 0;
        // int specialdaycounter = 0;
        int curyear = Integer.parseInt(args[0]);
        while (true) {
            if (dayOfMonth == 1 && month == 1 && year == curyear) {
                break;
            }
            advance();
        }
        while (true) {
            // String dayName = dayOfWeekToDayName(dayOfWeek);
            // if (dayOfWeek == 1) {
            // System.out.println(dayOfMonth + "/" + month + "/" + year + " : " +
            // dayName);// + ". nDaysInMonth:" +
            // nDaysInMonth);
            // } else {
            System.out.println(dayOfMonth + "/" + month + "/" + year);// + ". nDaysInMonth:" + nDaysInMonth);

            // }
            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)
            if (dayOfMonth == 31 && month == 12 && year == curyear || debugDaysCounter == 365) {
                break;
            }
            // if (dayName == "Sunday" && dayOfMonth == 1) {
            // specialdaycounter++;
            // }
            debugDaysCounter++;
            advance();
        }

        // System.out.println(
        // "During the 20th century, " + specialdaycounter + " Sundays fell on the first
        // day of the month");
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {
        // advance day of week
        dayOfWeek++;
        dayOfWeek = (dayOfWeek - 1) % 7 + 1;

        // advance day of month
        if (dayOfMonth == nDaysInMonth) // new month
        {
            dayOfMonth = 1;
            // advance month
            if (month == 12) // new year
            {
                // advance year
                year++;
                month = 1;
            } else {
                month++;
            }
            nDaysInMonth = nDaysInMonth(year, month);
        } else // same month
        {
            dayOfMonth++;
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int year, int month) {
        switch (month) {
            case 4, 6, 9, 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            default:
                System.out.println("Invalid month :" + month);
                return 0;
        }
    }

    // private static String dayOfWeekToDayName(int day) {
    // switch (day) {
    // case 1:
    // return "Sunday";
    // case 2:
    // return "Monday";
    // case 3:
    // return "Tuesday";
    // case 4:
    // return "Wednesday";
    // case 5:
    // return "Thursday";
    // case 6:
    // return "Fridey";
    // case 7:
    // return "Saturday";
    // default:
    // System.out.println("Invalid day: " + day);
    // return "error";
    //
    // }
    // }
}