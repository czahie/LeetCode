class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m = len(num1)
        n = len(num2)
        res = [0] * (m + n)
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                p1 = i + j
                p2 = i + j + 1 
                pro = (ord(num1[i]) - 48) * (ord(num2[j]) -48) + res[p2]
                res[p2] = pro % 10
                res[p1] += pro // 10
        result = ""
        for i in res:
            if i == 0 and result == "":
                continue
            else:
                result += str(i)
        return "0" if result == "" else result