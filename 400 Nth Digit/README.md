# Nth Digit
+ Set some variables to store the length of numbers, the number of numbers with this length, and the first number of this length.
+ First, find the length n is in by iteration.Then find the number n is in. Finnally, find the digit in the number.
+ When calculating the number and the digit n is in, always deduct 1 from n first.
+ Remember to set count as `long` as count may exceed 2^31. And cast the number to `String` for it's easier to get the digit.