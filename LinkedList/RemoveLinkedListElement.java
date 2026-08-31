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
    public ListNode removeElements(ListNode head, int val) {

        // Remove matching nodes from the beginning
        while (head != null && head.val == val) {
            head = head.next;
        }

        // If list becomes empty
        if (head == null) {
            return null;
        }

        ListNode curr = head;

        while (curr.next != null) {

            if (curr.next.val == val) {
                // Remove the next node
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
