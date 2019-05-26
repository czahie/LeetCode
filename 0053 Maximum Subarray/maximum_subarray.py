class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        global_max = nums[0]
        max_end_here = nums[0]
        for i in range(1, len(nums)):
            max_end_here = nums[i] if nums[i] > max_end_here + nums[i] else max_end_here + nums[i]
            if max_end_here > global_max:
                global_max = max_end_here
        return global_max