import java.util.*;
class ZigZagConversion_SortByRow_ArrayList {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int n = s.length();
        boolean goingUp = true;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(n, numRows); i++) {
            rows.add(new StringBuilder());
        }
        
        int curRow = 0;
        for (char ch: s.toCharArray()) {
            rows.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                goingUp = !goingUp;
            }
            curRow += goingUp? -1: 1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row: rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}