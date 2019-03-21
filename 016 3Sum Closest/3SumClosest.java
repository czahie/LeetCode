class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        Arrays.sort(nums); // sort the array
        int res = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        int dist;
        int sum;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i != 0 && nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {  // two pointers
                    sum = nums[i] + nums[lo] + nums[hi];
                    dist = Math.abs(sum - target);
                    if (dist == 0) {
                        return target;
                    }
                    else if (sum < target) {
                        lo++;
                    } 
                    else {
                        hi--;
                    }
                    if (dist < minDist) { // update the min distance and result
                        minDist = dist;
                        res = sum;
                    }
                }
            }
        }
        return res;
    }
}