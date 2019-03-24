# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.dfs(res, root, 0)
        return res
    
    def dfs(self, res, root, level):
        if root: 
            if level >= len(res):
                res.append([])
            self.dfs(res, root.left, level + 1)
            self.dfs(res, root.right, level + 1)
            res[level].append(root.val)