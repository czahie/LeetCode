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
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return res;
    }
    
    private void dfs(TreeNode root, int currDepth) {
        if (root.left == null && root.right == null) {
            res = Math.min(res, currDepth);
        }
        if (root.left != null) {
            dfs(root.left, currDepth + 1);
        }
        if (root.right != null) {
            dfs(root.right, currDepth + 1);
        }  
    }
}