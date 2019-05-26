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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = remove(root, leaves);
            res.add(leaves);
        }
        return res;
    }
    
    private TreeNode remove(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }
        root.left = remove(root.left, leaves);
        root.right = remove(root.right, leaves);
        return root;
    }
}