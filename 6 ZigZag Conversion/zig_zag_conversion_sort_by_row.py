class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1: # base case
            return s
        
        rows = [[] for _ in range(numRows)]
        going_up = True
        row = 0 
        for char in s:
            rows[row].append(char)
            if (row == 0 or row == numRows - 1): # change direction
                going_up = not going_up
            row += -1 if going_up else 1
        
        result = ""
        for row in rows:
            for char in row:
                result += char
        return result