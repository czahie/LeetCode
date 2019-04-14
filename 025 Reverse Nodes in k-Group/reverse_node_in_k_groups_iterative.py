# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k < 2:
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        curr = dummy
        tail = dummy
        
        while True:
            count = 0
            while count < k and tail:
                tail = tail.next;
                count += 1
            
            # insufficient k nodes
            if not tail:
                break

            # for next cycle 
            head = curr.next
            while count > 1:
                # delete temp
                temp = curr.next
                curr.next = temp.next
                # insert temp
                temp.next = tail.next
                tail.next = temp;
                count -= 1
            # for next loop
            curr = tail = head
        return dummy.next