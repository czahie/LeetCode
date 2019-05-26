/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return binarySearch(nums, 0, nums.length - 1);   
    }
    
    private TreeNode binarySearch(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = binarySearch(nums, start, mid - 1);
        curr.right = binarySearch(nums, mid + 1, end);
        return curr;
    }
}