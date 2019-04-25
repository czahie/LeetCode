class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder curr, int left, int right, int n) {
        if (curr.length() == n * 2) {
            res.add(curr.toString());
        }
        if (left < n) {
            curr.append("(");
            backtrack(res, curr, left + 1, right, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (right < left) {
            curr.append(")");
            backtrack(res, curr, left, right + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }       
    }
}