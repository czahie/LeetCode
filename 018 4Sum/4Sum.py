class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        if not nums:
            return res
        nums.sort()
        for i in range(len(nums) - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                start = j + 1
                end = len(nums) - 1
                remain = target - nums[i] - nums[j]
                while (start < end):
                    if nums[start] + nums[end] == remain:
                        res.append([nums[i], nums[j], nums[start], nums[end]])
                        start += 1
                        end -= 1
                        while (start < end and nums[start] == nums[start - 1]):
                            start += 1
                        while (start < end and nums[end] == nums[end + 1]):
                            end -= 1
                    elif nums[start] + nums[end] < remain:
                        start += 1
                    else:
                        end -= 1
        return res