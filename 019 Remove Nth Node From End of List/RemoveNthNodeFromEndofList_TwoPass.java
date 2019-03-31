/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNthNodeFromEndofList_TwoPass {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int total = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            total++;
        }        
        
        p = dummy;
        for (int i = 0; i < total - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}