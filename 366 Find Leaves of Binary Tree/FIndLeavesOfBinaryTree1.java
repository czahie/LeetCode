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
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, root);
        return res;
    }
    
    private int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int depth = Math.max(dfs(res, root.left), dfs(res, root.right)) + 1;
        List<Integer> currList;
        if (depth >= res.size()) {
            currList = new LinkedList<>();
            res.add(currList);
        } else {
            currList = res.get(depth);
        }
        currList.add(root.val);
        return depth;
    }
}