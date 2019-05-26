# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        dummy = ListNode(0)
        dummy.next = head
        curr = dummy
        while curr.next and curr.next.next:
            first = curr.next
            second = curr.next.next;
            first.next = second.next
            second.next = first
            curr.next = second
            curr = curr.next.next
        return dummy.next
            