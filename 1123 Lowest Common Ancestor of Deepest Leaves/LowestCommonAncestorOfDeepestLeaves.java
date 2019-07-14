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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> levels = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr);
                if (curr.left != null) {
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
            levels.add(level);
        }
        Set<TreeNode> leaves = new HashSet<>(levels.get(levels.size() - 1));
        int count = leaves.size();
        while (count > 1) {
            Set<TreeNode> newLeaves = new HashSet<>();
            for (TreeNode l: leaves) {
                newLeaves.add(map.get(l));
            }
            leaves = newLeaves;
            count = leaves.size();
        }
        return leaves.iterator().next();
    
    }
}