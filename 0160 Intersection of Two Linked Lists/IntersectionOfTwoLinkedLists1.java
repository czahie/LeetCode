/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curr = headA;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = headA;
        ListNode slow = headB;
        ListNode fast = headB;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            curr.next = null;
            return null;
        }
        fast = headB;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        curr.next = null;
        return fast;
    }
}