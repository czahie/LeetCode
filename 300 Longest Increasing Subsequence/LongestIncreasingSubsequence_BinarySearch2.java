class LongestIncreasingSubsequnce_BinarySearch2 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int size = 0;
        int[] dp = new int[n];
        for (int x: nums) {
            int lo = 0;
            int hi = size;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (x > dp[mid]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid;
                }
            }
            dp[lo] = x;
            if (lo == size) {
                size++;
            }
        }
        return size;
    }
}