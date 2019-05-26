class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1])  {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int mark = nums[end];
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < mark) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}