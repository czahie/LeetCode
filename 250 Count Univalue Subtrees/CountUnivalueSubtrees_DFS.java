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
        if (isUnival(root, root.val)) {
            res++;
        }
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return res;
    }
    
    private boolean isUnival(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return (root.val == val) && isUnival(root.left, val) && isUnival(root.right, val);
    } 
}