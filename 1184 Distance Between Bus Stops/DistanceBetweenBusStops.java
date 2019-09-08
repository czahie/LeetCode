class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwise = 0;
        int counterclockwise = 0;
        int n = distance.length;
        if (destination < start) {
            destination += n;
        }
        for (int i = start; i < destination; i++) {
            clockwise += distance[i % n];
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += distance[i];
        }
        counterclockwise = total - clockwise;
        return Math.min(counterclockwise, clockwise);
    }
}