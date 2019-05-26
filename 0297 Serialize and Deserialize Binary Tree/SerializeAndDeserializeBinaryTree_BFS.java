/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = ",";
    private static final String nullNode = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr == null) {
                sb.append(nullNode).append(spliter);
                continue;
            }
            sb.append(curr.val).append(spliter);
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(spliter);
        if (nodes[0].equals(nullNode)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        q.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = q.poll();
            if (!nodes[i].equals(nullNode)) {
                parent.left = new TreeNode(Integer.valueOf(nodes[i]));
                q.offer(parent.left);
            }
            i++;
            if (!nodes[i].equals(nullNode)) {
                parent.right = new TreeNode(Integer.valueOf(nodes[i]));
                q.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));