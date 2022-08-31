package leetcode.dayOfTheYear;


/**
 * @author Zefeng Wang
 */

public class Solution {

    public int dayOfYear(String date) {
        String[] data = date.split("-");
        int year = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int day = Integer.parseInt(data[2]);

        int result = 0;
        for (int i = 1; i < month; i++) {
            result += daysInMonth(year, i);
        }
        return result + day;
    }

    private static int daysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2: return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default: return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void test(String date, int expected) {
        Solution solution = new Solution();
        if (solution.dayOfYear(date) == expected) {
            System.out.println("pass.");
        } else {
            System.out.println("fail.");
            System.out.println("- Actual: " + solution.dayOfYear(date));
            System.out.println("- Expected: " + expected);
        }
    }

    public static void main(String[] args) {
        test("2019-01-09", 9);
        test("2019-02-10", 41);
        test("2003-03-01", 60);
        test("2004-03-01", 61);
    }


}
