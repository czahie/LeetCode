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
    
    private Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        return helper(0, preorder.length);
    }
    
    private TreeNode helper(int start, int end) {
        if (start >= end) {
            return null;
        }
        
        TreeNode root = new TreeNode(this.preorder[preIndex]);
        int inIndex = this.map.get(root.val);
        
        preIndex++;
        root.left = helper(start, inIndex);
        root.right = helper(inIndex + 1, end);
        return root;
    }
}