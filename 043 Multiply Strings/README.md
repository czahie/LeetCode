# Multiply Strings
+ [The best explanation](https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation)
+ The length of the product of 2 nums with length `n` and `m` is at most `m + n` (9 * 9 + 9 < 100).
+ The 2 digits of the product from `num1[i] * num2[j]` will be placed at `product[i + j, i + j + 1]`. Note to add the digit at the place previously.
+ Update from end to the front, we can get an array of integers. Convert the array to string. Note the leading zeros should be omitted.
+ Java will initialize int arrays with zeros, Python will not.