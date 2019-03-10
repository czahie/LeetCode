class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s) <= 1: # base case
            return s
        start = end = 0
        for i in (range(len(s))):
            len1 = self.expand(s, i, i) # center is i
            len2 = self.expand(s, i, i + 1) # center is between i and i+1
            length = max(len1, len2)
            if (length > end - start): # longer substring
                start = i - (length - 1) // 2
                end = i + length // 2
        return s[start:end + 1]
    
    def expand(self, s, l, r):
        while (l >= 0 and r < len(s) and s[l] == s[r]): # expand from center
            l -= 1
            r += 1
        return r - l - 1