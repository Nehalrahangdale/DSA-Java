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
    public ListNode partition(ListNode head, int x) {

        // List for nodes smaller than x
        ListNode smallDummy = new ListNode(0);
        ListNode small = smallDummy;

        // List for nodes greater than or equal to x
        ListNode largeDummy = new ListNode(0);
        ListNode large = largeDummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {
                small.next = curr;
                small = small.next;
            } else {
                large.next = curr;
                large = large.next;
            }

            curr = curr.next;
        }

        // Connect small list with large list
        small.next = largeDummy.next;

        // Important: end the list
        large.next = null;

        return smallDummy.next;
    }
}
