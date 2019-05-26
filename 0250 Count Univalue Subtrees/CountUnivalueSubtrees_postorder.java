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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return res;
        }
        isUnival(root, -1);
        return res;
    }
     
    private boolean isUnival(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (!isUnival(root.left, root.val) | !isUnival(root.right, root.val)) {
            return false;
        }
        res++;
        return root.val == val;
    }
}