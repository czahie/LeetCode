class longestPalindromicSubstring_10days {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int max = 0;
        int lo = 0;
        int hi = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > max) {
                max = len;
                lo = i - (len - 1)/ 2;
                hi = i + len / 2 + 1;
            }
        }
        return s.substring(lo, hi);
    
    }
    
    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}