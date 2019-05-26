class LongestCommonPrefix_HorizontalScanning {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
        }
        return prefix;
    }
    
    private String commonPrefix(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = str1.length();
        int m = str2.length();
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                prefix.append(str1.charAt(i));
            }
            else {
                break;
            }
            i++;
            j++;
        }
        return prefix.toString();
    }
}