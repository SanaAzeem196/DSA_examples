class SinglyLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // 1. Find the length of a given SLL
    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 2. Print the middle node of a given SLL
    public void printMiddleNode() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle node: " + slow.data);
    }

    // 3. Reverse a given SLL (A copy of original SLL should be retained)
    public SinglyLinkedList reverseCopy() {
        SinglyLinkedList reversedList = new SinglyLinkedList();
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;
            temp = temp.next;
        }
        return reversedList;
    }

    // 4. Remove duplicates from a sorted SLL
    public void removeDuplicates() {
        if (head == null) return;
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // 5. Merge two sorted SLL
    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        Node mergedTail = null;

        while (temp1 != null && temp2 != null) {
            Node newNode;
            if (temp1.data <= temp2.data) {
                newNode = new SinglyLinkedList().new Node(temp1.data);
                temp1 = temp1.next;
            } else {
                newNode = new SinglyLinkedList().new Node(temp2.data);
                temp2 = temp2.next;
            }
            if (mergedList.head == null) {
                mergedList.head = mergedTail = newNode;
            } else {
                mergedTail.next = newNode;
                mergedTail = newNode;
            }
        }

        while (temp1 != null) {
            mergedTail.next = new SinglyLinkedList().new Node(temp1.data);
            mergedTail = mergedTail.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            mergedTail.next = new SinglyLinkedList().new Node(temp2.data);
            mergedTail = mergedTail.next;
            temp2 = temp2.next;
        }

        return mergedList;
    }

    // 6. Delete complete SLL
    public void deleteList() {
        head = null;
    }

    // Utility functions
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(2);
        list1.insertAtEnd(3);

        System.out.println("Original List:");
        list1.display();

        System.out.println("Length of the list: " + list1.length());

        list1.printMiddleNode();

        System.out.println("Reversed List:");
        SinglyLinkedList reversedList = list1.reverseCopy();
        reversedList.display();

        System.out.println("List after removing duplicates:");
        list1.removeDuplicates();
        list1.display();

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(4);
        list2.insertAtEnd(6);

        System.out.println("Second List:");
        list2.display();

        System.out.println("Merged List:");
        SinglyLinkedList mergedList = SinglyLinkedList.merge(list1, list2);
        mergedList.display();

        list1.deleteList();
        System.out.println("First List after deletion:");
        list1.display();
    }
}
