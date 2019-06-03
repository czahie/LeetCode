class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backtrack(pattern, 0, str, 0, map, set);
    }
    
    private boolean backtrack(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set){
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        
        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String s1 = map.get(c);
            if (!str.startsWith(s1, j)) {
                return false;
            }
            return backtrack(pattern, i + 1, str, j + s1.length(), map, set);
        } else {
            for (int k = j; k < str.length(); k++) {
                String s2 = str.substring(j, k + 1);
                if (set.contains(s2)) {
                    continue;
                }
                map.put(c, s2);
                set.add(s2);
                if (backtrack(pattern, i + 1, str, j + s2.length(), map, set)) {
                    return true;
                }
                map.remove(c);
                set.remove(s2);
            }
        }
        return false;
    }
}