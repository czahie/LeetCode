class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        def backtrack(res, curr_list):
            if len(curr_list) == len(nums):
                res.append(curr_list[:])
            else:
                for num in nums:
                    if num not in curr_list:
                        curr_list.append(num)
                        backtrack(res, curr_list)
                        curr_list.pop()
        
        backtrack(res, [])
        return res