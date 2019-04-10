class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>());
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> currList) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList)); // avoid adding a reference
            return;
        }
        for (int num: nums) {
            if (!currList.contains(num)) {
                currList.add(num);
                backtrack(res, nums, currList);
                currList.remove(currList.size() - 1); // remove(num) may remove the number at index = num
            }
        }
    }
}