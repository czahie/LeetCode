class Solution {
    public boolean isValidSudoku(char[][] board) {
        // initialize sets to make sure no duplicates
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] boxes = new Set[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i].contains(ch) || columns[j].contains(ch) || boxes[boxIndex].contains(ch)) {
                        return false;
                    }
                    rows[i].add(ch);
                    columns[j].add(ch);
                    boxes[boxIndex].add(ch);
                }
            }
        }
        return true;
    }
}