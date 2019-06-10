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
        if (head == null) {
            return head;
        }
        int carrier = helper(head);
        if (carrier == 0) {
            return head;
        }
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        return dummy;
    }
    
    private int helper(ListNode node) {
        if (node == null) {
            return 1;
        }
        int carrier = helper(node.next);
        int value = node.val + carrier;
        node.val = value % 10;
        return value / 10;
    }
}