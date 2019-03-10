class LongestPanlindromicSubstring_brutalForce {
    public String longestPalindrome(String s) {
        int n = s.length(); 
        if (n <= 1) {  // base case
            return s;
        }
                
        // Set<String> set = new HashSet<>();
        int max = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subs = s.substring(i, j + 1);
                if (isPalindrome(subs)) {
                    if (max < subs.length()) {
                        res = subs;
                        max = subs.length();
                    }
                }
            }
        }
        return res; 
    }
        
    public boolean isPalindrome(String s) {
        String reversed = new StringBuffer(s).reverse().toString();
        return s.equals(reversed);
    }
}