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
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return maxLen;
        }
        dfs(root, 1, root.val);
        return maxLen;
    }
    
    private void dfs(TreeNode root, int currLen, int prev) {
        maxLen = Math.max(maxLen, currLen);
        if (root == null) {
            return;
        }
        if (root.val == prev + 1) {
            currLen++;
        } else {
            currLen = 1;
        }
        dfs(root.left, currLen, root.val);
        dfs(root.right, currLen, root.val);
    }
}