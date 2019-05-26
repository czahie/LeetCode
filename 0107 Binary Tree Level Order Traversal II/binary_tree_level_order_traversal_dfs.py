# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.bfs(res, root, 0)
        return res
    
    def bfs(self, res, root, level):
        if (root == None):
            return
        if level >= len(res):
            res.insert(0, [])
        self.bfs(res, root.left, level + 1)
        self.bfs(res, root.right, level + 1)
        res[len(res) - level - 1].append(root.val)