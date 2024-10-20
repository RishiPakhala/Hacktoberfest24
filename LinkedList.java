import java.util.Scanner;

class LinkedList {
    // Node class to represent each element of the linked list
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node of the linked list
    private Node head = null;

    // Method to create a new node and add it to the linked list
    public void createNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If list is empty, make newNode the head
        } else {
            Node temp = head;
            while (temp.next != null) { // Traverse to the end of the list
                temp = temp.next;
            }
            temp.next = newNode; // Append the new node
        }
        System.out.println("Node added: " + data);
    }

    // Method to delete a node from the linked list
    public void deleteNode(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data) {
            head = head.next; // If the head needs to be deleted
            System.out.println("Node deleted: " + data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next; // Traverse to find the node to delete
        }
        if (temp.next == null) {
            System.out.println("Node not found: " + data);
        } else {
            temp.next = temp.next.next; // Delete the node
            System.out.println("Node deleted: " + data);
        }
    }

    // Method to display all nodes in the linked list
    public void displayNodes() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data;

        while (true) {
            System.out.println("\n1. Create Node\n2. Delete Node\n3. Display Nodes\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data for new node: ");
                    data = sc.nextInt();
                    list.createNode(data);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    data = sc.nextInt();
                    list.deleteNode(data);
                    break;
                case 3:
                    list.displayNodes();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
