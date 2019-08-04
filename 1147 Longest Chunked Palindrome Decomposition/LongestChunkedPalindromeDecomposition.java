class Solution {
    public int longestDecomposition(String text) {
        int res = 0;
        String l = "";
        String r = "";
        int n = text.length();
        for (int i = 0; i < n; i++) {
            l = l + text.charAt(i);
            r = text.charAt(n - i - 1) + r;
            if (l.equals(r)) {
                res++;
                l = "";
                r = "";
            }
        }
        return res;

    }
}