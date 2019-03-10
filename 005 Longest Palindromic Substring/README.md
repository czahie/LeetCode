# Longest palindromic substring
+ Brutal force takes ![](http://latex.codecogs.com/gif.latex?\\O(n^3))
 running time 
+ Ssing a helper function to determine if a substring is palindromic, this takes O(n) time
+ Expanding around center is good enough to reduce the running time to ![](http://latex.codecogs.com/gif.latex?\\O(n^2))
+ There are `2n-1` centers in the string of length n, the center could be in between 2 letters
+ Note: be cautious about how to expand, the length of the substring, and how to determine the start and end of the substring