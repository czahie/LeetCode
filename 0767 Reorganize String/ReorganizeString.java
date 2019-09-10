class Solution {
    public String reorganizeString(String S) {
        char[] str = S.toCharArray();
        int n = str.length;
        int[] counter = new int[26];
        int maxCnt = 0;
        char maxChar = 'a';
        for (char c: str) {
            counter[c - 'a']++;
            // get the most frequent letter
            if (counter[c - 'a'] > maxCnt) {
                maxCnt = counter[c - 'a'];
                maxChar = c;
            }
        }
        char[] newStr = new char[n];
        int p = 0;
        // populate the most frequent letter on even positions
        for (p = 0; p < n; p += 2) {
            if (maxCnt > 0) {
                newStr[p] = maxChar;
                maxCnt--;
            } else {
                break;
            }
        }
        // early termination
        if (maxCnt > 0) {
            return "";
        }
        counter[maxChar - 'a'] = 0;
        // reset p to be on odd positions
        if (p >= n) {
            p = 1;
        }
        for (int i = 0; i < 26; i++) {
            int curr = counter[i];
            while (curr > 0) {  
                newStr[p] = (char) (i + 'a');
                curr--;
                p += 2;
                if (p >= n) {
                    p = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && newStr[i] == newStr[i - 1]) {
                return "";
            }
            sb.append(newStr[i]);
        }
        return sb.toString();
        
    }
}