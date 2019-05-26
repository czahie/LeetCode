class LongestInceasingSubsequnce_DP {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int max = 0;
        int res = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]); 
                }        
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);          
        }
        return res;
    }
}