/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Find size of linked list
        int sz = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // Step 2: If nth node from end is HEAD
        if (n == sz) {
            head = head.next;
            return head;
        }

        // Step 3: Find the node before the node to delete
        int iToFind = sz - n;

        ListNode prev = head;
        int i = 1;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // Step 4: Delete nth node from end
        prev.next = prev.next.next;

        // Step 5: Return updated head
        return head;
    }
}
