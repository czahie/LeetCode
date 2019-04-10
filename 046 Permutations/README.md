#Permutations
+ [Backtracking Algorithms](https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning))
+ Recursion, remember to remove the added element at the end of the funtion.
+ `remove` methods are different in Java and Python. In Java, `remove` can remove an element directly or by index. When there's contradiction, removing by index takes the priority: `remove(1)` will remove the element at index 1 rather than element 1 in the list. If you want to remove element 1, you can `remove(new Integer(1))`. In Python, `remove` will always remove the element. If you want to remove by index, you should call `del list[index]`.
+ When adding the `currList` to `res`, remember to make a copy, or you will add the reference instead.
