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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int remain = len - n;
        ListNode right = new ListNode(0);
        ListNode nn = right;
        right.next = head;
        for (int i = 0; i < remain; i++) {
            right = right.next;
        }

        right.next = right.next.next;

        return nn.next;



    }
}
