/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    // Same concept as your findmid()
    public ListNode findmid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            // +1 step
            slow = slow.next;

            // +2 steps
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle node
        ListNode midnode = findmid(head);

        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode curr = midnode;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // prev is now the head of reversed second half
        ListNode right = prev;

        // First half
        ListNode left = head;

        // Step 3: Compare both halves
        while (right != null) {

            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}
