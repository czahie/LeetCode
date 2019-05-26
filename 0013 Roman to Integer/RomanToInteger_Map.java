class RomanToInteger_Map {
    public int romanToInt(String s) {
        Map<Character, Integer> nums = new HashMap<>();
        nums.put('M', 1000);
        nums.put('D', 500);
        nums.put('C', 100);
        nums.put('L', 50);
        nums.put('X', 10);
        nums.put('V', 5);
        nums.put('I', 1);
        
        int result = 0;
        char curr;
        char next;
        for (int i = 0; i < s.length() - 1; i++) {
            curr = s.charAt(i);
            next = s.charAt(i + 1);
            if (nums.get(curr) < nums.get(next)) {
                result -= nums.get(curr);
            }
            else {
                result += nums.get(curr);
            }
        }
        result += nums.get(s.charAt(s.length() - 1));
        return result;
    }
}