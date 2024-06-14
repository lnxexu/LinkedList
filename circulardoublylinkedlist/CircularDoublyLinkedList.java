package circulardoublylinkedlist;

public class CircularDoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;


    // Constructor
    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a node to the head of the list
    public void addToHead(int input) {
        Node newNode = new Node();
        newNode.data = input;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular link
            newNode.previous = tail;
        } else {
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    // Add a node to the tail of the list
    public void addToTail(int input) {
        Node newNode = new Node();
        newNode.data = input;

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular link
            newNode.previous = tail;
        } else {
            newNode.next = head;
            newNode.previous = tail;
            tail.next = newNode;
            head.previous = newNode;
            tail = newNode;
        }
        size++;
    }

    // Add a node to a specific position in the list
    public void addToMiddle(int input, int position) {
        if (position <= 1) {
            addToHead(input);
            return;
        }
        if (position > size) {
            addToTail(input);
            return;
        }

        Node newNode = new Node();
        newNode.data = input;

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.previous = current;
        current.next.previous = newNode;
        current.next = newNode;

        size++;
    }

    // Delete a node from the head of the list
    public void deleteFromHead() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = tail;
            tail.next = head;
        }

        size--;
    }

    // Delete a node from the tail of the list
    public void deleteFromTail() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
        }

        size--;
    }

    // Delete a node from a specific position in the list
    public void deleteFromMiddle(int position) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (position <= 1) {
            deleteFromHead();
            return;
        }
        if (position >= size) {
            deleteFromTail();
            return;
        }

        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
    }

    // Print the elements of the list
    public void display() {
        if (isEmpty()) {
            System.out.println("/");
            return;
        }

        Node n = head;
        do {
            System.out.print("||" + n.data + "|| <-> ");
            n = n.next;
        } while (n != head);
        System.out.println("(head)");
    }

    // Print the elements of the list in reverse order
    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("/");
            return;
        }

        Node n = tail;
        do {
            System.out.print(" <-> ||" + n.data + "||");
            n = n.previous;
        } while (n != tail);
        System.out.println("(tail)");
    }

    // Get the size of the list
    public void getSize() {
        System.out.println("The list has " + size + " nodes.");
    }

    public void findOccurrencesWithOrdinal(int data) {
        if (isEmpty()) {
            System.out.println(data + " not found in the list.");
            return;
        }

        Node current = head;
        int position = 1;
        boolean found = false;

        do {
            if (current.data == data) {
                found = true;
                System.out.println(data + " found at the " + getOrdinal(position) + " position.");
            }
            current = current.next;
            position++;
        } while (current != head);

        if (!found) {
            System.out.println(data + " not found in the list.");
        }
    }

    // Convert number to ordinal string
    public static String getOrdinal(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }

        int mod100 = number % 100;

        if (mod100 >= 11 && mod100 <= 13) {
            return number + "th";
        }

        switch (number % 10) {
            case 1: return number + "st";
            case 2: return number + "nd";
            case 3: return number + "rd";
            default: return number + "th";
        }
    }
}
