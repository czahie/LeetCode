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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> pred = new Stack<>();
        Stack<Integer> succ = new Stack<>();
        
        inorder(pred, root, target, true);
        inorder(succ, root, target, false);
        
        int count = 0;
        while (count < k) {
            if (pred.empty()) {
                res.add(succ.pop());
            } else if (succ.empty()) {
                res.add(pred.pop());
            } else if (Math.abs(pred.peek() - target) < Math.abs(succ.peek() - target)) {
                res.add(pred.pop());
            } else {
                res.add(succ.pop());
            }
            count++;
        }
        return res;
    }
    
    private void inorder(Stack<Integer> stack, TreeNode root, double target, boolean reverse) {
        if (root == null) {
            return;
        }
        inorder(stack, reverse? root.right: root.left, target, reverse);
        // early termination
        if ((reverse && root.val <= target) || (!reverse && root.val > target)) {
            return;
        }
        stack.push(root.val);
        inorder(stack, reverse? root.left: root.right, target, reverse);
    }
}