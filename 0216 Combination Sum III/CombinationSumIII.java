class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int k, int start, int remain) {
        if (curr.size() > k || remain < 0) {
            return;
        }
        if (curr.size() == k && remain == 0) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(res, curr, k, i + 1, remain - i);
            curr.remove(curr.size() - 1);
        }
    }
}