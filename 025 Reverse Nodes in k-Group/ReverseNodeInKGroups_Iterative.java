/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode tail = dummy; 
        
        while (true) {
            int count = 0;
            // find the kth node if exist
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            
            // not enough listnodes
            if (tail == null) {
                break;
            }
        
            head = curr.next;
            // reverse k - 1 times
            while (count > 1) {
                // delete temp
                ListNode temp = curr.next;
                curr.next = temp.next;
                // insert temp
                temp.next = tail.next;
                tail.next = temp;
                count--;     
            }
            curr = head;
            tail = head;
            
        }
        return dummy.next;
    }
}