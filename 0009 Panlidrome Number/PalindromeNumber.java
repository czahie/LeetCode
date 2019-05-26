class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // special case 
        if (x == 0) {
            return true;
        }
        // other base cases
        else if (x < 0 || x % 10 == 0) {
            return false;
        }
        
        // reverse the integer
        int reverse = 0;
        int curr;
        int num = x;
        while (num != 0 ) {
            curr = num % 10;
            num = num / 10;
            reverse = reverse * 10 + curr;
        }
        
        return reverse == x;
    }
}