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
        ListNode fast = head, slow = head, pre = null;
        int count = n;
        while (count > 0){
            fast = fast.next;
            count--;
        }

        while (fast != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = slow.next;
        }
        
        return head;
    }
}
