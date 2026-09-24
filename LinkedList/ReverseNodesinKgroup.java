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

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKth(groupPrev, k);

            // Less than k nodes remaining
            if (kth == null) {
                break;
            }

            // Node after kth
            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode temp = curr.next;

                curr.next = prev;

                prev = curr;
                curr = temp;
            }

            // Save old first node
            ListNode temp = groupPrev.next;

            // Connect previous group to reversed group
            groupPrev.next = kth;

            // Move groupPrev to end of reversed group
            groupPrev = temp;
        }

        return dummy.next;
    }

    // Find kth node from groupPrev
    private ListNode getKth(ListNode curr, int k) {

        while (curr != null && k > 0) {

            curr = curr.next;
            k--;
        }

        return curr;
    }
}
