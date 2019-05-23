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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        TreeNode prevNode = null;
        while (!stack.empty() || currNode != null) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            if (prevNode != null && currNode.val <= prevNode.val) {
                return false;
            }
            prevNode = currNode;
            currNode = currNode.right;
        }
        return true;
    }
}