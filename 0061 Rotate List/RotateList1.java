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
        int n = 1;
        ListNode oldTail = head;
        while (oldTail.next != null) {
            n++;
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        ListNode newTail = head;
        k %= n;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}