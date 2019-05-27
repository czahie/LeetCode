class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (i > 0 && nums2[i] == nums2[i - 1]) {
                continue;
            }
            int target = nums2[i];
            int start = 0;
            int end = nums1.length - 1;
            int mid;
            while (start + 1 < end) {
                mid = start + (end - start) / 2;
                if (nums1[mid] == target) {
                    set.add(target);
                    break;
                }
                if (nums1[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums1[start] == target) {
                set.add(target);
            }
            if (nums1[end] == target) {
                set.add(target);
            }
        }
        int[] res = new int[set.size()];
        int idx = 0;
        for (int n: set) {
            res[idx] = n;
            idx++;
        }
        return res;
    }
}