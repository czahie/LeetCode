#Regular Expresion Matching
##Recursive is the intuitive method
+ Base case is the pattern `p.length() == 0`
+ Otherwise, set the boolean `firstMatch` to check if the first character is matched
+ 4 cases, when `p.length() == 0 && p.charAt(1) == '*'`, check `firstMatch == true`, else check `firstMatch == true`

##Dynamic Programming is a faster way
+ The basic idea is as same as the recursive way
+ Using a two-dimension array `dp` to store intermediate results
+ `dp[i, j]` represents if `s[i:]` and `p[j:]` match
+ Return `dp[0, 0]`
+ For Python3, using list comprehension to initialize the `dp` list 