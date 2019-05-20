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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> sumQ = new LinkedList<>();
        TreeNode currNode;
        int currSum;
        nodeQ.offer(root);
        sumQ.offer(root.val);
        while(!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            for (int i = 0; i < size; i++) {
                currNode = nodeQ.poll();
                currSum = sumQ.poll();
                if (currNode.left == null && currNode.right == null) {
                    sum += currSum;
                }
                if (currNode.left != null) {
                    nodeQ.offer(currNode.left);
                    sumQ.offer(currSum * 10 + currNode.left.val);
                }
                if (currNode.right != null) {
                    nodeQ.offer(currNode.right);
                    sumQ.offer(currSum * 10 + currNode.right.val);
                }
            }
        }
        return sum;
    }
}