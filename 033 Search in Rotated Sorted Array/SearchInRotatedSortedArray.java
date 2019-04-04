class Solution {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length < 1) {
            return -1;
        }
        // find the rotated pivot
        int pivot = findPivot(nums);
        // not rotated
        if (pivot == 0) {
            return search(nums, 0, nums.length - 1, target);
        }
        if (target < nums[0]) {
            return search(nums, pivot, nums.length - 1, target);
        }
        return search(nums, 0, pivot - 1, target);
    }
    
    private int search(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
    
    private int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1< end) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid] > nums[start]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (end < nums.length - 1 && nums[end] > nums[end + 1]) {
            return end + 1;
        }
        if (start < nums.length - 1 && nums[start] > nums[start + 1]) {
            return start + 1;
        }
        return 0;
    }
}