class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] cap = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] curr = trips[i];
            cap[curr[1]] += curr[0];
            cap[curr[2]] -= curr[0];
        }
        int currCap = 0;
        for (int i = 0; i < cap.length; i++) {
            if (currCap > capacity) {
                return false;
            }
            currCap += cap[i];
        }
        return true;
    }
}