import java.util.*;
class ZigZagConversion_SortByRow_TreeMap {
    public String convert(String s, int numRows) {
        int n = s.length();
        boolean goingUp = true;
        Map<Integer, ArrayList<Character>> map = new TreeMap<>(); // use treemap to 
        int row = 0;
        for (int i = 0; i < n; i++) {
            
            if (map.containsKey(row)) {
                ArrayList<Character> lst = map.get(row);
                lst.add(s.charAt(i));
            }
            else {
                ArrayList<Character> lst = new ArrayList<>();
                lst.add(s.charAt(i));
                map.put(row, lst);
            }
            
            if (row == 0 || row == numRows - 1) {  // change direction
                goingUp = !goingUp;
            }
            
            if (!goingUp) {
                row++;
            }
            else {
                row--;
            }
        }
        
        StringBuffer result = new StringBuffer();
        for (Integer key: map.keySet()) {
            ArrayList<Character> lst = map.get(key);
            for (int i = 0; i < lst.size(); i++) {
                result.append(lst.get(i));
            }
        }
        return result.toString();
    }
}