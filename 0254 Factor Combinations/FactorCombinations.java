class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) {
            return res;
        }
        backtrack(res, new ArrayList<Integer>(), n, 2);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int remain, int start) {
        if (remain == 1) {
            if (curr.size() > 1) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = start; i <= (int) Math.sqrt(remain); i++) {
            if (remain % i != 0) {
                continue;
            }
            curr.add(i);
            backtrack(res, curr, remain / i, i);
            curr.remove(curr.size() - 1);
        }
        int i = remain;
        curr.add(i);
        backtrack(res, curr, remain / i, i);
        curr.remove(curr.size() - 1);
    }
}