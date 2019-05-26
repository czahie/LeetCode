class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n - 1;
        int maxArea = 0;
        while (lo < hi) {
            maxArea = Math.max(maxArea, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] <= height[hi]) {
                lo++;
            }
            else {
                hi--;
            }
        }
        return maxArea;
    }
}