class Solution {
    public int uniquePaths(int m, int n) {
        double res = 1;
        int steps = m + n - 2;
        int downSteps = m - 1;
        for (int i = 1; i <= downSteps; i++) {
            res = res * (steps - downSteps + i) / i;
        }
        return (int) res;
    }
}