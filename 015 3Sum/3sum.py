class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            lo = i + 1
            hi = n - 1
            total = -nums[i]
            while (lo < hi):
                if nums[lo] + nums[hi] == total:
                    res.append([nums[i], nums[lo], nums[hi]])
                    while lo < hi and nums[lo + 1] == nums[lo]:
                        lo += 1
                    while lo < hi and nums[hi - 1] == nums[hi]:
                        hi -= 1
                    lo += 1
                    hi -= 1
                elif nums[lo] + nums[hi] > total:
                    hi -= 1
                else:
                    lo += 1
        return res 