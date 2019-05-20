class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        // careful about the range
        for (int i = 0; i < nums.length - 3; i++) {
            // ignore duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((j > i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int remain = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == remain) {
                        Integer[] curr = {nums[i], nums[j], nums[start], nums[end]};
                        res.add(Arrays.asList(curr));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while(start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[start] + nums[end] < remain) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}