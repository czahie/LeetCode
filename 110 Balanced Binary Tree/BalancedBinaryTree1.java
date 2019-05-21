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
    public boolean isBalanced(TreeNode root) {
        return checkDepth(root) != -1;
    }
    
    private int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = checkDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}