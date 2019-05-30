class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int n, int k, int start) {
        if (curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(res, curr, n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}