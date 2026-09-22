import java.util.*;

class AllOne {

    // Node represents one frequency
    class Node {
        int count;
        HashSet<String> keys;

        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    // key -> frequency node
    HashMap<String, Node> map;

    // Dummy head and tail
    Node head;
    Node tail;

    public AllOne() {

        map = new HashMap<>();

        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
    }

    // Insert node between prev and next
    private void insertAfter(Node prev, Node node) {

        node.next = prev.next;
        node.prev = prev;

        prev.next.prev = node;
        prev.next = node;
    }

    // Remove node from DLL
    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {

        // Key doesn't exist
        if (!map.containsKey(key)) {

            Node firstNode = head.next;

            // Frequency 1 node doesn't exist
            if (firstNode == tail || firstNode.count != 1) {

                Node newNode = new Node(1);

                insertAfter(head, newNode);

                firstNode = newNode;
            }

            firstNode.keys.add(key);
            map.put(key, firstNode);
        }

        // Key already exists
        else {

            Node current = map.get(key);

            Node nextNode = current.next;

            // Need frequency current.count + 1
            if (nextNode == tail ||
                nextNode.count != current.count + 1) {

                Node newNode = new Node(current.count + 1);

                insertAfter(current, newNode);

                nextNode = newNode;
            }

            // Move key
            nextNode.keys.add(key);
            map.put(key, nextNode);

            current.keys.remove(key);

            // Remove empty frequency node
            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        }
    }

    public void dec(String key) {

        Node current = map.get(key);

        // Key has count 1
        if (current.count == 1) {

            current.keys.remove(key);

            map.remove(key);

            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        }

        // Count > 1
        else {

            Node prevNode = current.prev;

            // Need frequency current.count - 1
            if (prevNode == head ||
                prevNode.count != current.count - 1) {

                Node newNode = new Node(current.count - 1);

                insertAfter(prevNode, newNode);

                prevNode = newNode;
            }

            prevNode.keys.add(key);
            map.put(key, prevNode);

            current.keys.remove(key);

            // Remove empty node
            if (current.keys.isEmpty()) {
                removeNode(current);
            }
        }
    }

    public String getMaxKey() {

        if (tail.prev == head) {
            return "";
        }

        // Any key from maximum frequency node
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {

        if (head.next == tail) {
            return "";
        }

        // Any key from minimum frequency node
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
