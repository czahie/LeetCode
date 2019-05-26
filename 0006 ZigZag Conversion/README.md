# ZigZag Conversion
## sort by row
+ First find the character in every row, then concatenate every row in order
+ Running time is O(n)
+ TreeMap is a sorted map in Java
+ In some cases, we can use list to replace (sorted) map. Specifically, when `key` is integer.
+ To iterate a `String` in Java, we can use "for each" method: `for (char c: s.toCharArray())`
+ When there's only single thread, `StringBuilder` is better than `StringBuffer`
+ Use a `boolean` to indicate if the direction is going up or going down

## visit by row
+ Need to calculate the character index of i^th row
+ First consider the first row and the last row
+ Then consider the inner row, the index of the characters are `k * (2 * numRows - 2) + i` and `(k + 1) * (2 * numRows - 2) - i`