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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode node = null;
        if (root.val > target) {
            node = root.left;
        } else {
            node = root.right;
        }
        if (node == null) {
            return res;
        }
        int another = closestValue(node, target);
        if (Math.abs(res - target) < Math.abs(another - target)) {
            return res;
        } else {
            return another;
        }
    }
}