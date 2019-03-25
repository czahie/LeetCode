import java.lang.Character;
class LetterCombinationsOfAPhoneNumber_Iterative {
    public List<String> letterCombinations(String digits) {
        Queue<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) { // base case
            return (List) res; // cast the queue to the return type
        }

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String s = map[Character.getNumericValue(digits.charAt(i))];
            while (res.peek().length() == i) {
                String prev = res.poll();
                for (int j = 0; j < s.length(); j++) {
                    res.add(prev + s.charAt(j));
                }
            }
        }
        return (List) res;
    }
}