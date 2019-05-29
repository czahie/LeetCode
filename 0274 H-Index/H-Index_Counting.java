class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int num: citations) {
            if (num > n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }
        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += count[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }
}