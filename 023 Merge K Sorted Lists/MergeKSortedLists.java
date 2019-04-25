/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.length < 1) {
            return dummy.next;
        }
        
        // initialize pq
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }  
        }
        
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode l = pq.poll();
            p.next = l;
            if (l.next != null) {
                pq.add(l.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}