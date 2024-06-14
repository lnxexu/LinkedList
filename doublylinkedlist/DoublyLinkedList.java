/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doublylinkedlist;

/**
 *
 * @author ephix
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0; // To keep track of the size of the list

    // Node class for doubly linked list


    // Constructor
    public DoublyLinkedList() {
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
        newNode.next = head;
        newNode.previous = null;
        
        if (isEmpty()) {
            tail = newNode; // If list is empty, tail is also the new node
        } 
        else {
            head.previous = newNode;
        }
        
        head = newNode;
        size++;
    }

    // Add a node to the tail of the list
    public void addToTail(int input) {
        Node newNode = new Node();
        newNode.data = input;
        newNode.next = null;
        newNode.previous = tail;
        
        if (isEmpty()) {
            head = newNode; // If list is empty, head is also the new node
        } else {
            tail.next = newNode;
        }
        
        tail = newNode;
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

        if (head.next == null) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        size--;
    }

    // Delete a node from the tail of the list
    public void deleteFromTail() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (tail.previous == null) { // Only one node
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
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
        Node n;
        for(n=head; n!=null; n=n.next)            
            System.out.print("||" + n.data + "|| <-> ");
        
        System.out.print("/");
    }

    // Print the elements of the list in reverse order
    public void displayReverse() {
        Node n = tail.next;
         if(n == null){
             System.out.print("/");
         }
        for(n=tail; n!=null; n=n.previous){
            System.out.print(" <-> ||" + n.data + "||");
           
        }            
            
        
        
    }
    
    // Get the size of the list
    public void getSize() {
        System.out.print("The list has " + size + " nodes.");
    }
    
    public void findOccurrencesWithOrdinal(int data) {
        Node current = head;
        int position = 1;
        boolean found = false;

        while (current != null) {
            if (current.data == data) {
                found = true;
                System.out.println(data + " found at the " + getOrdinal(position) + " position.");
            }
            current = current.next;
            position++;
        }

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

   

