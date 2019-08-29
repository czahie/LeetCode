class Solution {
    public int myAtoi(String str) {
        int total = 0;
        int sign = 1;
        boolean hasSign = false;
        
        // get rid of leading whitespaces
        str = str.trim();
        
        // empty String
        if (str.length() == 0) {
            return total;
        }
        
        // check the sign
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '+' ? 1 : -1;
            hasSign = true;
        }
        
        for (int i = hasSign ? 1 : 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            // not a digit
            if (digit < 0 || digit > 9) {
                break;
            }
            // check overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            total = total * 10 + digit;
        }
        
        return total * sign;
    }
}