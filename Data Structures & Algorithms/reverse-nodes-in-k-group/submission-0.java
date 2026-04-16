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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode prev = res;

        while (true){
            ListNode kth = getKth(prev, k);
            if (kth == null) break;
            
            ListNode newHead = kth.next;
            ListNode p = kth.next;
            ListNode c = prev.next;
            while (c != newHead){
                ListNode tmp = c.next;
                c.next = p;
                p = c;
                c = tmp;
            }

            ListNode t = prev.next;
            prev.next = kth;
            prev = t;
        }

        return res.next; 
    }

    private ListNode getKth(ListNode prev, int k){
        ListNode cur = prev;
        while (cur != null && k > 0){
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
