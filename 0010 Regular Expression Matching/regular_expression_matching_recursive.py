class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if len(p) == 0:
            return len(s) == 0
        first_match = (len(s) != 0) and (s[0] == p[0] or p[0] == '.')
        if len(p) >= 2 and p[1] == '*':
            return (first_match and self.isMatch(s[1:], p)) or self.isMatch(s, p[2:])
        else:
            return first_match and self.isMatch(s[1:], p[1:])