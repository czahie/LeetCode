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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        inorder(res, root, target, k);
        return res;
    }
    
    private void inorder(List<Integer> res, TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }
        inorder(res, root.left, target, k);
        if (res.size() < k) {
            res.add(root.val);
        } else if (Math.abs(res.get(0) - target) > Math.abs(root.val - target)) {
            res.remove(0);
            res.add(root.val);
        } else {
            return;
        }
        inorder(res, root.right, target, k);
    }
}