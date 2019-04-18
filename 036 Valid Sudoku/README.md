# Valid Soduku
+ Naive approach would be iterating the `board` 3 times.
+ To make 3 array of HashSets, we can check if the board is valid by iterating the board just 1 time.
+ The row index and column index is easy to specify, but the box index is not. We can set the box index `boxIndex = (row / 3) * 3 + column / 3` 