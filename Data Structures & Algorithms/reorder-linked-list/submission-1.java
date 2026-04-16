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
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        
        ListNode curr = slow.next;
        ListNode pre = slow.next = null;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }

        ListNode res = head;
        while (pre != null){
            ListNode tmp1 = res.next;
            ListNode tmp2 = pre.next;
            res.next = pre;
            pre.next = tmp1;
            res = tmp1;
            pre = tmp2;  
        }
    }
}
