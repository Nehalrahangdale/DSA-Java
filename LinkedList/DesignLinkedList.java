class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Get value at index
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    // Add node at beginning
    public void addAtHead(int val) {

        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;

        size++;
    }

    // Add node at end
    public void addAtTail(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;

        size++;
    }

    // Add node at given index
    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        // Insert at beginning
        if (index == 0) {
            addAtHead(val);
            return;
        }

        // Insert at end
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);

        Node curr = head;

        // Move to node before index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    // Delete node at given index
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node curr = head;

        // Move to node before index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
