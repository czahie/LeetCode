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
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        curr = dummy;
        ListNode[] nodes = new ListNode[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = curr;
            curr = curr.next;
        }
        int carrier = 1;
        int value = 0;
        for (int i = n; i >= 0; i--) {
            value = nodes[i].val + carrier;
            nodes[i].val = value % 10;
            carrier = value / 10;
        }
        if (dummy.val == 0) {
            return head;
        }
        return dummy;
    }
}