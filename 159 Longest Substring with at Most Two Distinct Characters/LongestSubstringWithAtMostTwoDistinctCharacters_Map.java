class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        if (s == null || s.length() < 1) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}