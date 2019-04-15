# Next Permutation
+ From the end of the array to find the index `i` of the number that breaks the descending order (this is the number that could make the permutation a little larger).
+ If find, swap the number with the number after it and just larger than it.
+ Reverse the numbers after `i` anyway.
+ Note to use 2 while loops to avoid possible erros. Equality should be considered.