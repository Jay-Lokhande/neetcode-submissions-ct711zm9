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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode temp = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode next = null;
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode dummy = new ListNode(0);
        boolean flag = true;
        while(temp != null) {
            if (flag) {
                dummy.next = temp;
                temp = temp.next;
                dummy = dummy.next;
                flag = !flag;
            } else if (prev != null){
                dummy.next = prev;
                prev = prev.next;
                dummy = dummy.next;
                flag = !flag;
            } 
            if (prev == null) break;
        }

    }
}
