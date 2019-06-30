class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        
        for (int i = 1; i < dp.length; i++) {
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            // first case, a new level
            dp[i] = dp[i - 1] + h;
            // second case, placed with the previous j ~ i - 1 books
            for (int j = i - 1; j > 0; j--) {
                w += books[j - 1][0];
                if (w > shelf_width){
                    break;
                }         
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }
        return dp[books.length];
    }
}