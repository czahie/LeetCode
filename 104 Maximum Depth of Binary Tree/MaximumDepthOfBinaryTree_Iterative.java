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
    private class ReturnType {
        private TreeNode node;
        private int depth;
        ReturnType(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<ReturnType> stack = new Stack<>();
        stack.push(new ReturnType(root, 1));
        int depth = 0;
        
        while (!stack.isEmpty()) {
            ReturnType curr = stack.pop();
            TreeNode currNode = curr.node;
            int currDepth = curr.depth;
            depth = Math.max(depth, currDepth);
            if (currNode.left != null) {
                stack.push(new ReturnType(currNode.left, currDepth + 1));
            }
            if (currNode.right != null) {
                stack.push(new ReturnType(currNode.right, currDepth + 1));
            } 
        }
        return depth;
    }
}