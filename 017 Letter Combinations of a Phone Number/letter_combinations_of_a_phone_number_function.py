class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        if not digits: # base case
            return res
        res.append("")
        my_dict = ['0', '1', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        for digit in digits:
            letters = my_dict[int(digit)]
            res = self.expand(res, letters)
        return res
    
    def expand(self, res, letters):
        new_res = []
        for com in res:
            for letter in letters:
                new_res.append(com + letter)
        return new_res