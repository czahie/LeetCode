class Solution {
    public boolean exist(char[][] board, String word) {  
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, char[] word, int a) {
        if (a == word.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word[a]) {
            return false;
        }
        
        board[i][j] ^= 256; // bit mask
        boolean existed = exist(board, i + 1, j, word, a + 1) || 
            exist(board, i - 1, j, word, a + 1) ||
            exist(board, i, j + 1, word, a + 1) ||
            exist(board, i, j - 1, word, a + 1);
        board[i][j] ^= 256; // recover
        return existed;
    }
}