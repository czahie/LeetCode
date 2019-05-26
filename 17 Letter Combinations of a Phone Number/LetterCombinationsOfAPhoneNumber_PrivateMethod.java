import java.lang.Character;
class LetterCombinationsOfAPhoneNumber_PrivateMethod {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) { // base case
            return res;
        }
        
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (char c: digits.toCharArray()) {
            String s = map[Character.getNumericValue(c)];
            res = expand(res, s);
        }
        return res;
    }
    
    private List<String> expand(List<String> res, String s) {
        List<String> newRes = new LinkedList<>();
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                newRes.add(res.get(i) + s.charAt(j));
            }
        }
        return newRes;
    }
}