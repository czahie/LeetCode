import java.util.ArrayList;
class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        int j = 0;
        int curr = 0;
        double median;
        while (i < n || j < m) {
            if (i == n) {
                curr = nums2[j];
                j++;
            }
            else if (j == m) {
                curr  = nums1[i];
                i++;
            }
            else if (nums1[i] >= nums2[j]) {
                curr = nums2[j];
                j++;             
            }
            else if (nums1[i] < nums2[j]) {
                curr = nums1[i];
                i++;
            }
            nums.add(curr);
        }
        int sum = m + n;
        if (sum % 2 == 1) {
            median = (nums.get(sum / 2));
        }
        else {
             median = (double) ((nums.get(sum / 2 - 1) + nums.get(sum / 2)) / 2.0);
        }
        return median;
    }
}