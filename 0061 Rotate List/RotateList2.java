/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        k = k % n;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n - k; i++) {
            fast = fast.next;
        }
        ListNode pivot = fast.next;
        fast.next = null;
        pivot = reverse(pivot);
        head = reverse(head);
        ListNode p1 = head;
        while (p1.next != null) {
            p1 = p1.next;
        }
        p1.next = pivot;
        return reverse(head);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}