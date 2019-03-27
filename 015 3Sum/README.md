# 3 Sum
+ Basic idea: sort the array, iterate the array and use 2 pointers to find the solution
+ The running time is O(n^2)
+ To avoid duplicated solutions, check the duplicates in both outer and inner loops
+ For the outer loop, if the number is the same as the former one, continue
+ For the inner loop, after finding the solution, if the next `lo` or `hi` is as same as previous, continue