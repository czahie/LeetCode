class Solution:
    def reverse(self, x: int) -> int:
        negative = False
        if (x < 0):
            x = -x
            negative = True
        res = 0
        while x != 0 :
            remainder = x % 10
            x = x // 10
            res = res * 10 + remainder
            
        if negative:
            res = -res
            
        if -2147483648 <= res <= 2147483647:
            return res
        else:
            return 0