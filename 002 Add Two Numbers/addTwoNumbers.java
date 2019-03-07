/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class assTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int digit1 = 0;
        int digit2 = 0;
        int sum;
        int carrier = 0;
        int num;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (true) {
            if (l1 == null && l2 == null && carrier == 0) {
                break;
            }
            digit1 = 0;
            digit2 = 0;
             if (l1 != null) {
                digit1 = l1.val;
                l1 = l1.next;
             }
            if (l2 != null) {
                digit2 = l2.val;
                l2 = l2.next;
            }
            sum = digit1 + digit2 + carrier;
            num = sum % 10;
            carrier = sum / 10;
            p.next = new ListNode(num);
            p = p.next;            
        }         
        return dummyHead.next;        
    }
}