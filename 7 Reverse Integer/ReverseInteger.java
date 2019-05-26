class Solution {
    public int reverse(int x) {
        int result = 0;        
        int remainder;
        int quotient = x;
        while (quotient != 0) {
            remainder = quotient % 10;
            quotient = quotient / 10;       
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && remainder > 7) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && remainder < -8) {
                return 0;
            }
            result = result * 10 + remainder;
        }        
        
        return result;
    }
}