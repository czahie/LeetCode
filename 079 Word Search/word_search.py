class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word, 0):
                    return True
        return False
                
    def dfs(self, board, i, j, word, a):
        if a == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return False
        if board[i][j] != word[a]:
            return False
        
        temp = board[i][j]
        board[i][j] = False
        existed = self.dfs(board, i + 1, j, word, a + 1) or self.dfs(board, i - 1, j, word, a + 1) or \
        self.dfs(board, i, j + 1, word, a + 1) or self.dfs(board, i, j - 1, word, a + 1)
        board[i][j] = temp
        return existed