class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_set = set()
        n = len(s)
        i = j = result = 0
        while (i < n and j < n):
            if (s[j] not in char_set) :
                char_set.add(s[j])
                result = max(result, j - i + 1)
                j += 1
            else:
                char_set.remove(s[i])
                i += 1
        return result