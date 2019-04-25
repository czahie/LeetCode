class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backtrack(res, open_num = 0, close_num = 0, curr= ""):
            if len(curr) == n * 2:
                res.append(curr)
            else:
                if open_num < n:
                    backtrack(res, open_num + 1, close_num, curr + "(")
                if close_num < open_num:
                    backtrack(res, open_num, close_num + 1, curr + ")")
        
        backtrack(res)
        return res