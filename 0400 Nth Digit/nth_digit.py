class Solution:
    def findNthDigit(self, n: int) -> int:
        num_len = 1
        num_count = 9
        start = 1
        while (n > num_len * num_count):
            n -= num_len * num_count
            num_len += 1
            num_count *= 10
            start *= 10
            
        curr = start + (n - 1) / num_len
        place = (n - 1) % num_len
        return int(str(curr)[place])