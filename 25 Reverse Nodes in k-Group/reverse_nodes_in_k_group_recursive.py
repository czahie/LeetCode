# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k < 2:
            return head
        
        curr = head
        for _ in range(k):
            if not curr:
                return head
            curr = curr.next

        curr = self.reverseKGroup(curr, k)
        for _ in range(k):
            temp = head.next
            head.next = curr
            curr = head
            head = temp
        
        return curr