class Solution {
    public int maxRepOpt1(String text) {
        int res = 0;
        int[] count = new int[26];
        char[] t = text.toCharArray();
        for (int i = 0; i < t.length; i++) {
            count[t[i] - 'a']++;
        }
        for (int i = 0; i < t.length; i++) {
            char c = t[i];
            int cnt = 0;
            int diff = 0;
            int j = i;
            while (j < t.length && (c == t[j] || diff == 0) && cnt < count[c - 'a']) {
                if (c != t[j]) {
                    diff++;
                }
                cnt++;
                j++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}