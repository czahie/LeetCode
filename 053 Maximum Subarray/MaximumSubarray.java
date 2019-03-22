class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int maxEndHere = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndHere = nums[i] > nums[i] + maxEndHere? nums[i]: nums[i] + maxEndHere;
            if (maxEndHere > globalMax) {
                globalMax = maxEndHere;
            }
        }
        return globalMax;
    }
}