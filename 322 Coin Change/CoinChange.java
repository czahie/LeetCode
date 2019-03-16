class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // array to store number of coins of amount
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) { // initialize the array
            dp[i] = amount + 1;  // at most amount number of coins could make up of amount
        }
        for (int i = 1; i < dp.length; i++) {
            for (int coin: coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // update the least number of coins of amount i
                }
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount]; // check if amount could be made up
    }
}