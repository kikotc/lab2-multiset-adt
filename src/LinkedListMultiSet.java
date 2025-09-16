
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;


    public void add(int item) {
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node cur = front;
        Node prev = null;
        while (cur != null) {
            if (cur.item == item) {
                size -= 1;
                if (prev != null) {
                    prev.next = cur.next;
                }
                else {
                    front.next = cur.next;
                }
                return;
            }
            Node temp = cur.next;
            prev = cur;
            cur = temp;
            // If here, item not found
        }
    }

    public boolean contains(int item) {
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }


    public int count(int item) {
        int num_seen = 0;
        Node cur = front;
        while (cur != null) {
            if (cur.item == item) {
                num_seen += 1;
            }
            cur = cur.next;
        }
        return num_seen;
    }

    public int size() {
        return size;
    }
}
