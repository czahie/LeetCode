class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) {
            map[(int) c]++;
        }
        int left = 0;
        int minLen = s.length() + 1;
        int count = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            map[(int) s.charAt(i)]--;
            if (map[(int) s.charAt(i)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, left + minLen);
                }
                map[(int) s.charAt(left)]++;
                if (map[(int) s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }
        return res;
    }
}