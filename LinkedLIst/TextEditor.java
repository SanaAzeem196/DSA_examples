import java.util.Scanner;

class Node
{
    char data;
    Node prev, next;
//creating head node of doubly linked list
    public Node(char data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}

class DoublyLinkedList
{
    private Node head,tail;
    private Node cursor;
//default constructor of the class "DoublyLinkedList"
    public DoublyLinkedList()
    {
        head=tail=cursor=null;
    }
//method for insertion of text (character by charatcer)
    public void insert(char ch)
    {
        Node newNode=new Node(ch);
        if (head==null) {
            head=tail=cursor=newNode;
        }
        else if(cursor== null)
        {
            tail.next=newNode;
            newNode.prev=tail;
            tail=cursor=newNode;
        } else
        {
            newNode.next=cursor.next;
            newNode.prev=cursor;
            if (cursor.next!= null)
            {
                cursor.next.prev=newNode;
            }
            cursor.next=newNode;
            if (cursor==tail) {
                tail=newNode;
            }
            cursor=newNode;
        }
    }

    public void delete()
    {
        if (cursor==null)
        {
            System.out.println("No character to delete at cursor position.");
            return;
        }

        if (cursor==head && cursor==tail)
        {
            head=tail=cursor=null;
        }
        else if(cursor == head)
        {
            head = cursor.next;
            head.prev = null;
            cursor = head;
        } else if (cursor == tail)
        {
            tail = cursor.prev;
            tail.next = null;
            cursor = tail;
        } else
        {
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = cursor.next;
        }
    }

    public void modify(char ch)
    {
        if (cursor == null)
        {
            System.out.println("No character to modify at cursor position.");
        } else
        {
            cursor.data = ch;
        }
    }

    public void moveLeft() {
        if (cursor != null && cursor.prev != null) {
            cursor = cursor.prev;
        } else {
            System.out.println("Cannot move left. Cursor is at the beginning.");
        }
    }

    public void moveRight()
    {
        if (cursor != null && cursor.next != null)
        {
            cursor = cursor.next;
        } else {
            System.out.println("Cannot move right. Cursor is at the end.");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            if (current == cursor) {
                System.out.print("[" + current.data + "]");
            } else {
                System.out.print(current.data);
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class TextEditor
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList editor = new DoublyLinkedList();
        boolean running = true;

        System.out.println("Simple Text Editor using Doubly Linked List");
        System.out.println("Commands: ");
        System.out.println("1: Insert Character");
        System.out.println("2: Delete Character");
        System.out.println("3: Modify Character");
        System.out.println("4: Move Cursor Left");
        System.out.println("5: Move Cursor Right");
        System.out.println("6: Display Text");
        System.out.println("7: Exit");

        while (running)
        {
            System.out.print("Enter command: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter character to insert: ");
                    char ch = scanner.nextLine().charAt(0);
                    editor.insert(ch);
                    break;
                case 2:
                    editor.delete();
                    break;
                case 3:
                    System.out.print("Enter new character: ");
                    char modChar = scanner.nextLine().charAt(0);
                    editor.modify(modChar);
                    break;
                case 4:
                    editor.moveLeft();
                    break;
                case 5:
                    editor.moveRight();
                    break;
                case 6:
                    System.out.print("Current text: ");
                    editor.display();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting the text editor.");
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        }
        scanner.close();
    }
}
