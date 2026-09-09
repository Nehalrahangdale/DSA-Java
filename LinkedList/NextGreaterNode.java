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
import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        // Convert Linked List into ArrayList
        ArrayList<Integer> values = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int n = values.size();
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= values.get(i)) {
                stack.pop();
            }

            // Top is the next greater element
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            } else {
                ans[i] = 0;
            }

            // Put current element into stack
            stack.push(values.get(i));
        }

        return ans;
    }
}
