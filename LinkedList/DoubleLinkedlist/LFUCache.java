import java.util.*;

class LFUCache {

    // Node represents one cache entry
    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // Doubly Linked List
    class DLL {
        Node head;
        Node tail;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Add node at front
        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        // Remove node
        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove least recently used node
        Node removeLast() {

            if (tail.prev == head) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    // key -> Node
    HashMap<Integer, Node> keyMap;

    // frequency -> DLL
    HashMap<Integer, DLL> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (keyMap.size() == capacity) {

            DLL list = freqMap.get(minFreq);

            Node removedNode = list.removeLast();

            keyMap.remove(removedNode.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        keyMap.put(key, newNode);

        // New node always has frequency 1
        freqMap
            .computeIfAbsent(1, k -> new DLL())
            .addFirst(newNode);

        // Minimum frequency becomes 1
        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);

        // Remove from old frequency list
        oldList.remove(node);

        // If old list becomes empty
        if (oldList.isEmpty()) {

            freqMap.remove(oldFreq);

            // If this was minimum frequency
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        // Increase frequency
        node.freq++;

        // Add to new frequency list
        freqMap
            .computeIfAbsent(node.freq, k -> new DLL())
            .addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
