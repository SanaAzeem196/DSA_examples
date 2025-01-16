class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void deleteNode(int position) {
        if (head == null) {
            return;
        }

        Node temp = head;

        if (position == 0) {
            if (head.next == head) {
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == head) {
            return;
        }

        Node next = temp.next.next;
        temp.next = next;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }


    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);

        System.out.println("Circular Linked List:");
        cll.printList();

        cll.deleteNode(2);
        System.out.println("After deleting node at position 2:");
        cll.printList();

        cll.deleteNode(0);
        System.out.println("After deleting head node:");
        cll.printList();
    }
}
