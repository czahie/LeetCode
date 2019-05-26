class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: t.toCharArray()) {
            int val = map.getOrDefault(ch, 0);
            val++;
            map.put(ch, val);
        }
        int left = 0;
        int minLen = s.length() + 1;
        int count = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                count++;
                }
            }
            while (count == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, left + minLen);
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}