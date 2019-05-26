class Solution:
    def romanToInt(self, s: str) -> int:
        nums = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        res = 0
        for i in range(len(s)):
            if i == len(s) - 1:
                res += nums[s[i]]
            else:
                if nums[s[i + 1]] > nums[s[i]]:
                    res -= nums[s[i]]
                else:
                    res += nums[s[i]]
        return res