class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        result = 0
        anchor = 0
        for i in range(len(nums)):
            if i > 0 and nums[i - 1] >= nums[i]:
                anchor = i
            result = result if result > i - anchor + 1 else i - anchor + 1
        return result