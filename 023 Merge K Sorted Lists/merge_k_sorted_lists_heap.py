# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from queue import PriorityQueue
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummy = ListNode(0);
        if not lists:
            return dummy.next
        p = dummy
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, id(l), l))
        while not q.empty():
            val, _, node = q.get()
            p.next = node
            p = p.next
            if node.next:
                q.put((node.next.val, id(node.next), node.next))
        return dummy.next
                
        