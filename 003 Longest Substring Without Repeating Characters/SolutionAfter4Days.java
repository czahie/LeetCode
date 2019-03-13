class SolutionAfter4Days {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) { // base case
            return n;
        }
        
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (i <= j && j < n) {
            Character ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                max = Math.max(max, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}