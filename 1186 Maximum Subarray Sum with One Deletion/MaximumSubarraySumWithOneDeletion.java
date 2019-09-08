class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // check for all negative
        int maxNum = Integer.MIN_VALUE;
        boolean allNegative = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                allNegative = false;
                break;
            }
            maxNum = Math.max(arr[i], maxNum);
        }
        if (allNegative) {
            return maxNum;
        }
        int ignored = 0;
        int notignored = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                ignored += arr[i];
                notignored += arr[i];
            }  else {
                ignored = Math.max(ignored + arr[i], notignored);
                notignored += arr[i];
            }
            res = Math.max(res, Math.max(ignored, notignored));
            ignored = Math.max(0, ignored);
            notignored = Math.max(0, notignored);
        }
        return res;
    }
}