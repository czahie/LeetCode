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
        head = reverse(head);
        int carrier = 1;
        ListNode curr = head;
        int value = 0;
        while (curr != null) {
            value = curr.val + carrier;
            curr.val = value % 10;
            carrier = value / 10;
            if (carrier == 0) {
                break;
            }
            curr = curr.next;
        }
        head = reverse(head);
        if (carrier == 1) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            return dummy;
        }
        return head;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}