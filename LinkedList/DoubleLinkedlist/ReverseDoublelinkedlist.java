/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {

                // Store next node
                Node next = curr.next;

                // Connect child with current
                curr.next = curr.child;
                curr.child.prev = curr;

                // Find the last node of child list
                Node temp = curr.child;

                while (temp.next != null) {
                    temp = temp.next;
                }

                // Connect child list with original next
                if (next != null) {
                    temp.next = next;
                    next.prev = temp;
                }

                // Remove child pointer
                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }
}
