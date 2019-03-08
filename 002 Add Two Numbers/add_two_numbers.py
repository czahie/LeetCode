# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_head = ListNode(0)
        p = dummy_head
        carrier = 0
        while (l1 != None or l2 != None or carrier != 0):
            if l1 == None:
                num1 = 0
            else:
                num1 = l1.val
                l1 = l1.next
            if l2 == None:
                num2 = 0                
            else:
                num2 = l2.val
                l2 = l2.next
            total = num1 + num2 + carrier     
            num = total % 10
            carrier = total // 10
            p.next = ListNode(num)
            p = p.next
                
        return dummy_head.next