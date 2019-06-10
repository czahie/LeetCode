/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (second.next != null) {
            second = second.next;
            if (second.val != 9) {
                first = second;
            }
        }
        if (second.val != 9) {
            second.val++;
        } else {
            first.val++;
            first = first.next;
            while (first != null) {
                first.val = 0;
                first = first.next;
            }
        }
        if (dummy.val == 1) {
            return dummy;
        }
        return head;
    }
}