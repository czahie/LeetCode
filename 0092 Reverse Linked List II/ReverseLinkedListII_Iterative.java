/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr;
        ListNode nextTemp;
        // find the first node to be reversed;
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        curr = prev.next;
        for (int i = m; i < n; i++) {      
            nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }
        return dummy.next;
    }
}