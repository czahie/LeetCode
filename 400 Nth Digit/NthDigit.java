class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        // first number of this length
        int start = 1;
    
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        
        // find the number n is in
        int curr = start +  (n - 1) / len;
        int place = (n - 1) % len;
        return Character.getNumericValue(Integer.toString(curr).charAt(place));
    }
}