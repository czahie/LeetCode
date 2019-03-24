/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLevelOrderTraversal_DFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}