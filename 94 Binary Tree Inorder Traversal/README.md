# Binary Tree Inorder Traversal
## Recursive Approach
+ The result list of `Collections.emptyList()` and `List.of()` are **immutable**
+ Define a helper function that can modify the `res` list
+ First the left subtree, then the root itself, finally the right subtree 
+ In Java, use a static method inside the class; In Python, note the helper function needs `self` as a parameter

## Iterative Approach
+ The basic idea is using a stack to store the previous TreeNode, when the Node is `null`, pop from the stack, append the value to the `res` list, then set the pointer point to the right child node
+ Use 2 while loops, the outer one checks if the the Node is null or the stack is empty, the inner one checks if the node is null
