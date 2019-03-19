class RomanToInteger_Method {
    public int romanToInt(String s) {
        int result = 0;
        char curr;
        char next;
        for (int i = 0; i < s.length() - 1; i++) {
            curr = s.charAt(i);
            next = s.charAt(i + 1);
            if (getValue(curr) < getValue(next)) {
                result -= getValue(curr);
            }
            else {
                result += getValue(curr);
            }
        }
        result += getValue(s.charAt(s.length() - 1));
        return result;
    }
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}