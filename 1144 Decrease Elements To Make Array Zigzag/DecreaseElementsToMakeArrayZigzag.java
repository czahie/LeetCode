class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        int n = nums.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            int left = (i == 0 ? 1001 : nums[i - 1]);
            int right = (i == n - 1) ? 1001 : nums[i + 1];
            if (i % 2 == 0) {
                even += Math.max(0, nums[i] - Math.min(left, right) + 1);
            } else {
                odd += Math.max(0, nums[i] - Math.min(left, right) + 1);
            }
        }
        return Math.min(even, odd);
    }
    
}