class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        pivot = self.find_pivot(nums)
        if pivot == 0:
            return self.binary_search(nums, 0, len (nums) - 1, target)
        if target >= nums[0]:
            return self.binary_search(nums, 0, pivot, target)
        else:
            return self.binary_search(nums, pivot, len(nums) - 1,target)
    
    def find_pivot(self, nums):
        start = 0
        end = len(nums) - 1
        while start + 1 < end:
            mid = (start + end) // 2
            if nums[mid] > nums[mid + 1]:
                return mid + 1
            if nums[mid] > nums[start]:
                start = mid
            else:
                end = mid
        if (end < len(nums) - 1 and nums[end] > nums[end + 1]):
            return end + 1
        if (start < len(nums) - 1 and nums[start] > nums[start + 1]):
            return start + 1
        else:
            return 0
    
    def binary_search(self, nums, start, end, target):
        while start + 1 < end:
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                start = mid
            else:
                end = mid
        if nums[end] == target:
            return end
        if nums[start] == target:
            return start
        return -1