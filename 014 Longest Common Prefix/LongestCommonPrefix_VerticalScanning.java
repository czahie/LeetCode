class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) { // choose the first str as the criterion
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) { 
                    // if i is the more than the length of strs[j] or ...
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}