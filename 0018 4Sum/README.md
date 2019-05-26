# 4Sum
+ For any `n > 2` sum problems, always sort the array first.
+ Careful about the range of every loop. The outermost loop should end at `nums.length - n + 1`.
+ Always check if it's the same number as the previous one.
+ In Java, to use `Arrays.asList`, you can either initialize an array `Integer[]` or just put all the numbers in the constructor. Remember you cannot use `int[]`.