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
    public boolean hasCycle(ListNode head) {
        ListNode c1 = head;
        ListNode c2 = head;

        while (c1 != null && c1.next != null){
            c1 = c1.next.next;
            c2 = c2.next;
            if (c1 == c2) return true;
        }
        return false;
        
    }
}
