class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x == 0:
            return True
        elif x < 0 or x % 10 == 0:
            return False
        
        num = x
        reverse = 0
        while (num != 0):
            curr = num % 10
            num = num // 10
            reverse = reverse * 10 + curr
        return reverse == x