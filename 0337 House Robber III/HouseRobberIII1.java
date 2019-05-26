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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> cache = new HashMap<>();
        return dfs(root, cache);
    }
    
    private int dfs(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += dfs(root.left.left, cache) + dfs(root.left.right, cache);
        }
        if (root.right != null) {
            val += dfs(root.right.left, cache) + dfs(root.right.right, cache);
        }
        val = Math.max(val + root.val, dfs(root.left, cache) + dfs(root.right, cache));
        return val;
    }
}