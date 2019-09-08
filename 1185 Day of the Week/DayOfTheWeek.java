class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 12/31/1970 is Thursday;
        int anchor = 4;
        int total = 0;
        int leapYearNums = leapYears(year);
        total += leapYearNums * 366 + (year - 1971 - leapYearNums) * 365;
        for (int i = 0; i < month - 1; i++) {
            total += months[i];
        }
        total += day;
        if (month > 2 && isLeapYear(year)) {
            total += 1;
        }
        int idx = (total + anchor) % 7;
        return days[idx];
    }
    
    private int leapYears(int year) {
        int res = 0;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            return year % 100 != 0;
        } else {
            return false;
        }
    }
}