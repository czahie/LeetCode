class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        if (s == null || s.length() < 1) {
            return res;
        }
        int left = 0;
        int right = s.length() - 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if ((right != s.length() - 1) && s.charAt(i) != s.charAt(right)) {
                res = Math.max(res, i - left);
                left = right + 1;
            }
            right = i - 1;
        }
        return Math.max(res, s.length() - left);
    }
}