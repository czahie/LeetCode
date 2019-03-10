class Solution:
    def longestPalindrome(self, s: str) -> str:
        count = 0
        res = ""
        length = len(s)
        for i in range(length):
            for j in range(length):
                subs = s[i: j + 1]
                if self.is_palindrome(subs):
                    if len(subs) > count:
                        count = len(subs)
                        res = subs
        return res
        
    def is_palindrome(self, s):
        return s[::-1] == s
    