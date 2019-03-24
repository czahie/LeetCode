# Binary Tree Level Order Traversal II
## BFS
+ One simple idea is to traverse every level and store the values in order and return the reverse; Or just put every new level at the first of the result list
+ When you see a queue, you should realize it's bfs
+ To know the current level during bfs, store the length of the queue at the beginning of every level. Afterwards, it's a new level

## DFS
+ Use recursive dfs
+ The helper function should contains the result list, the root, and the level
+ Base case: when the root is `null`, return nothing.
+ If the level is larger than (or equal to) the length of the result list, insert a new level at the first of the result list
+ Because of the return order, to add a value, the statement should be like `res.get(res.size() - level - 1).add(root.val)`