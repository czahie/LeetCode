class Solution:
    def myAtoi(self, str: str) -> int:
        str = str.strip()
        is_negative = False
        encounter_sign = False
        res = 0
        for i in str:
            if not encounter_sign and i == ' ':
                continue
            elif not encounter_sign and i == '-':
                encounter_sign = True
                is_negative = True
            elif not encounter_sign and i == '+':
                encounter_sign = True
            elif not i.isdigit():
                break
            else:
                encounter_sign = True
                res = res * 10 + int(i)
        if is_negative:
            res = -res
        if res > 2147483647:
            return 2147483647
        elif res < -2147483648:
            return -2147483648
        else:
            return res
                
        