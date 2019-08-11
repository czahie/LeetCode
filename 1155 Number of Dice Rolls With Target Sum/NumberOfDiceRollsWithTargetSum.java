class Solution {
    
    final int m = 1000000007;
    
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        for (int j = 1; j <= target; j++) {
            if (j <= f) {
                dp[1][j] = 1;
            }
        }
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                long curr = 0;
                for (int k = Math.max(i - 1, j - f); k <= j - 1; k++) {
                    curr += dp[i - 1][k];
                }
                dp[i][j] = (int) (curr % m); 
            }
        }
        return dp[d][target];
    }
    
}