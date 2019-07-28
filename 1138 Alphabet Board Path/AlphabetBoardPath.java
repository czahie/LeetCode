class Solution {
    
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char[] chars = target.toCharArray();
        int prevRow = 0;
        int prevCol = 0;
        for (int k = 0; k < chars.length; k++) {
            char c = chars[k];
            int idx = c - 'a';
            int row = idx / 5;
            int col = idx % 5;
            if (c == 'z') {
                if (col >= prevCol) {
                    for (int j = prevCol; j < col; j++) {
                        sb.append('R');
                    }
                } else {
                    for (int j = prevCol; j > col; j--) {
                        sb.append('L');
                    }
                }
                if (row >= prevRow) {
                    for (int i = prevRow; i < row; i++) {
                        sb.append('D');
                    }
                } else {
                    for (int i = prevRow; i > row; i--) {
                        sb.append('U');
                    }
                }
            } else {
                if (row >= prevRow) {
                    for (int i = prevRow; i < row; i++) {
                        sb.append('D');
                    }
                } else {
                    for (int i = prevRow; i > row; i--) {
                        sb.append('U');
                    }
                }
                if (col >= prevCol) {
                    for (int j = prevCol; j < col; j++) {
                        sb.append('R');
                    }
                } else {
                    for (int j = prevCol; j > col; j--) {
                        sb.append('L');
                    }
                }
 
            }

            sb.append('!');
            prevRow = row;
            prevCol = col;
        }
        return sb.toString();
    }
}
