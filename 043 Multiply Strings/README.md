# Multiply Strings
+ [The best explanation](https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation)
+ 2 nums with length `m` and `n` respectively, the length of the product of 2 nums is at most `m + n` (9 * 9 + 9 < 100)
+ 2 digits at `num1[i] * num2[j]` will be placed at `product[i + j, i + j + 1]`. Notice to add the digit at the place originally
+ Update from the back to the front, we can get an arrya of integers. Convert the array to string, note the first zeros should be omitted
+ Java will initialize int arrays with zeros, Python will not