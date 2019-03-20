class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        for (String str: strs) {
            minLen = Math.min(minLen, str.length()); // get the min length of the str
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len); // set the prefix
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}