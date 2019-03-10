class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i); // center is i
            int len2 = expand(s, i, i + 1); // center is between i and i+1
            int len = Math.max(len1, len2);
            if (len > end - start) {    // find the place of the substring
                start  = i - (len - 1) / 2; 
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expand(String s, int left, int right) {
        int l = left;
        int r = right;
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) { // expand
            l--;
            r++;
        }
        return r - l - 1;
    }
}