class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) {
            return 1.0;
        }
        
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        
        double half = myPow(x, (int) (N / 2));
        if (N % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}