class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, longestSubstringWithNUnique(s, k, i));
        }
        return res;
    }
    
    private int longestSubstringWithNUnique(String s, int k, int numUniqueTarget) {
        int[] counts = new int[128];
        int left = 0;
        int right = 0;
        int noLessThanK = 0;
        int numUnique = 0;
        int res = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (counts[rightChar] == 0) {
                numUnique++;
            }
            counts[rightChar]++;
            if (counts[rightChar] == k) {
                noLessThanK++;
            }
            while (numUnique > numUniqueTarget) {
                char leftChar = s.charAt(left);
                if (counts[leftChar] == k) {
                    noLessThanK--;
                }
                counts[leftChar]--;
                if (counts[leftChar] == 0) {
                    numUnique--;
                }
                left++;
            }
            if (numUnique == numUniqueTarget && numUnique == noLessThanK) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }
}