class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height);
        lo = 0
        hi = n - 1 
        max_area = 0
        while lo < hi:
            max_area = max(max_area, min(height[lo], height[hi]) * (hi - lo))
            if height[lo] <= height[hi]:
                lo += 1
            else:
                hi -= 1
        return max_area
        