class LongestSubstringWithoutRepeatingChars{
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1 ) {
            return s.length();
        }
        
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length() && (i < s.length())) {
            Character hi = s.charAt(i);
            Character lo = s.charAt(j);
            if (set.contains(lo)) { 
                set.remove(hi);
                i++;             
            }
            else {
                set.add(lo);
                j++;
            } 
            max = Math.max(max, j - i);
            }   
        return max;       
    }
}