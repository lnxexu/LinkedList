package circulardoublylinkedlist;


import java.util.Scanner;

public class ImplementCircularDoublyLinkedList{
    
    public static void Menu(){
        System.out.print("""
                         MENU
                         1. Insert node at beginning
                         2. Insert node at end
                         3. Insert node at middle
                         4. Delete node at beginning
                         5. Delete node at end
                         6. Delete node at middle
                         7. Display from Head to Tail
                         8. Display from Tail to Head
                         9. Node Count
                         10. Search node value
                         11. Exit
                         Choice: """);
    }
    

    public static void main(String[] args){
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        Scanner input = new Scanner(System.in);
        int data, pos;

        while(true){     
            Menu();
            switch(input.nextInt()){
                case 1:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    list.addToHead(data);
                    list.display();
                    System.out.println("");
                    break;
                } 
                case 2:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    list.addToTail(data);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 3:{
                    System.out.print("Enter Data: ");
                    data = input.nextInt();
                    System.out.println();
                    System.out.print("Enter Position: ");
                    pos = input.nextInt();    
                    list.addToMiddle(data, pos);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 4:{
                    list.deleteFromHead();
                    list.display();
                    System.out.println("");
                    break;
                }
                case 5:{
                    list.deleteFromTail();
                    list.display();
                    System.out.println("");
                    break;
                }
                case 6:{
                    System.out.print("Enter Position: ");
                    pos = input.nextInt();    
                    list.deleteFromMiddle(pos);
                    list.display();
                    System.out.println("");
                    break;
                }
                case 7:{
                    list.display();
                    System.out.println("");
                    break;
                }
                case 8:{
                    list.displayReverse();
                    System.out.println("");
                    break;
                }
                case 9 :{
                    list.getSize();
                    System.out.println("");
                    break;
                }
                case 10:{
                    System.out.print("Enter a number: ");
                    data = input.nextInt();
                    list.findOccurrencesWithOrdinal(data);
                    break;
                }
                case 11:{
                    return;
                }
                
                
            } 
            
        }
        
    }
}

