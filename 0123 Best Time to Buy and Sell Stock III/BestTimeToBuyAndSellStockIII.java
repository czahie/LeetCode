class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        int[][] local = new int[n][3];
        int[][] global = new int[n][3];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + diff;
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][2];
    }
}