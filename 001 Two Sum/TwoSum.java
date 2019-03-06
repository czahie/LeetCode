class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
        }
        return null;  
    }
}