# Coin Change
+ Dynamic Programming
+ Let `dp[i]` be the least number of coins to make up amount of i, `dp[i]=min(dp[i], dp[i - coin])`
+ Let the number of coin be `k` and the amount be `n`, the running time ois `O(nk)`
+ Note: The dp should have the length of `n+1`, the first place is 0 and all the others shoule be initialized with the value `amount + 1` as the most number of coins to make up the amount is `amount`, the default value shoule be larger