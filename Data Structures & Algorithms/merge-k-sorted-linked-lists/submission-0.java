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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode node: lists){
            minHeap.offer(node);
        }

        ListNode res = new ListNode();
        ListNode cur = res;
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if (node != null){
                ListNode tmp = node.next;
                node.next = null;
                cur.next = node;
                cur = cur.next;
                if(tmp != null) minHeap.offer(tmp);
            } 
        }

        return res.next;
    }
}
