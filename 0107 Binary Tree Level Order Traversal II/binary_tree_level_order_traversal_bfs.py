# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        res = []
        curr = root
        if curr == None:
            return res
        q = [curr] # initialize the queue
        while (len(q) != 0):
            level = []
            length = len(q)
            for _ in range(length):
                curr = q.pop(0)
                level.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            res.insert(0, level)
        return res