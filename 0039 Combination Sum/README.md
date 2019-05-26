# Combination Sum
## some notations when backtracking
1. Add the current element, backtrack, and remove the current element.
2. When adding the current list to the result list, remember to make a copy, rather than itself. Because the current list may change later, and evetually become empty in most cases.
3. Using variables to keep track of if the current list solves the problem rather than checking every element everytime. This will reduce a lot of time.
4. For this problem, sorting the array first and keep moving numbers forward is also very important.