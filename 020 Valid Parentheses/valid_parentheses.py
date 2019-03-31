class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        my_map = {')': '(', ']': '[', '}': '{'}
        for i in s:
            if i in my_map:
                if len(stack) == 0 or stack.pop() != my_map[i]:
                    return False
            else:
                stack.append(i)
        return len(stack) == 0