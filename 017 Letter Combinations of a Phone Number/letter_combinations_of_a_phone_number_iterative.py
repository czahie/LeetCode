class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        if not digits: # base case
            return res
        res.append("")
        my_dict = ['0', '1', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']
        for i in range(len(digits)):
            letters = my_dict[int(digits[i])]
            while len(res[0]) == i:
                prev = res.pop(0)
                for letter in letters:
                    res.append(prev + letter)
        return res
            