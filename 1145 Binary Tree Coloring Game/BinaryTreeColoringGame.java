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

    int left;
    int right;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        return Math.max(left, Math.max(right, n - left - right - 1)) > n / 2;
    }
    
    private int count(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int l = count(root.left, x);
        int r = count(root.right, x);
        if (root.val == x) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}