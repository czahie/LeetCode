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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<Integer> res, TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        if (currDepth >= res.size()) {
            res.add(root.val);
        }
        dfs(res, root.right, currDepth + 1);
        dfs(res, root.left, currDepth + 1);
    }
}