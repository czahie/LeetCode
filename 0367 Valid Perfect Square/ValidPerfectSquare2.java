class Solution {
    public boolean isPerfectSquare(int num) {
        return (int) Math.sqrt(num) * (int) Math.sqrt(num) == num;
    }
}