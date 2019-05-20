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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        boolean moveRight = true;
        TreeNode currNode;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> currList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                currNode = q.poll();
                if (moveRight) {
                    currList.add(currNode.val);
                } else {
                    currList.addFirst(currNode.val);
                }
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            res.add(currList);
            moveRight = !moveRight;
        }
        return res;
    }
}