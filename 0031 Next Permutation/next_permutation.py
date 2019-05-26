class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 2
        while (i >= 0 and nums[i + 1] <= nums[i]):
            i -= 1
        
        if i >= 0:
            j = len(nums) - 1
            while (j >= i and nums[j] <= nums[i]):
                j -= 1
            self.swap(nums, i, j)
        
        self.reverse(nums, i + 1, len(nums) - 1)
        
    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]
    
    def reverse(self, nums, i, j):
        while i < j:
            self.swap(nums, i, j)
            i += 1
            j -= 1
        