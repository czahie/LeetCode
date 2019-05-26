class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validRow(board) && validColumn(board) && validBox(board);
    }
    
    private boolean validRow(char[][] board) {
        // row
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            // column
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    }
                    set.add(ch);
                }   
            }
        
        }
        return true;
    }
    
    private boolean validColumn(char[][] board) {
        // column
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            // row
            for (int j = 0; j < board.length; j++) {
                char ch = board[j][i];
                if (ch != '.') {
                    if (set.contains(ch)) {
                        return false;
                    }
                    set.add(ch);
                }
            }
        }
        return true;  
    }
    
    private boolean validBox(char[][] board) {
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        char ch = board[x][y];
                        if (ch != '.') {
                            if (set.contains(ch)) {
                                return false;
                            }
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}