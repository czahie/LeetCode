class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
        dp[-1][-1] = True
        for i in range(len(s), -1, -1):
            for j in range(len(p) - 1, -1, -1):
                first_match = (i < len(s)) and (s[i] == p[j] or p[j] == '.')
                if (j < len(p) - 1 and p[j + 1] == '*'):
                    dp[i][j] = (first_match and dp[i +1][j]) or dp[i][j + 2]
                else:
                    dp[i][j] = first_match and dp[i+ 1][j + 1]
        return dp[0][0]