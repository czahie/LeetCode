#String to Integer (atoi)
+ Create a variable to store if a sign has been encountered
+ Iterate through the String, there are 4 cases: 1. whitespace, 2. '+' or '-', 3. digit, 4. other characters.
+ To check if an integer is going to be larger than `Integer.MAX_VALUE` after muptiplying `10`: `result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && num >= 7`
+