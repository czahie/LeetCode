class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = 0;
        for (int num: nums) {
            if (len < 2 || num > nums[len - 2]) {
                nums[len] = num;    
                len++;
            }
        }
        return len;
    }
}