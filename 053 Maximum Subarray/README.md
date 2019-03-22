# Maximum Subarray
+ Use 2 variables to keep track of globalMax and maxEndHere,respectively
+ At index `i`, if the `maxEndHere + nums[i] < nums[i]` (acutally `maxEndHere < 0`), set `maxEndHere = nums[i]`. `maxEndHere = maxEndHere + nums[i]` , otherwise.