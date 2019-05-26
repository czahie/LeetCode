#Word Search
+ DFS, check every possible combinations
+ Write a helper function to do the DFS algorithm, note to specify the cases that the algorithm can be terminated
+ In Java, we can play a trick to avoid visiting the same cell twice. `board[i][j] ^= 256`. As ASCII code is from `[0, 255]`, and the binary value of 256 is `100000000`, the result of this operation would be larger than 256, none of any ASCII code would match. Afterwards, the value must be recovered by the same operation
