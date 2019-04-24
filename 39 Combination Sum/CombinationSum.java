class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] candidates, int remain, List<Integer> curr, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
        }
        
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            curr.add(num);
            backtrack(res, candidates, remain - num, curr, i);
            curr.remove(curr.size() - 1);
        }
        
    }
}