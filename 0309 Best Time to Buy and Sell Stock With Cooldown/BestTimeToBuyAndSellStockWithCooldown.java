class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1 || k < 1) {
            return 0;
        }
        if (k >= prices.length) {
            return maxProfit2(prices);
        }
        int n = prices.length;
        int[] l = new int[k + 1];
        int[] g = new int[k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                l[j] = Math.max(g[j - 1], l[j]) + diff;
                g[j] = Math.max(g[j], l[j]);
            }
        }
        return g[k];
    }
    
    private int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}