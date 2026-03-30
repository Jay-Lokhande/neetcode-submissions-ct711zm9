/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (l1 != null || l2 != null || carry != 0) {

            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;

            int val = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;

            ListNode newNode = new ListNode(val);

            if (l1 != null) l1 = l1.next; 
            if (l2 != null) l2 = l2.next; 
            dummy.next = newNode;
            dummy = dummy.next;
        }

        return res.next;
    }
}
