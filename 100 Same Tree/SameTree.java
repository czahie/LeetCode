/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        boolean leftIsSameTree = isSameTree(p.left, q.left);
        boolean rightIsSameTree = isSameTree(p.right, q.right);
        return p.val == q.val && leftIsSameTree && rightIsSameTree;
    }
}