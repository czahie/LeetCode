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
    public int kthSmallest(TreeNode root, int k) {
        int cnt = count(root.left);
        if (cnt >= k) {
            return kthSmallest(root.left, k);
        } else if (cnt + 1 < k) {
            return kthSmallest(root.right, k - 1 - cnt);
        }
        return root.val;
    }
    
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}