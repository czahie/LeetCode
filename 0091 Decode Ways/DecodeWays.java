class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // just one digit
            int curr = chars[i - 1] - '0';
            if (curr >= 1 && curr <= 9) {
                dp[i] += dp[i - 1];
            }
            // 2 digits
            if (i > 1) {
                curr = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
                if (curr >= 10 && curr <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}