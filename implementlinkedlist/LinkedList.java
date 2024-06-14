package implementlinkedlist;

public class LinkedList {
    private int count = 0;                 // count is integer variable
    private final int  maxCount = 15;     // optional in other linkedlist implementations
    private Node head;                   // head is an object of the Node class
    
    public LinkedList(){                // constructor method used for initialization
        head = null;                    // the list is still empty
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public boolean isFull(){
        return count == maxCount;
    }
    //insert at the beginning
    public void addToHead(int input) {
        Node newNode = new Node(); // Create a new node
        newNode.data = input; // Set the data for the new node
        newNode.next = head; // Link the new node to the current head
        head = newNode; // Update the head to be the new node
        count++; // Increment the size of the list
    }

    
    //insert at the middle of the list
    public void addToMiddle(int input, int position){
        if(isEmpty()){ // Check if the list is empty
            addToHead(input); // Add to head when the list is empty List was empty, so the method call is halted
        } 
        else if(isFull()){
            System.out.println("List is full.");
        } 
        else {
            int counter = 1; // Counter to track current node position, starting at 1

            Node newNode = new Node(); // Step 1: Create a new node
            newNode.data = input; // Step 2: Set the data for the new node

            Node n = head;

            // Step 3: Traverse the list to find the node before the insertion point
            while(n != null && counter < position - 1) {
                n = n.next;
                counter++;
            }

            // If position is out of bounds, insert at the end of the list
            if(n == null || n.next == null) {
                System.out.println("Position is out of bounds. Adding to the end of the list.");
                addToTail(input); 
                return;
            }

            // Step 4: Insert the new node into the list
            newNode.next = n.next; // New node points to the current node's next
            n.next = newNode; // Current node points to the new node
        }
    }

    
    //insert at the end
    public void addToTail(int input) {
        Node newNode = new Node(); // Step 1: Create a new node
        newNode.data = input; // Step 2: Set the data for the new node
        newNode.next = null; // Step 3: Set the next of the new node to null since it will be the last node

        if (isEmpty()) { // Check if the list is empty
            head = newNode; // Set the head to the new node if the list is empty
        } else {
            Node current = head;

            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode; // Set the next of the last node to the new node
        }
    }


    
    //delete at the beginning
    public void deleteFromHead(){
        head = head.next;               /* Instructs head to point to the 2nd node
                                        Before any changes, head originally points to first 
                                        node while head.next points to the 2nd node. */
    }
    
    //delete at the middle
    public void deleteFromMiddle(int position) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (position <= 1) { // Handle deletion from head if position <= 1
            deleteFromHead();
            return;
        }

        Node current = head;
        int counter = 1;

        // Traverse to the node before the one to be deleted
        while (current != null && counter < position - 1) {
            current = current.next;
            counter++;
        }

        if (current == null || current.next == null) { // Position is out of bounds
            System.out.println("Position is out of bounds.");
            return;
        }

        // Bypass the node to be deleted
        current.next = current.next.next; // Remove the node at position

    }


    //delete at the end
    public void deleteFromTail() {
       if (head == null) { // List is empty
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) { // Only one node in the list
            head = null;
        } else {
            Node current = head;
            // Traverse to the second-to-last node
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null; // Remove reference to the last node
        }
        count--; // Decrement the size of the list
    }
        
  

    public void display(){
        Node n;
        for(n=head; n!=null; n=n.next)            
            System.out.print("|" + n.data + "| |-> ");
        
        System.out.print("/");
    }
    
    public void listCount(){
        System.out.print("The list has " + count + " nodes.");
    }
}