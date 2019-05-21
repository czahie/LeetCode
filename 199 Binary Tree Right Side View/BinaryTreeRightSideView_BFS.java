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
        if (root == null)  {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode currNode;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                currNode = q.poll();
                if (i == size - 1) {
                    res.add(currNode.val);
                }
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
        }
        return res;
    }
}