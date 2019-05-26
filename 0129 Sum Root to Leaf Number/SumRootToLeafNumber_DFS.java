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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root == null) {
            return sum;
        }
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int currSum) {
        currSum = currSum * 10 + root.val; 
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, currSum);
        }
        if (root.right != null) {
            dfs(root.right, currSum);
        }
    }
}