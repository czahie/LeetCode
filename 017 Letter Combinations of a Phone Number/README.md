# Letter Combinations of a Phone Number
+ Use an array to store all the strings, update the `res` list while iterating through the digits
+ Add a empty string `""` to the `res` first to start the expanding process
+ If choose to use the iterative way, set the `res` to be a queue, poll the previous combinations and concatenate with new possible letters. 
+ Note the condition of the while loop is `while (res.peek().length() == i)`, `i` is the index of the current digit. If the condition is not satisfied, all the previous combinations have been updated