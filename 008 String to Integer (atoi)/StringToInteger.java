class StringToInteger {
    public int myAtoi(String str) {
        boolean negative = false;
        boolean sign = false;
        int result = 0;
        for (char ch: str.toCharArray()) {
            if (ch == ' ' && !sign) {
                continue;
            }
            else if (ch == '-' && !sign) {
                negative = true;
                sign = true;
                continue;
            }
            else if (ch == '+' && !sign) {
                sign = true;
                continue;
            }
            else if (!Character.isDigit(ch)) {
                break;
            }
            else {
                sign = true;
                int num = Character.getNumericValue(ch);
                if (negative && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && num >= 8)) {
                    return Integer.MIN_VALUE;
                }
                else if (!negative && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && num >= 7)) {
                    return Integer.MAX_VALUE;
                }
                result =  result * 10 + num;
            }           
        }
        if (negative) {
            result = -result;
        }
        return result;
    }
}