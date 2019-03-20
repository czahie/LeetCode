import java.util.*;
class ZigZagConversion_8days {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) { // initialize the the array
            rows[i] = new StringBuilder();
        }
        int row = 0;
        boolean goingDown = false;
        for (char c: s.toCharArray()) {
            rows[row].append(c);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            if (goingDown) {
                row++;
            }
            else {
                row--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: rows) {
            result.append(sb);
        }
        return result.toString();       
    }
}