class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0;
        length = 0
        for num in nums:
            if length < 2 or num > nums[length - 2]:
                nums[length] = num
                length += 1
        return length