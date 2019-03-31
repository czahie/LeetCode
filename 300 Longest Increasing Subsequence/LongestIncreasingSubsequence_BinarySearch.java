class LongestIncreasingSubsequence_BinarySearch {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(dp, 0, len, nums[i]);
            // no such a number
            if (index < 0) {
                index = -(index + 1);
            }
            // replace the old num or 0
            dp[index] = nums[i];
            // increase the sebsequence
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}