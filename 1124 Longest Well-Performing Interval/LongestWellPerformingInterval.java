class Solution {
    public int longestWPI(int[] hours) {
        if (hours == null || hours.length < 1) {
            return 0;
        }
        int n = hours.length;
        int res = 0;
        int[][] tiring = new int[n + 1][n + 1];
        int[][] nonTiring = new int[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                for (int p = start; p <= end; p++) {
                    tiring[start][p] = tiring[start][p - 1] + (hours[p - 1] > 8 ? 1 : 0);
                    nonTiring[start][p] = nonTiring[start][p - 1] + (hours[p - 1] > 8 ? 0 : 1);
                    if (tiring[start][p] > nonTiring[start][p]) {
                        res = Math.max(res, p - start + 1);
                    }
                }
            }
        }
        return res;
    }
}