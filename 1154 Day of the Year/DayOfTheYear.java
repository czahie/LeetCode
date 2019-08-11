class Solution {
    public int dayOfYear(String date) {
        String[] nums = date.split("-");
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.valueOf(nums[0]);
        int month = Integer.valueOf(nums[1]);
        int day = Integer.valueOf(nums[2]);
        int res = 0;
        if (isLeapYear(year)) {
            months[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            res += months[i];
        }
        res += day;
        return res;
    }
    
    private boolean isLeapYear(int n) {
        if (n % 100 == 0) {
            if (n % 400 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return n % 4 == 0;
        }
    }
}